package com.twoyears.model.trade;

import java.util.List;

import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.tradeDTO;

public interface tradeServiceInterface {
   public List<String> selectTradeByNoticeNo(int noticeNo);
   public UsersDTO selectusernick(String userId);
   public int InsertTrade(String userId, String noticeNo);
   public tradeDTO getTradeByNoticeNo(String noticeNo);
   public int deleteTrade(String noticeNo);
   public List<NoticeDTO> selectNoticeByUserId(String userId);
   public tradeDTO selectNoticeByNoticeNo(int noticeNo);
   public List<tradeDTO> selectTradeByUserId(String userId);
   public String selectNick(int noticeNo);
   public int updateStatus(String noticeNo);
   public int updatePointofsender(String sender);
   public int updatePointofreceiver(String receiver);
   public List<tradeDTO> selectTradeByUserIdP(String userId, int low2, int high2);
}