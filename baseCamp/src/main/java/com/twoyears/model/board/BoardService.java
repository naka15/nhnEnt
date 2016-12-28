package com.twoyears.model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.BoardBookDTO;

@Component("boardservice")
public class BoardService implements BoardServiceInterface {

	@Autowired
	private BoardDAOInterface boarddao;

	@Override
	public List<BoardBookDTO> selectByAll() {
		return boarddao.selectByAll();
	}

	@Override
	public List<BoardBookDTO> selectByRownum(String genre, int low, int high) {

		return boarddao.selectByRownum(genre, low, high);
	}

	@Override
	public int selectCount(String genre) {
		return boarddao.selectCount(genre);
	}

	@Override
	public List<BoardBookDTO> selectByTitle(String genre, String title,
			int low, int high) {

		return boarddao.selectByTitle(genre, title, low, high);
	}

	@Override
	public List<BoardBookDTO> selectByContent(String genre, String content,
			int low, int high) {
		return boarddao.selectByContent(genre, content, low, high);
	}

	@Override
	public List<BoardBookDTO> selectByUser(String genre, String user, int low,
			int high) {
		return boarddao.selectByUser(genre, user, low, high);
	}

	@Override
	public int selectByTitleCount(String genre, String title) {
		// TODO Auto-generated method stub
		return boarddao.selectByTitleCount(genre, title);
	}

	@Override
	public int selectByContentCount(String genre, String content) {
		// TODO Auto-generated method stub
		return boarddao.selectByContentCount(genre, content);
	}

	@Override
	public int selectByUserCount(String genre, String user) {
		// TODO Auto-generated method stub
		return boarddao.selectByUserCount(genre, user);
	}
	
	
	public BoardBookDTO selectByNoticeMax(int noticeNo, String bookGenre){
		return boarddao.selectByNoticeMax(noticeNo, bookGenre);
	}
}
