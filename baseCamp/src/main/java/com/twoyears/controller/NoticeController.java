package com.twoyears.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.BookDTO;
import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.ReplyDTO;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.modelDAO.UserServiceInterface;

@Controller
public class NoticeController {
	
	@Autowired
	private UserServiceInterface userservice;
	
	@RequestMapping(value="/boardWrite.do", method=RequestMethod.GET)
	public String noticeWriteGet(HttpSession session){
		 System.out.println(session);
		 UsersDTO user = (UsersDTO) session.getAttribute("userDTO");
		 
		if(user==null){
			System.out.println("로그인해야함");
			return "login";
		}
		else{
			return "boardWrite";
		}
	}
	
	
	@RequestMapping(value = "/boardWrite.do", method = RequestMethod.POST)
	   public String noticeWritePost(NoticeDTO notice, BookDTO book,
	         HttpServletRequest request) throws ParseException {
		System.out.println(book);
	      System.out.println("-0----------------  "
	            + book.getPic().getOriginalFilename());
	      // books과 notice의 noticeno primarykey를 일치시키기 위해 미리 sequence 가져옴
	      // 그림파일 업로드 시 파일명을 primarykey로 일치시
	      int nextval = userservice.selectBynextVal();

	      if (book.getPic() != null) {
	         String path = request.getSession().getServletContext()
	               .getRealPath("/resources/bookImg");
	         CommonsMultipartFile file = book.getPic();
	         String fileName = file.getOriginalFilename();
	         fileName = fileName.substring(fileName.length() - 4,
	               fileName.length());
	         
	         // jpg파일이나 gif 파일만 받음
	         if (fileName.equals(".jpg") || fileName.equals(".gif")) {
	            book.setBookPic(nextval + fileName);
	            FileOutputStream fo = null;

	            try {
	               fo = new FileOutputStream(path + "/" + nextval+fileName);
	               fo.write(file.getBytes());
	               fo.close();
	            } catch (FileNotFoundException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	         }
	         else{
	            System.out.println("jpg or gif 파일 아님");
	         }

	      }

	      notice.setNoticeNo(nextval);
	      book.setNoticeNo(nextval);
	      // notice.setNoticeDate(noticeDate);

	      String userNick = request.getParameter("userId");
	      UsersDTO users = userservice.selectByuserNick(userNick);
	      notice.setUserId(users.getUserId());

	      int noticeRet = userservice.insertNotice(notice);
	      System.out.println(noticeRet);
	      int bookRet = userservice.insertBook(book);
	      System.out.println(bookRet);
	      if (noticeRet != 1 && bookRet != 1) {
	         System.out.println("실패");
	         return "boardWrite";
	      }

	      return "redirect:/board2-1.do";

	   }
	
	
	@RequestMapping(value="/boardRead.do")
	public ModelAndView noticeReadGet(String noticeNo){
		int num = Integer.parseInt(noticeNo);
		ModelAndView mv = new ModelAndView();
		
		
		List<ReplyDTO> listCmt = userservice.selectReplyList(num);

		NoticeDTO notice = userservice.selectBynoticeAll(num);
		BookDTO book = userservice.selectByBookAll(num);
		
		int count = notice.getNoticeCount() + 1;
		System.out.println(count);
		int ret = userservice.updateCount(count, notice.getNoticeNo());
		
		System.out.println(ret);
		
		String userId = notice.getUserId();
		UsersDTO users = userservice.selectByuserId(userId);

		
		
		mv.addObject("noticeAll", notice);
		mv.addObject("bookAll", book);
		mv.addObject("userAll", users);
		mv.addObject("listCmt", listCmt);
		mv.setViewName("boardRead");
		
		
		
		return mv;
	}
	
	
	@RequestMapping(value="deleteNotice.do", method=RequestMethod.GET)
	public String deleteNotice(int noticeNo){
		int noticenum = noticeNo;
		int ret = userservice.deleteNotice(noticenum);
		int bookdelete = userservice.deleteBook(noticenum);
		
		if(ret!=1){
			System.out.println("게시판 삭제 실패"+ ret);
			return "board2-1.do";
		}
		
		System.out.println("게시판삭제 성공"+ ret + bookdelete);
		return "redirect:board2-1.do";
	}
	
	
	

	
	

}
