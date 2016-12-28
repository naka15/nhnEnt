package com.twoyears.modelDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.BookDTO;
import com.twoyears.model.dto.MessageDTO;
import com.twoyears.model.dto.NoticeDTO;
import com.twoyears.model.dto.ReplyDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.UsersDTO;

@Component("userdao")
public class UserDAO implements UserDAOInterface{
	
	@Autowired
	SqlSession session;
	
	@Override
	public UsersDTO selectByusers(String userId, String userPwd) {
		UsersDTO users = new UsersDTO();
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		users = session.selectOne("givook.users.selectByusers", map);
		return users;
	}

	public UsersDTO selectByuserNick(String userNick){
		UsersDTO users = new UsersDTO();
		users = session.selectOne("givook.users.selectByuserNick", userNick);
		return users;
	}
	
	public UsersDTO selectByuserId(String userId){
		UsersDTO users = new UsersDTO();
		users = session.selectOne("givook.users.selectByuserId", userId);
		return users;
	}
	
	
	public int insertUsers(UsersDTO users){
		return session.insert("givook.users.insertUsers", users);
	}
	/* ******notice******** */
	
	
	public int selectBynextVal(){
		int t = session.selectOne("givook.notice.selectBynextVal");
	
		return t;
	}
	
	public int insertNotice(NoticeDTO notice){
		return session.insert("givook.notice.insertNotice" , notice);
	}
	
	public int insertBook(BookDTO book){
		return session.insert("givook.notice.insertBook", book);
	}
	
	public NoticeDTO selectBynoticeAll(int mno){
		return  session.selectOne("givook.notice.selectBynoticeAll", mno);
	}
	
	public BookDTO selectByBookAll(int mno){
		return  session.selectOne("givook.notice.selectByBookAll", mno);
	}
	
	
	
	 //윤관쓰
	  

	  
	   public UsersDTO userSelectByEmail(String userEmail){

	      return session.selectOne("givook.users.userSelectByEmail",userEmail);      
	   }
	
	   public UsersDTO userSelectJoinCondition(String userId, String userNick, String userEmail){

	      Map<String, String> map = new HashMap<String, String>();
	      map.put("userId", userId);
	      map.put("userNick", userNick);
	      map.put("userEmail", userEmail);
	      
	      return session.selectOne("givook.users.userSelectJoinCondition",map);      
	   }
	   
	   public int userInsert(String userId, String userPwd, String userName, 
		         String userNick, String userPhone,String userEmail){

		      Map<String, String> map = new HashMap<String, String>();
		      map.put("userId", userId);
		      map.put("userPwd", userPwd);
		      map.put("userName", userName);
		      map.put("userNick",userNick);
		      map.put("userPhone",userPhone);
		      map.put("userEmail", userEmail);

		      return session.insert("user.userInsert",map);      
		   }
	 
	   
	   public int userUpdate(String userId, String userPwd, String userName, 
	         String userNick, String userPhone,String userEmail){

	      Map<String, String> map = new HashMap<String, String>();
	      map.put("userId", userId);
	      map.put("userPwd", userPwd);
	      map.put("userName", userName);
	      map.put("userNick",userNick);
	      map.put("userPhone",userPhone);
	      map.put("userEmail", userEmail);
	   
	      return session.update("givook.users.userUpdate",map);      
	   }
	   
	   public int userDelete(String userId){

	      return session.update("givook.users.userDelete",userId);      
	   }
	   
	   public int updateCount(int count, int noticeNo){
		   Map<String, Integer> map = new HashMap<String, Integer>();
		   map.put("noticeNo", noticeNo);
		   map.put("noticeCount", count);
		   return session.update("givook.notice.updateCount", map);
	   }
	   

// reply
	   
	   public int createReply(ReplyDTO reply){
		   return session.insert("givook.notice.createReply" , reply);
	   }
	   
	   public int deleteReply(int replyNo, int noticeNo, String userId){
		   Map<String, String> map = new HashMap<String, String>();
		   map.put("replyNo", replyNo+"");
		   map.put("noticeNo", noticeNo+"");
		   map.put("userId", userId);
		   return session.delete("givook.notice.deleteReply", map);
	   }
	
	   public List<ReplyDTO> selectReplyList(int noticeNo){
		   return session.selectList("givook.notice.selectReplyList", noticeNo);
		   
	   }
	   
	   public List<RequestNoticeDTO>userSelectByMyRequestWirte(String userId){
		      return session.selectList("givook.mapper.request.userSelectByMyRequestWirte", userId);
		   }
	   public List<NoticeDTO> userSelectByMyWirte(String userId){
		      return session.selectList("givook.mapper.request.userSelectByMyWirte",userId);
		   }
	   
	   
	   public int deleteNotice(int noticeNo){
		   return session.delete("givook.notice.deleteNotice", noticeNo);
	   }
	   
	   public int deleteBook(int noticeNo){
		   return session.delete("givook.notice.deleteBook", noticeNo);
	   }
	   
	 

	   public int insertMessage(MessageDTO message){
	         return session.insert("givook.notice.insertMessage", message);
	      }
	      public List<MessageDTO> selectMessage(String fromUserId){
	         return session.selectList("givook.notice.selectMessage",fromUserId);
	      }
	      public List<MessageDTO> selectReceiveMessage(String userId){
	         return session.selectList("givook.notice.selectReceiveMessage",userId);
	      }

		@Override
		public List<MessageDTO> selectMessageP(String userId, int low, int high) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("userId",userId);
			map.put("low",Integer.toString(low));
			map.put("high", Integer.toString(high));
			
			return session.selectList("givook.notice.selectMessageP",map);
		}

		@Override
		public List<MessageDTO> selectReceiveMessageP(String userId, int low,
				int high) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("userId",userId);
			map.put("low",Integer.toString(low));
			map.put("high", Integer.toString(high));
			
			return session.selectList("givook.notice.selectReceiveMessageP",map);
		}

		@Override
		public List<NoticeDTO> userSelectByMyWriteP(String userId, int low,
				int high) {
			Map<String,String> map = new HashMap<String, String>();
			
			System.out.println("userId---  "+userId+"  low-- "+low+"  high-- "+high);
			
			map.put("userId", userId);
			map.put("low", Integer.toString(low));
			map.put("high", Integer.toString(high));
			return session.selectList("givook.mapper.request.userSelectByMyWriteP",map);
		}

		@Override
		public List<RequestNoticeDTO> userSelectByMyRequestWirteP(
				String userId, int requestlow, int requesthigh) {
			Map<String,String> map = new HashMap<String,String>();
			
			System.out.println("userId---  "+userId+"  low-- "+requestlow+"  high-- "+requesthigh);
			
			map.put("userId", userId);
			map.put("requestlow", Integer.toString(requestlow));
			map.put("requesthigh", Integer.toString(requesthigh));
			return session.selectList("givook.mapper.request.userSelectByMyRequestWriteP",map);
		}

}
