package com.twoyears.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.RequestDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.RequestReplyDTO;
import com.twoyears.model.dto.RqrpJoinUsers;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.request.RequestServiceInterface;
import com.twoyears.modelDAO.UserServiceInterface;

@Controller
public class RequestReadController {
	@Autowired
	private RequestServiceInterface service;
	@Autowired
	private UserServiceInterface userservice;
	
	
	@RequestMapping(value="requestNotice.do", method=RequestMethod.GET)
	public String requestNoticeWriteGet(RequestNoticeDTO rqNotice, HttpSession session){
		 UsersDTO user = (UsersDTO) session.getAttribute("userDTO");
		 
			if(user==null){
				System.out.println("로그인해야함");
				return "login";
			}
			else{
				return "requestNoticeWrite";
			}
		
	}
	
	@RequestMapping(value="requestNotice.do", method=RequestMethod.POST)
	public String requestNoticeWritePost(RequestNoticeDTO rqNotice, HttpServletRequest request){
		
		String userNick = request.getParameter("userId");
		UsersDTO users = userservice.selectByuserNick(userNick);
		rqNotice.setUserId(users.getUserId());
		System.out.println(rqNotice);
		int ret = service.insertRequestNotice(rqNotice);
		if(ret!=1){
			System.out.println(ret + "요청게시판 글쓰기 실패");
			return "redirect:requestNotice.do";
		}
		return "redirect:request_notice.do";
	}
	
	@RequestMapping(value="/requestRead.do" , method=RequestMethod.GET)
	public ModelAndView requestRead(int rqNo){
	
		List<RqrpJoinUsers> rqrplist = service.selectByRqrp(rqNo);
		System.out.println(rqrplist);
		RequestDTO request = service.selectRequest(rqNo);
		int count = request.getRqCount() +1;
		System.out.println("요청게시물 count" + count);
		int ret = service.updateRequestCount(count, rqNo);
		System.out.println("요청 count update 결과"+ ret);
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("requestCo", request);
		mv.addObject("rqrplist", rqrplist);
		mv.setViewName("requestRead");
		
		return mv;
	}
	
	
	
	//리스트를 부르기위한...
	@RequestMapping(value="requestReplyList.do", method=RequestMethod.GET)
	public ModelAndView requestReplyList(int rqNo){
		ModelAndView mv = new ModelAndView();
		List<RqrpJoinUsers> rqrplist = service.selectByRqrp(rqNo);
		mv.addObject("rqrplist", rqrplist);
		mv.setViewName("requestReplyList");
		
		return mv;
	}
	

	@RequestMapping(value="requestReplyCmt.do", method=RequestMethod.POST)
	public String createRqrp(String userId, int rqNo, RequestReplyDTO rqrp){
		System.out.println("댓글 아이디:"+ userId + "게시물번호:"+ rqNo );
		System.out.println("요청게시판 댓글:"+ rqrp);
		rqrp.setUserId(userId);
		rqrp.setRqNo(rqNo);
		int ret = service.insertRequestReply(rqrp);
		System.out.println("요청게시판 댓글 성공여부 :"+ ret);
		return "redirect:requestReplyList.do?rqNo="+rqNo;
		
	}
	
	
	@RequestMapping(value="deleteRqrpCmt.do", method=RequestMethod.POST)
	public String deleteRqrp(int rqNo, int rqrp_no, String userId){
		
		int deleteret = service.deleteRequestReply(rqNo, rqrp_no, userId);
		System.out.println("요청게시판 리플삭제:"+ deleteret);
		
		return "redirect:requestReplyList.do?rqNo="+rqNo;
	}
	
	
	@RequestMapping(value="deleteRequest.do", method=RequestMethod.GET)
	public String deleteRequest(int rqNo){
		int deleteret = service.deleteRequest(rqNo);
		return "redirect:request_notice.do";
	}
	

}
