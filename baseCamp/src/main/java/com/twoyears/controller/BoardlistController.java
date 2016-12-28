package com.twoyears.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.board.BoardServiceInterface;
import com.twoyears.model.dto.BoardBookDTO;
import com.twoyears.model.dto.Paging;

@Controller
public class BoardlistController {
	

	   @Autowired
	   BoardServiceInterface boardservice;

	   @RequestMapping(value = "/board2-1.do", method = RequestMethod.GET)
	   public ModelAndView board(String genre, String pageNo, String searchopt,
	         String searchtext) {
		   
		   System.out.println(genre);
	      String str = "board2-1";
	      List<BoardBookDTO> notice = new ArrayList<BoardBookDTO>();
	      ModelAndView mv = new ModelAndView();
	      Paging paging = new Paging();
	      int totalCount;
	      // 페이지번호 처음 요청시엔 null, 게시판 하단 페이지 번호 눌렀을 때 값 저장
	      if (pageNo == null) {
	         paging.setPageNo(1);
	      } else {
	         paging.setPageNo(Integer.parseInt(pageNo));
	      }

	      int pagenum = paging.getPageNo();
	      int low = (pagenum - 1) * 10 + 1;
	      int high = low + 9;

	      System.out.println("searchopt--------------" + searchopt + ":jjjj"
	            + genre);

	      // searchopt(검색 시 선택했던 목록(제목, 내용, 작성자 등)) 별로 디비로부터 데이터 가져오기
	      /*if (searchopt != null ) {
	         // 한글깨짐 해결 코드, 8byte로 바꿔서 다시 utf-8로 인코딩
	         try {
	            searchtext = new String(searchtext.getBytes("8859_1"), "utf-8");
	         } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }*/
	      
	      
	      System.out.println("searchtext-------------" + searchtext);
	      if (genre == null) {
	         genre = "";
	      } else {
	     
	           /* genre = new String(genre.getBytes("8859_1"), "utf-8");*/
	            System.out.println(genre);
	       
	      }
	      System.out.println("--------------------------- genre" + genre);
	      if (searchopt != null && searchopt.equals("title")) {// 제목으로 검색
	         notice = boardservice.selectByTitle(genre, searchtext, low, high);
	         totalCount = boardservice.selectByTitleCount(genre, searchtext);
	         System.out.println(totalCount);
	         mv.addObject("genre", genre);
	         mv.addObject("searchopt", searchopt);
	         mv.addObject("searchtext", searchtext);
	         mv.addObject("notice", notice);
	      }// 내용으로검색
	      else if (searchopt != null && searchopt.equals("content")) {
	         notice = boardservice.selectByContent(genre, searchtext, low, high);
	         totalCount = boardservice.selectByContentCount(genre, searchtext);
	         mv.addObject("genre", genre);
	         mv.addObject("searchopt", searchopt);
	         mv.addObject("searchtext", searchtext);
	         mv.addObject("notice", notice);
	      } else if (searchopt != null && searchopt.equals("user")) {// 작성자Nick으로
	                                                   // 검색
	         notice = boardservice.selectByUser(genre, searchtext, low, high);
	         totalCount = boardservice.selectByUserCount(genre, searchtext);
	         mv.addObject("genre", genre);
	         mv.addObject("searchopt", searchopt);
	         mv.addObject("searchtext", searchtext);
	         mv.addObject("notice", notice);
	      } else {
	         notice = boardservice.selectByRownum(genre, low, high);
	         totalCount = boardservice.selectCount(genre);
	         mv.addObject("genre", genre);
	         mv.addObject("notice", notice);
	      }

	      paging.setPageSize(10);
	      paging.setTotalCount(totalCount);

	      mv.addObject("notice", notice);
	      mv.addObject("paging", paging);
	      mv.addObject("str", str);
	      mv.setViewName("board2-1");
	      return mv;

	   }
	   
	   @RequestMapping(value="nextNotice.do", method=RequestMethod.GET)
	   public String nextNotice(int noticeNo, String genre){
		   
		   if(genre == null){
			   genre = "";
		   }else{
			   try {
				genre = new String(genre.getBytes("8859_1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   
		   BoardBookDTO next = boardservice.selectByNoticeMax(noticeNo, genre);
		   int noticeNo1 = next.getNoticeNo(); 
		   return "redirect:boardRead.do?noticeNo="+noticeNo1;
		   
	   }

	}
