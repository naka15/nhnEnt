package com.twoyears.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.BoardDTO;
import com.twoyears.model.dto.FavoriteDTO;
import com.twoyears.model.dto.Paging;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.favorite.MyfavoriteServiceInterface;

@Controller
public class FavoriteController {

	@Autowired
	MyfavoriteServiceInterface favorite_service;

	@RequestMapping("myfavorite.do")
	public ModelAndView myfavorite(String userId, String pageNo, HttpSession session) {
		
		 UsersDTO user = (UsersDTO) session.getAttribute("userDTO");
		 ModelAndView mv = new ModelAndView();
			if(user==null){
				System.out.println("로그인해야함");
				mv.setViewName("login");
				return mv;
			}
			else{
				
		
		
		int i;
		List<BoardDTO> dto = new ArrayList<BoardDTO>();
		List<Integer> noticenolist;
		Paging paging = new Paging();
		int totalCount;
		
		
		if (pageNo == null) {
			paging.setPageNo(1);
		} else {
			paging.setPageNo(Integer.parseInt(pageNo));
		}

		int pagenum = paging.getPageNo();
		int low = (pagenum - 1) * 5;
		int high = low + 4;
		noticenolist = favorite_service.selectFavoriteByUserId(user.getUserId());
		if (high >= noticenolist.size()) {
			high=noticenolist.size()-1;
		}

		for (i = low; i <=high; i++) {
			int noticeno = noticenolist.get(i);
			if(favorite_service.getMyfavorite(noticeno)!=null){
			
			dto.add(favorite_service.getMyfavorite(noticeno));
			}
		}
		totalCount = noticenolist.size();

		paging.setPageSize(5);
		paging.setTotalCount(totalCount);
		
		mv.addObject("userId",userId);
		mv.addObject("paging",paging);
		mv.addObject("myfavorite", dto);
		mv.setViewName("myfavorite");
		return mv;	}
	}
	
	
	@RequestMapping(value="insertFavorite.do", method=RequestMethod.POST)
	public ModelAndView insertFavorite(String userId, Integer noticeNo, FavoriteDTO favorite){
		
		FavoriteDTO favo = favorite_service.selectDupli(noticeNo, userId);
		System.out.println(favo);
		ModelAndView mv = new ModelAndView();
		if(favo==null){
			favorite.setUserId(userId);
			favorite.setNoticeNo(noticeNo);
			int ret = favorite_service.insertFavorite(favorite);
			System.out.println("등록찾기완료"+ret);
			System.out.println("즐겨찾기" + userId + noticeNo); 
			
			mv.addObject("msg", "즐겨찾기 등록되었습니다♥");    
			mv.setViewName("favoriteresponAjax");
		}
		else{
			mv.addObject("msg", "이미 등록되어 있는 게시물입니다.");    
			mv.setViewName("favoriteresponAjax");
		}
		  //새로운페이지부름 (-->ajax의 data)
		return mv;
	}

}
