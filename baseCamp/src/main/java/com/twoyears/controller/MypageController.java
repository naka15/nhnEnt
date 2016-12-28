package com.twoyears.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.Paging;
import com.twoyears.model.dto.RequestDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.modelDAO.UserServiceInterface;

@Controller
public class MypageController {
	  
		@Autowired
		private UserServiceInterface userservice;
	
	
		   @RequestMapping(value="/mypage.do", method=RequestMethod.GET)
		   public String MyPage(HttpSession session){
				 UsersDTO user = (UsersDTO) session.getAttribute("userDTO");
				 
					if(user==null){
						System.out.println("로그인해야함");
						return "login";
					}
					else{
						return "mypage";
					}
		      
		      
		   }
		   
		
		   @RequestMapping(value="/modifyinfo.do", method=RequestMethod.GET)
		   public String GetModifyPage(){
		      return "modifyinfo";
		   }


		   @RequestMapping(value="/modifyinfo.do", method=RequestMethod.POST)
		   public String PostModifyPage(UsersDTO user){
		      String userId = user.getUserId();
		      String userNick = user.getUserNick();
		      String userEmail = user.getUserEmail();
		      
		      String userPwd = user.getUserPwd();
		      String userName = user.getUserName();
		      String userPhone = user.getUserPhone();
		      
		      System.out.println(user);
		      
		      
		      UsersDTO usermember = userservice.userSelectByEmail(userEmail);
		      UsersDTO usermember1= userservice.selectByuserNick(userNick);
		      
		      if(usermember!=null || usermember1!=null){
		         return "mypage";
		      }else{
		         
		    	  userservice.userUpdate(userId, userPwd, userName, userNick, userPhone, userEmail);

		         System.out.println("정보 수정성공");
		         return "redirect:/mypage.do";
		      }
		   }
		   
		   
		   @RequestMapping(value="/out.do", method=RequestMethod.GET)
		   public String outPage(){
		      return "memberout";
		   }
		   
		   @RequestMapping(value="/bye.do", method=RequestMethod.GET)
		   public String byePage(HttpSession session){
		      UsersDTO user= (UsersDTO)session.getAttribute("userDTO");
		      String userId =user.getUserId();
		      int ret = userservice.userDelete(userId);
		      System.out.println("삭제 성공");

		      return "redirect:/login.do";
		   }
		   
	
		   
		   @RequestMapping(value="/mycontent.do", method=RequestMethod.GET)
		   public ModelAndView myContent(HttpSession session, String pageNo, String requestpageNo){
		      ModelAndView mv = new ModelAndView();
		      Paging paging = new Paging();
		      Paging requestpaging= new Paging();
		      int totalCount;
		      int requesttotalCount;
		      
		   // 페이지번호 처음 요청시엔 null, 게시판 하단 페이지 번호 눌렀을 때 값 저장
		      if (pageNo == null) {
		         paging.setPageNo(1);
		      } else {
		         paging.setPageNo(Integer.parseInt(pageNo));
		      }
		      
		      if (requestpageNo == null) {
			         requestpaging.setPageNo(1);
			      } else {
			         requestpaging.setPageNo(Integer.parseInt(requestpageNo));
			      }
		      int pagenum = paging.getPageNo();
		      int low = (pagenum - 1) * 5 + 1;
		      int high = low + 4;

		      int requestpagenum= requestpaging.getPageNo();
		      int requestlow = (requestpagenum-1) * 5 +1;
		      int requesthigh = requestlow+4;
		      
		      UsersDTO user= (UsersDTO)session.getAttribute("userDTO");
		      String userId =user.getUserId();
		      System.out.println(userId);
		      //기부 게시물
		      List<NoticeDTO> noticelist = userservice.userSelectByMyWirte(userId);
		      totalCount=noticelist.size();
		      noticelist=userservice.userSelectByMyWriteP(userId,low,high);
		      paging.setPageSize(5);
		      paging.setTotalCount(totalCount);
		      
		      mv.addObject("paging",paging);
		      
		      
		      //요청 게시물
		      List<RequestNoticeDTO> requestlist = userservice.userSelectByMyRequestWirte(userId);
		      requesttotalCount=requestlist.size();
		      requestlist=userservice.userSelectByMyRequestWirteP(userId, requestlow,requesthigh);
		      requestpaging.setPageSize(5);
		      requestpaging.setTotalCount(requesttotalCount);
		      
		      mv.addObject("requestpaging",requestpaging);
		      
		      
		      
		      mv.addObject("noticelist", noticelist);
		      mv.addObject("requestlist", requestlist);
		      mv.setViewName("mycontent");
		      
		      return mv;
		   }
		   
		   
		   

		}

	

