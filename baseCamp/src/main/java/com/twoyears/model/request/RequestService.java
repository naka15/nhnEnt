package com.twoyears.model.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.RequestDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.RequestReplyDTO;
import com.twoyears.model.dto.RqrpJoinUsers;

@Component("request_service")
public class RequestService implements RequestServiceInterface{
	@Autowired
	private RequestDAOInterface request_dao;

	@Override
	public List<RequestDTO> selectByRownum(int low, int high) {
		return request_dao.selectByRownum(low,high);
	}

	@Override
	public int selectCount() {
		return request_dao.selectCount();
	}

	@Override
	public List<RequestDTO> selectByTitle(String title, int low, int high) {
		return request_dao.selectByTitle(title,low,high);
	}

	@Override
	public List<RequestDTO> selectByContent(String content, int low, int high) {
		return request_dao.selectByContent(content,low,high);
	}

	@Override
	public List<RequestDTO> selectByUser(String user, int low, int high) {
		return request_dao.selectByUser(user,low,high);
	}

	@Override
	public int selectByTitleCount(String title) {
		return request_dao.selectByTitleCount(title);
	}

	@Override
	public int selectByContentCount(String content) {
		// TODO Auto-generated method stub
		return request_dao.selectByContentCount(content);
	}

	@Override
	public int selectByUserCount(String user) {
		// TODO Auto-generated method stub
		return request_dao.selectByUserCount(user);
	}
	
public RequestDTO selectRequest(int rqNo){
	return request_dao.selectRequest(rqNo);
}
	
	public int updateRequestCount(int count, int rqNo){
		return request_dao.updateRequestCount(count, rqNo);
	}
	
	public int insertRequestReply(RequestReplyDTO requestReply){
		return request_dao.insertRequestReply(requestReply);
	}
	
	public List<RqrpJoinUsers> selectByRqrp(int rqNo){
		return request_dao.selectByRqrp(rqNo);
	}
	
	 public int deleteRequestReply(int rqNo, int rqrp_no, String userId){
		 return request_dao.deleteRequestReply(rqNo, rqrp_no, userId);
	 }
	 
	 public int insertRequestNotice(RequestNoticeDTO rqNotice){
		 return request_dao.insertRequestNotice(rqNotice);
	 }

	 public int deleteRequest(int noticeNo){
		 return request_dao.deleteRequest(noticeNo);
	 }

}
