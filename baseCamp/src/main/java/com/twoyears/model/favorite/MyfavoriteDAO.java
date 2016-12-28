package com.twoyears.model.favorite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.BoardDTO;
import com.twoyears.model.dto.FavoriteDTO;

@Component("favorite_dao")
public class MyfavoriteDAO implements MyfavoriteDAOInterface{
	@Autowired
	SqlSession session;

	@Override
	public BoardDTO getMyfavorite(int noticeno) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("noticeno",noticeno);
		return session.selectOne("givook.mapper.favorite.getMyfavorite",map);
	}

	@Override
	public List<Integer> selectFavoriteByUserId(String userId) {
		Map<String, String> map= new HashMap<String,String>();
		map.put("userId", userId);
		System.out.println("---------------u!s!e!R!I!D!  "+userId);
		return session.selectList("givook.mapper.favorite.selectFavoriteByUserId",map);
	}
	
	
	public int insertFavorite(FavoriteDTO favorite){
		return session.insert("givook.mapper.favorite.insertFavorite", favorite);
	}
	
	public FavoriteDTO selectDupli(int noticeNo, String userId){
		Map<String,String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("noticeNo", noticeNo+"");
		
		return  session.selectOne("givook.mapper.favorite.selectDupli", map);
	}
}
