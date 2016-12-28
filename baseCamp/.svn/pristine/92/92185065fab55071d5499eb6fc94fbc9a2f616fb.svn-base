package com.twoyears.model.favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.BoardDTO;
import com.twoyears.model.dto.FavoriteDTO;

@Component("favorite_service")
public class MyfavoriteService implements MyfavoriteServiceInterface{

	@Autowired
	MyfavoriteDAOInterface favorite_dao;
	
	@Override
	public BoardDTO getMyfavorite(int noticeno) {		
		return favorite_dao.getMyfavorite(noticeno);
				
	}

	@Override
	public List<Integer> selectFavoriteByUserId(String userId) {
		return favorite_dao.selectFavoriteByUserId(userId);
	}
	
	public int insertFavorite(FavoriteDTO favorite){
		return favorite_dao.insertFavorite(favorite);
	}
	
	public FavoriteDTO selectDupli(int noticeNo, String userId){
		return favorite_dao.selectDupli(noticeNo, userId);
	}
	
	
}
