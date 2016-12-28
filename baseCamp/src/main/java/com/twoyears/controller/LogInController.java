package com.twoyears.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.UsersDTO;
import com.twoyears.modelDAO.UserServiceInterface;


@Controller
public class LogInController {

	@Autowired
	private UserServiceInterface service;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginGet(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	
/*	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView loginPost(UsersDTO users,HttpServletRequest request, HttpSession session){

		System.out.println(users);
		UsersDTO userDTO = service.selectByusers(users.getUserId(), users.getUserPwd());
		ModelAndView mv = new ModelAndView();
		mv.addObject("userDTO", userDTO);
		mv.setViewName("redirect:/.do");
		session.setAttribute("userDTO", userDTO);
		return mv;
		
	}*/
	
	
	//윤관쓰
	

	   
	   @RequestMapping(value ="/idcheck.do", method = RequestMethod.POST)
	   public ModelAndView idcheck(String userId) {

	      System.out.println(userId);
	      ModelAndView mv = new ModelAndView();
	      UsersDTO user = service.selectByuserId(userId);
	      String msg = null;
	      if (user != null) {
	         msg = "중복된 아이디입니다.";
	      } else {
	         msg = "사용가능한 아이디입니다.";
	      }
	      mv.addObject("msg", msg);
	      mv.setViewName("ajaxGet");
	      return mv;

	   }
	   @RequestMapping(value ="/nickcheck.do", method = RequestMethod.POST)
	   public ModelAndView nickcheck(String userNick) {

	      System.out.println(userNick);
	      ModelAndView mv = new ModelAndView();
	      UsersDTO user = service.selectByuserNick(userNick);
	      String msg = null;
	      if (user != null) {
	         msg = "중복된 닉네임입니다.";
	      } else {
	         msg = "사용가능한 닉네임입니다.";
	      }
	      mv.addObject("msg", msg);
	      mv.setViewName("ajaxGet");
	      return mv;

	   }
	   
	   @RequestMapping(value ="/emailcheck.do", method = RequestMethod.POST)
	   public ModelAndView emailcheck(String userEmail) {

	      System.out.println(userEmail);
	      ModelAndView mv = new ModelAndView();
	      UsersDTO user = service.userSelectByEmail(userEmail);
	      String msg = null;
	      if (user != null) {
	         msg = "중복된 이메일입니다.";
	      } else {
	         msg = "사용가능한 이메일입니다.";
	      }
	      mv.addObject("msg", msg);
	      mv.setViewName("ajaxGet");
	      return mv;

	   }


	
	
}
