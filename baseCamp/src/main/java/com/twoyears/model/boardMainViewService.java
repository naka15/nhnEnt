package com.twoyears.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.boardMainViewDTO;

@Component("boardmainservice")
public class boardMainViewService implements boardMainViewServiceInterface{

	@Autowired
	private boardMainViewDAOInterface boardmaindao;
	
	public List<boardMainViewDTO> selectByLastdate() {
		return boardmaindao.selectByLastdate();
	}
	
	public List<UsersDTO> selectByPoint(){
		return boardmaindao.selectByPoint();
	}

}
