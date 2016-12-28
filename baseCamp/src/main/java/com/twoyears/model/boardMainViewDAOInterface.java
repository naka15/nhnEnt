package com.twoyears.model;

import java.util.List;

import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.boardMainViewDTO;


public interface boardMainViewDAOInterface {
	public List<boardMainViewDTO>  selectByLastdate();
	public List<UsersDTO> selectByPoint();

}
