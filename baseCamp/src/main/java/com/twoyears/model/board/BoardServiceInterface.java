package com.twoyears.model.board;

import java.util.List;

import com.twoyears.model.dto.BoardBookDTO;

public interface BoardServiceInterface {
	public List<BoardBookDTO> selectByAll();
	public List<BoardBookDTO> selectByRownum(String genre,int low, int high);
	public int selectCount(String genre);
	public List<BoardBookDTO> selectByTitle(String genre, String title,int low, int high);
	public List<BoardBookDTO> selectByContent(String genre,String content,int low, int high);
	public List<BoardBookDTO> selectByUser(String genre, String user,int low, int high);
	public int selectByTitleCount(String genre, String title);
	public int selectByContentCount(String genre, String content);
	public int selectByUserCount(String genre, String user);
	public BoardBookDTO selectByNoticeMax(int noticeNo, String bookGenre);
}
