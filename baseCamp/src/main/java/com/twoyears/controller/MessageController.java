package com.twoyears.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.MessageDTO;
import com.twoyears.model.dto.Paging;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.modelDAO.UserServiceInterface;

@Controller
public class MessageController {
	@Autowired
	private UserServiceInterface service;

	@RequestMapping(value = "/sendMessage.do", method = RequestMethod.POST)
	public String sendMessage(MessageDTO message, HttpSession session,
			HttpServletRequest request) {

		String messageContent = message.getMessageContent();
		String messageTitle = message.getMessageTitle();

		String noticeNo = request.getParameter("hiddennoticeNo");
		System.out.println(noticeNo);

		String userNick = request.getParameter("toUserNick");
		UsersDTO user = service.selectByuserNick(userNick);
		String userId = user.getUserId();

		System.out.println("받는사람 닉네임" + userNick);

		UsersDTO users = (UsersDTO) session.getAttribute("userDTO");
		String fromUserId = users.getUserId();

		message.setFromUserId(fromUserId);
		message.setUserId(userId);
		message.setMessageContent(messageContent);
		message.setMessageTitle(messageTitle);

		System.out.println(messageTitle);
		System.out.println(messageContent);
		System.out.println("주는 사람" + fromUserId);
		System.out.println("받는사람" + userId);

		int ret = service.insertMessage(message);

		if (ret != 1) {
			System.out.println("실패");
		}

		System.out.println("message 보내짐");

		return "redirect:boardRead.do?noticeNo=" + noticeNo;
	}

	@RequestMapping(value = "/mySendMessage.do", method = RequestMethod.POST)
	public String mySendMessage(MessageDTO message, HttpSession session,
			HttpServletRequest request) {

		String messageContent = message.getMessageContent();
		String messageTitle = message.getMessageTitle();

		String toUserId = request.getParameter("toUserId");
		System.out.println("받는사람 아이디" + toUserId);

		UsersDTO users = (UsersDTO) session.getAttribute("userDTO");
		String fromUserId = users.getUserId();

		message.setFromUserId(fromUserId);
		message.setUserId(toUserId);
		message.setMessageContent(messageContent);
		message.setMessageTitle(messageTitle);

		System.out.println(messageTitle);
		System.out.println(messageContent);
		System.out.println("주는 사람" + fromUserId);
		System.out.println("받는사람" + toUserId);

		int ret = service.insertMessage(message);

		if (ret != 1) {
			System.out.println("실패");
		}

		System.out.println("message 보내짐");

		return "mypage";
	}

	@RequestMapping(value = "/mymessage.do", method = RequestMethod.GET)
	public ModelAndView message(HttpSession session, String pageNo,
			String recvpageNo) {

		ModelAndView mv = new ModelAndView();
		Paging paging = new Paging();
		Paging recvpaging = new Paging();
		int totalCount;
		int recvtotalCount;

		UsersDTO users = (UsersDTO) session.getAttribute("userDTO");
		String fromUserId = users.getUserId();

		// 보낸 메세지
		List<MessageDTO> messagelist = service.selectMessage(fromUserId);
		totalCount = messagelist.size();
		if (pageNo == null) {
			paging.setPageNo(1);
		} else {
			paging.setPageNo(Integer.parseInt(pageNo));
		}

		int pagenum = paging.getPageNo();
		int low = (pagenum - 1) * 5 + 1;
		int high = low + 4;
		messagelist = service.selectMessageP(fromUserId, low, high);
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);

		// 받은 메세지
		
		List<MessageDTO> receivemessagelist = service
				.selectReceiveMessage(fromUserId);
		recvtotalCount = receivemessagelist.size();
		if (recvpageNo == null) {
			recvpaging.setPageNo(1);
		} else {
			recvpaging.setPageNo(Integer.parseInt(recvpageNo));
		}
		int recvpagenum = recvpaging.getPageNo();
		int recvlow = (recvpagenum - 1) * 5 + 1;
		int recvhigh = low + 4;
		
		receivemessagelist = service.selectReceiveMessageP(fromUserId, recvlow,
				recvhigh);
		recvpaging.setPageSize(5);
		recvpaging.setTotalCount(recvtotalCount);
		
		
		mv.addObject("paging",paging);
		mv.addObject("recvpaging",recvpaging);
		mv.addObject("messagelist", messagelist);
		mv.addObject("receivemessagelist", receivemessagelist);

		mv.setViewName("mymessage");

		return mv;
	}

}