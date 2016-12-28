package com.twoyears.model.favorite;

import java.util.List;

import com.twoyears.model.dto.BoardDTO;
import com.twoyears.model.dto.FavoriteDTO;

public interface MyfavoriteServiceInterface {
	public BoardDTO getMyfavorite(int noticeno);
	public List<Integer> selectFavoriteByUserId(String userId);
	public int insertFavorite(FavoriteDTO favorite);
	public FavoriteDTO selectDupli(int noticeNo, String userId);
}
