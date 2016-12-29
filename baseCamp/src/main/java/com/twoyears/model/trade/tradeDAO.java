package com.twoyears.model.trade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.tradeDTO;

@Component("tradedao")
public class tradeDAO implements tradeDAOInterface{

   @Autowired
   SqlSession session;
   
   @Override
   public List<String> selectTradeByNoticeNo(int noticeNo) {
      Map<String, Integer> map = new HashMap<String, Integer>();
      map.put("noticeNo", noticeNo);
      return session.selectList("twoyears.givook.trade.selectTradeByNoticeNo", map);
   }

   @Override
   public UsersDTO selectusernick(String userId) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("userId", userId);
      return session.selectOne("twoyears.givook.trade.selectusernick",map);
   }

   @Override
   public int InsertTrade(String userId, String noticeNo) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("userId", userId);
      map.put("noticeNo", noticeNo);
      return session.insert("twoyears.givook.trade.insertTrade", map);
   }

   @Override
   public tradeDTO getTradeByNoticeNo(String noticeNo) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("noticeNo", noticeNo);
      return session.selectOne("twoyears.givook.trade.getTradeByNoticeNo",map);
   }

   @Override
   public int deleteTrade(String noticeNo) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("noticeNo", noticeNo);
      return session.delete("twoyears.givook.trade.deleteTrade", map);
   }

   @Override
   public List<NoticeDTO> selectNoticeByUserId(String userId) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("userId", userId);
      return session.selectList("twoyears.givook.trade.selectNoticeByUserId",map);
   }

   @Override
   public tradeDTO selectNoticeByNoticeNo(int noticeNo) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("noticeno", Integer.toString(noticeNo));
      tradeDTO temp= session.selectOne("twoyears.givook.trade.selectNoticeByNoticeNo",map);
      return temp;
   }

   @Override
   public List<tradeDTO> selectTradeByUserId(String userId) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("userId", userId);
      return session.selectList("twoyears.givook.trade.selectTradeByUserId",map);
      
   }

   @Override
   public String selectNick(int noticeNo) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("noticeNo", Integer.toString(noticeNo));
      return session.selectOne("twoyears.givook.trade.selectNick",map);
   }

   @Override
   public int updateStatus(String noticeNo) {
      Map<String,String> map = new HashMap<String, String>();
      map.put("noticeNo",noticeNo);
      return session.update("twoyears.givook.trade.updateStatus",map);
   }

   @Override
   public int updatePointofsender(String sender) {
      Map<String,String> map = new HashMap<String, String>();
      map.put("sender",sender);
      return session.update("twoyears.givook.trade.updatePointofsender",map);
   }

   @Override
   public int updatePointofreceiver(String receiver) {

      Map<String,String> map = new HashMap<String, String>();
      map.put("receiver",receiver);
      return session.update("twoyears.givook.trade.updatePointofreceiver",map);
   }

@Override
public List<tradeDTO> selectTradeByUserIdP(String userId, int low2, int high2) {
	
	Map<String,String> map = new HashMap<String, String>();
    map.put("userId",userId);
	map.put("low2", Integer.toString(low2));
    map.put("high2", Integer.toString(high2));
	return session.selectList("twoyears.givook.trade.selectTradeByUserIdP",map);
}
   
}