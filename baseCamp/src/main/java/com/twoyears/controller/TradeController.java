package com.twoyears.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.Paging;
import com.twoyears.model.dto.UsersDTO;
import com.twoyears.model.dto.tradeDTO;
import com.twoyears.model.trade.tradeServiceInterface;

@Controller
public class TradeController {

   @Autowired
   private tradeServiceInterface tradeService;

   // 작성자가 등록한 게시물을 찜한 사람들을 불러옴, mypage의 거래내
   @RequestMapping(value = "/selectTarget.do", method = RequestMethod.GET)
   public ModelAndView trade(String noticeNo, String pageNo) {
      ModelAndView mv = new ModelAndView();
      List<String> targetId = tradeService.selectTradeByNoticeNo(Integer
            .parseInt(noticeNo));
      List<UsersDTO> users = new ArrayList<UsersDTO>();
      for (int i = 0; i < targetId.size(); i++) {
         users.add(tradeService.selectusernick(targetId.get(i)));
      }
      
      
      mv.addObject("noticeNo", noticeNo);
      mv.addObject("users", users);
      mv.setViewName("selectTarget");// selectTarget
      return mv;
   }
  
   @RequestMapping(value = "/tradeStart.do", method = RequestMethod.GET)
   public ModelAndView tradeStart(String userId, String noticeNo) {
      ModelAndView mv = new ModelAndView();
      tradeDTO trade = tradeService.getTradeByNoticeNo(noticeNo);
      // 선택안함을 선택하고 그 전에 트레이드 목록이 있었을 경우 트레이드를 삭제
      if (userId == null && trade != null) {
         tradeService.deleteTrade(noticeNo);
         return mv;
      }
      // 선택안함외에 다른 것을 선택한 경우
      else {
         // 다른 대상자를 선택했는데 이미 다른 유저를 선택한경우 기존 트레이드를 삭제하고 재 등록
         if (trade != null) {
            tradeService.deleteTrade(noticeNo);
         }
         if (tradeService.selectusernick(userId).getUserPoint() >= 100) {
            tradeService.InsertTrade(userId, noticeNo);
            mv.setViewName("success");
            return mv;
         } else {
            mv.setViewName("fail");
            return mv;
         }
      }
   }
   
   @RequestMapping(value="/fail.do", method = RequestMethod.GET)
   public String tradefail(){
      return "fail";
   }
   //mypage tradinfo
   @RequestMapping(value = "/tradeinfo.do", method = RequestMethod.GET)
   public ModelAndView tradeinfo(HttpSession session, String pageNo, String pageNo2) {
      UsersDTO user = (UsersDTO) session.getAttribute("userDTO");
      // 기부중인 거래내역, userid로 등록한 notice 다 가져오기 그리고 notice 중에 trade에 등록되있는것 찾기
      //pageNo로 paging
      Paging paging = new Paging();
      int totalCount;
      // 페이지번호 처음 요청시엔 null, 게시판 하단 페이지 번호 눌렀을 때 값 저장
      if (pageNo == null) {
         paging.setPageNo(1);
      } else {
         paging.setPageNo(Integer.parseInt(pageNo));
      }

      int pagenum = paging.getPageNo();
      int low = (pagenum - 1) * 5;
      int high = low + 4;
      
      List<tradeDTO> tradedtot= new ArrayList<tradeDTO>();
      List<NoticeDTO> noticedto = new ArrayList<NoticeDTO>();
      noticedto = tradeService.selectNoticeByUserId(user.getUserId());
      List<tradeDTO> tradedto = new ArrayList<tradeDTO>();

      
      for (int i = 0; i < noticedto.size(); i++) {
         tradeDTO temp = tradeService.selectNoticeByNoticeNo(noticedto
               .get(i).getNoticeNo());

         if (temp != null) {
            if (temp.getReceiverStatus() == 1) {
               temp.setTradeStatus("거래중");
            }
            tradedto.add(temp);

         }
      }
      if(high>=tradedto.size()){
    	  high=tradedto.size()-1;
      }
      System.out.println("!!!"+tradedto);
      
      for(int i = low; i<=high; i++){
      tradedtot.add(tradedto.get(i));
      }
      
      
      
      totalCount=tradedto.size();
      paging.setPageSize(5);
      paging.setTotalCount(totalCount);
      
      // 기부받을 거래내역, trade에서 receiverUserId가 자신인것을 가져온다
      
      Paging paging2 = new Paging();
      int totalCount2;
      // 페이지번호 처음 요청시엔 null, 게시판 하단 페이지 번호 눌렀을 때 값 저장
      if (pageNo2 == null) {
         paging2.setPageNo(1);
      } else {
         paging2.setPageNo(Integer.parseInt(pageNo2));
      }

      int pagenum2 = paging2.getPageNo();
      int low2 = (pagenum2 - 1) * 5;
      int high2 = low2 + 4;
      
      List<tradeDTO> temptrade = new ArrayList<tradeDTO>();
      List<tradeDTO> gettrade = new ArrayList<tradeDTO>();
      temptrade = tradeService.selectTradeByUserId(user.getUserId());
      
      totalCount2=temptrade.size();
      if(high2>totalCount2){
    	  high2=totalCount2;
      }
      gettrade = tradeService.selectTradeByUserIdP(user.getUserId(),low2,high2);
      System.out.println("temptrade   "+ temptrade);
      for (int i = low2; i < high2; i++) {
         if (temptrade.get(i) != null) {
            String senderId = tradeService.selectNick(temptrade.get(i)
                  .getNoticeNo());//noticno로 notice에서 sender id가져옴
            UsersDTO senderuser = tradeService.selectusernick(senderId);
            gettrade.get(i-low2).setSenderUserNick(senderuser.getUserNick());
            if (temptrade.get(i).getReceiverStatus() == 1) {
               gettrade.get(i-low2).setTradeStatus("거래중");
            } else if (temptrade.get(i).getReceiverStatus() == 2) {
               gettrade.get(i-low2).setTradeStatus("거래완료");
            }
         }
      }
      
      System.out.println("=---=  "+gettrade);
      paging2.setPageSize(5);
      paging2.setTotalCount(totalCount2);
      
      
      ModelAndView mv = new ModelAndView();
      
      mv.addObject("paging",paging);
      mv.addObject("paging2",paging2);
      mv.addObject("gettrade", gettrade);
      mv.addObject("trade", tradedtot);
      mv.setViewName("tradeinfo");
      return mv;
   }

   @RequestMapping(value = "/changeStatus.do", method = RequestMethod.GET)
   public ModelAndView changeStatus(String noticeNo, String tradeStatus) {

      ModelAndView mv = new ModelAndView();
      if (tradeStatus == null) {
         tradeService.updateStatus(noticeNo);
         // notice 쓴사람 noticeno로 찾아오기
         String sender = tradeService.selectNick(Integer.parseInt(noticeNo));
         // sender 포인트 올려주기
         tradeService.updatePointofsender(sender);
         // noticeno와 거래하는 사람 trade에서 찾아오
         tradeDTO trade = tradeService.getTradeByNoticeNo(noticeNo);
         String receiver = trade.getReceiverUserId();
         // receiver 포인트 깎기
         tradeService.updatePointofreceiver(receiver);
         return mv;
      } else {

         mv.addObject("noticeNo", noticeNo);
         mv.addObject("tradeStatus", tradeStatus);
         mv.setViewName("changeStatus");
         return mv;
      }

   }

}