package com.twoyears.model.trade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.tradeDTO;

@Component("tradeService")
public class tradeService implements tradeServiceInterface{
   
   @Autowired
   private tradeDAOInterface tradedao;
   
   @Override
   public List<String> selectTradeByNoticeNo(int noticeNo) {
      
      return tradedao.selectTradeByNoticeNo(noticeNo);
   }

   @Override
   public UsersDTO selectusernick(String userId) {
      return tradedao.selectusernick(userId);
   }

   @Override
   public int InsertTrade(String userId, String noticeNo) {
      return tradedao.InsertTrade(userId,noticeNo);
   }

   @Override
   public tradeDTO getTradeByNoticeNo(String noticeNo) {
      return tradedao.getTradeByNoticeNo(noticeNo);
   }

   @Override
   public int deleteTrade(String noticeNo) {
      return tradedao.deleteTrade(noticeNo);
   }

   @Override
   public List<NoticeDTO> selectNoticeByUserId(String userId) {
      return tradedao.selectNoticeByUserId(userId);
   }

   @Override
   public tradeDTO selectNoticeByNoticeNo(int noticeNo) {
      return tradedao.selectNoticeByNoticeNo(noticeNo);
   }

   @Override
   public List<tradeDTO> selectTradeByUserId(String userId) {
      return tradedao.selectTradeByUserId(userId);
   }

   @Override
   public String selectNick(int noticeNo) {
      return tradedao.selectNick(noticeNo);
   }

   @Override
   public int updateStatus(String noticeNo) {
      return tradedao.updateStatus(noticeNo);
   }

   @Override
   public int updatePointofsender(String sender) {
      return tradedao.updatePointofsender(sender);
   }

   @Override
   public int updatePointofreceiver(String receiver) {
      return tradedao.updatePointofreceiver(receiver);
   }

@Override
public List<tradeDTO> selectTradeByUserIdP(String userId, int low2, int high2) {
	return tradedao.selectTradeByUserIdP(userId, low2, high2);
}



}