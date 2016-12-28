package com.twoyears.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.twoyears.model.dto.UsersDTO;
import com.twoyears.modelDAO.UserServiceInterface;

@Controller
public class UserJoinController {

	
	@Autowired
	private UserServiceInterface userservice;
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED)
	public String userJoin(UsersDTO users){
		
	
		   String userId = users.getUserId();
		      String userNick = users.getUserNick();
		      String userEmail = users.getUserEmail();
		      
		      String userPwd = users.getUserPwd();
		      String userName = users.getUserName();
		      String userPhone = users.getUserPhone();
		      
		      UsersDTO usermember = userservice.userSelectByEmail(userEmail);
		      UsersDTO usermember1= userservice.selectByuserId(userId);
		      UsersDTO usermember2= userservice.selectByuserNick(userNick);
		      
		      if(usermember!=null || usermember1!=null || usermember2!=null){
		         return "failjoin";
		      }else{
		         
		    	  userservice.userInsert(userId, userPwd, userName, userNick, userPhone, userEmail);

		         System.out.println("회원가입 성공");
		         return "login";
		      }
	}
}
