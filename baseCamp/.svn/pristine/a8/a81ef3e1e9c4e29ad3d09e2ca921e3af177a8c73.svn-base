package com.twoyears.model.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.BoardBookDTO;



@Component("boarddao")
public class BoardDAO implements BoardDAOInterface {

   @Autowired
   SqlSession session;

   public List<BoardBookDTO> selectByAll() {
      return session.selectList("givook.mapper.selectByAll");
   }

   public List<BoardBookDTO> selectByRownum(String genre, int low, int high) {
      
    

      Map<String, String> map = new HashMap<String, String>();
      map.put("high", Integer.toString(high));
      map.put("low", Integer.toString(low));
      
      map.put("genre",genre);
      return session.selectList("givook.mapper.selectByRownum", map);
   }

   public int selectCount(String genre) {
      Map<String,String> map = new HashMap<String, String>();
      map.put("genre", genre);
      return session.selectOne("givook.mapper.selectCount",map);
   }

   public List<BoardBookDTO> selectByTitle(String genre,String title,int low, int high) {
      System.out.println("select=======title"+title);
      Map<String, String> map = new HashMap<String, String>();
      map.put("title", title);
      map.put("high", Integer.toString(high));
      map.put("low", Integer.toString(low));
      map.put("genre", genre);
      return session.selectList("givook.mapper.selectByTitle", map);
   }

   public List<BoardBookDTO> selectByContent(String genre, String content, int low, int high) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("content", content);
      System.out.println("ddddddddddddddddcccc" + content);
      map.put("high", Integer.toString(high));
      map.put("low", Integer.toString(low));
      map.put("genre", genre);
      return session.selectList("givook.mapper.selectByContent", map);
   }

   public List<BoardBookDTO> selectByUser(String genre, String user, int low, int high) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("user", user);
      map.put("high", Integer.toString(high));
      map.put("low", Integer.toString(low));
      map.put("genre", genre);
      return session.selectList("givook.mapper.selectByUser", map);
   }

   @Override
   public int selectByTitleCount(String genre, String title) {
      // TODO Auto-generated method stub
      Map<String, String> map = new HashMap<String, String>();
      map.put("title",title);
      map.put("genre", genre);
      return session.selectOne("givook.mapper.selectByTitleCount",map);
   }

   @Override
   public int selectByContentCount(String genre, String content) {
      // TODO Auto-generated method stub
      Map<String, String> map = new HashMap<String, String>();
      map.put("content", content);
      map.put("genre", genre);
      return session.selectOne("givook.mapper.selectByContentCount",map);
   }

   @Override
   public int selectByUserCount(String genre, String user) {
      // TODO Auto-generated method stub
      Map<String, String> map = new HashMap<String, String>();
      map.put("user", user);
      map.put("genre", genre);
      return session.selectOne("givook.mapper.selectByUserCount",map);
   }
   
   
   public BoardBookDTO selectByNoticeMax(int noticeNo, String bookGenre){
	   Map<String, String> map = new HashMap<String, String>();
	   map.put("noticeNo", noticeNo+"");
	   map.put("bookGenre", bookGenre);
	   return session.selectOne("givook.notice.selectByNoticeMax", map);
   }
}