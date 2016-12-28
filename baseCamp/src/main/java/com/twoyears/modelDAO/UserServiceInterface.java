package com.twoyears.modelDAO;

import java.util.List;

import com.twoyears.model.dto.BookDTO;
import com.twoyears.model.dto.MessageDTO;
import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.ReplyDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.UsersDTO;

public interface UserServiceInterface {
	
	public UsersDTO selectByusers(String userId, String userPwd);

	public UsersDTO selectByuserNick(String userNick);

	public UsersDTO selectByuserId(String userId);

	public int insertUsers(UsersDTO users);

	public int selectBynextVal();

	public int insertBook(BookDTO book);

	public int insertNotice(NoticeDTO notice);

	public NoticeDTO selectBynoticeAll(int mno);

	public BookDTO selectByBookAll(int mno);

	public UsersDTO userSelectByEmail(String userEmail);

	public UsersDTO userSelectJoinCondition(String userId, String userNick,
			String userEmail);

	public int userUpdate(String userId, String userPwd, String userName,
			String userNick, String userPhone, String userEmail);

	public int userDelete(String userId);

	public int updateCount(int count, int noticeNo);

	public int createReply(ReplyDTO reply);

	public int deleteReply(int replyNo, int noticeNo, String userId);

	public List<ReplyDTO> selectReplyList(int noticeNo);

	public int userInsert(String userId, String userPwd, String userName,
			String userNick, String userPhone, String userEmail);

	public List<RequestNoticeDTO> userSelectByMyRequestWirte(String userId);

	public List<RequestNoticeDTO> userSelectByMyRequestWirteP(String userId,
			int requestlow, int requesthigh);

	public List<NoticeDTO> userSelectByMyWirte(String userId);

	public List<NoticeDTO> userSelectByMyWriteP(String userId, int low, int high);

	public int deleteNotice(int noticeNo);

	public int deleteBook(int noticeNo);

	public int insertMessage(MessageDTO message);

	public List<MessageDTO> selectMessage(String userId);

	public List<MessageDTO> selectMessageP(String userId, int low, int high);

	public List<MessageDTO> selectReceiveMessage(String userId);

	public List<MessageDTO> selectReceiveMessageP(String userId, int low,
			int high);
}
