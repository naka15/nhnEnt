package com.twoyears.model;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.boardMainViewDTO;

@Component("boardmaindao")
public class boardMainViewDAO implements boardMainViewDAOInterface{

	
/*	@Autowired
	DataSource dataSource;*/
	
	@Autowired
	SqlSession session;
	
	public List<boardMainViewDTO> selectByLastdate() {
		return session.selectList("twoyears.givook.selectByLastdate"); 
	}

	@Override
	public List<UsersDTO> selectByPoint() {
		// TODO Auto-generated method stub
		return null;
	}
}
