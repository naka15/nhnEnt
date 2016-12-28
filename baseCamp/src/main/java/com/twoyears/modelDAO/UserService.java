package com.twoyears.modelDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.BookDTO;
import com.twoyears.model.dto.MessageDTO;
import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.ReplyDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.UsersDTO;

@Component("userservice")
public class UserService implements UserServiceInterface {
	@Autowired
	private UserDAOInterface userdao;

	@Override
	public UsersDTO selectByusers(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return userdao.selectByusers(userId, userPwd);
	}

	public UsersDTO selectByuserNick(String userNick) {
		return userdao.selectByuserNick(userNick);
	}

	public UsersDTO selectByuserId(String userId) {
		return userdao.selectByuserId(userId);
	}

	public int updateCount(int count, int noticeNo) {
		return userdao.updateCount(count, noticeNo);
	}

	public int insertUsers(UsersDTO users) {
		return userdao.insertUsers(users);
	}

	public int selectBynextVal() {
		return userdao.selectBynextVal();
	}

	public int insertBook(BookDTO book) {
		return userdao.insertBook(book);
	}

	public int insertNotice(NoticeDTO notice) {
		return userdao.insertNotice(notice);
	}

	public NoticeDTO selectBynoticeAll(int mno) {
		return userdao.selectBynoticeAll(mno);
	}

	public BookDTO selectByBookAll(int mno) {
		return userdao.selectByBookAll(mno);
	}

	public UsersDTO userSelectByEmail(String userEmail) {
		return userdao.userSelectByEmail(userEmail);
	}

	public UsersDTO userSelectJoinCondition(String userId, String userNick,
			String userEmail) {
		return userdao.userSelectJoinCondition(userId, userNick, userEmail);
	}

	public int userUpdate(String userId, String userPwd, String userName,
			String userNick, String userPhone, String userEmail) {
		return userdao.userUpdate(userId, userPwd, userName, userNick,
				userPhone, userEmail);
	}

	public int userDelete(String userId) {
		return userdao.userDelete(userId);
	}

	public int createReply(ReplyDTO reply) {
		return userdao.createReply(reply);
	}

	public int deleteReply(int replyNo, int noticeNo, String userId) {
		return userdao.deleteReply(replyNo, noticeNo, userId);
	}

	public List<ReplyDTO> selectReplyList(int noticeNo) {
		return userdao.selectReplyList(noticeNo);
	}

	public int userInsert(String userId, String userPwd, String userName,
			String userNick, String userPhone, String userEmail) {
		return userdao.userInsert(userId, userPwd, userName, userNick,
				userPhone, userEmail);
	}

	public List<RequestNoticeDTO> userSelectByMyRequestWirte(String userId) {
		return userdao.userSelectByMyRequestWirte(userId);
	}

	public List<NoticeDTO> userSelectByMyWirte(String userId) {
		return userdao.userSelectByMyWirte(userId);
	}

	public int deleteNotice(int noticeNo) {
		return userdao.deleteNotice(noticeNo);
	}

	public int deleteBook(int noticeNo) {
		return userdao.deleteBook(noticeNo);
	}

	

	
	  public int insertMessage(MessageDTO message){
		  return userdao.insertMessage(message);
				  
	  }
      public List<MessageDTO> selectMessage(String userId){
    	  return userdao.selectMessage(userId);
      }
      
      public List<MessageDTO> selectReceiveMessage(String userId){
    	  return userdao.selectReceiveMessage(userId);
      }

	@Override
	public List<MessageDTO> selectMessageP(String userId, int low, int high) {
		return userdao.selectMessageP(userId, low, high);
	}

	@Override
	public List<MessageDTO> selectReceiveMessageP(String userId, int low,
			int high) {
		return userdao.selectReceiveMessageP(userId, low, high);
	}

	@Override
	public List<NoticeDTO> userSelectByMyWriteP(String userId, int low, int high) {
		return userdao.userSelectByMyWriteP(userId, low, high);
	}

	@Override
	public List<RequestNoticeDTO> userSelectByMyRequestWirteP(String userId,
			int requestlow, int requesthigh) {
		return userdao.userSelectByMyRequestWirteP(userId, requestlow, requesthigh);
	}
}
