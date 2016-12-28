package com.twoyears.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.boardMainViewServiceInterface;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.boardMainViewDTO;
import com.twoyears.modelDAO.UserServiceInterface;

@Controller
public class MainController {
	
	@Autowired
	UserServiceInterface service;
	@Autowired
	boardMainViewServiceInterface boardMservice;

   @RequestMapping(value="/main.do", method=RequestMethod.GET)
   public ModelAndView getNoticelist(){
	   ModelAndView mv = new ModelAndView();
		List<boardMainViewDTO> boardMmainlist = boardMservice.selectByLastdate();
		mv.addObject("boardMmainlist", boardMmainlist);
		mv.setViewName("sp_mainpage");
         return mv;
   }
   
   
   @RequestMapping(value="/main.do", method=RequestMethod.POST)
   public String Test2(UsersDTO user1, HttpSession session){
      String userId=user1.getUserId();
      String userPwd=user1.getUserPwd();
      UsersDTO user = service.selectByusers(userId, userPwd);
    		 
      
      System.out.println(user);
      
      if(user!=null){
       session.setAttribute("userDTO", user);
       
       
       
         return "sp_mainpage";
      }else{
         return "login";
      }
   }
   
   

}