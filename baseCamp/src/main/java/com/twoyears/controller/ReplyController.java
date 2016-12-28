// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReplyController.java

package com.twoyears.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.ReplyDTO;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.modelDAO.UserServiceInterface;

@Controller
public class ReplyController {
	@Autowired
	private UserServiceInterface userservice;

	//댓글리스트 다시뿌려주는 메서드
	@RequestMapping(value="listCmtAjax.do", method = RequestMethod.GET)
	public ModelAndView listCmt(String noticeNo) {
		int noticenum = Integer.parseInt(noticeNo);
		System.out.println(noticenum);
		List<ReplyDTO> listCmt = userservice.selectReplyList(noticenum);
		System.out.println(listCmt);
		ModelAndView mv = new ModelAndView();
		mv.addObject("listCmt", listCmt);
		mv.setViewName("listCmtAjax");
		return mv;
	}

	@RequestMapping(value = "createReply.do", method = RequestMethod.POST)
	public String createReply(String userId, int noticeNo, ReplyDTO reply, HttpSession session) {
	
		/*UsersDTO users = service.selectByuserNick(userNick);
		String userId = users.getUserId();*/
		 UsersDTO user = (UsersDTO) session.getAttribute("userDTO");
		if(user==null){
			System.out.println("로그인해야함");
			return "redirect:login.do";
		}
		else{
			reply.setUserId(userId);
			reply.setNoticeNo(noticeNo);
			int ret = userservice.createReply(reply);
			return "redirect:listCmtAjax.do?noticeNo=" + noticeNo; //댓글리스트 다시부르기 위해서
		}
	}

	@RequestMapping(value ="deleteReply.do", method = RequestMethod.POST)
	public String deleteReply(int replyNo, int noticeNo, String userId) {
		System.out.println(replyNo + noticeNo+ userId);
		int deleteret = userservice.deleteReply(replyNo, noticeNo, userId);
		System.out.println(deleteret);
		return "redirect:listCmtAjax.do?noticeNo=" + noticeNo;
	}

}
