package com.twoyears.model.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twoyears.model.dto.RequestDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.RequestReplyDTO;
import com.twoyears.model.dto.RqrpJoinUsers;
import com.twoyears.model.dto.UsersDTO;


@Component("request_dao")
public class RequestDAO implements RequestDAOInterface{
	@Autowired
	SqlSession session;

	@Override
	public List<RequestDTO> selectByRownum(int low, int high) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("low", Integer.toString(low));
		map.put("high", Integer.toString(high));
		return session.selectList("givook.mapper.request.selectByRownum",map);
	}

	@Override
	public int selectCount() {
		return session.selectOne("givook.mapper.request.selectCount");
	}

	@Override
	public List<RequestDTO> selectByTitle(String title, int low, int high) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("low", Integer.toString(low));
		map.put("high", Integer.toString(high));
		return session.selectList("givook.mapper.request.selectByTitle",map);
	}

	@Override
	public List<RequestDTO> selectByContent(String content, int low, int high) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("content", content);
		map.put("low", Integer.toString(low));
		map.put("high", Integer.toString(high));
		return session.selectList("givook.mapper.request.selectByContent",map);
	}

	@Override
	public List<RequestDTO> selectByUser(String user, int low, int high) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user", user);
		map.put("low", Integer.toString(low));
		map.put("high", Integer.toString(high));
		return session.selectList("givook.mapper.request.selectByUser",map);
	}

	@Override
	public int selectByTitleCount(String title) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		return session.selectOne("givook.mapper.request.selectByTitleCount",map);
	}

	@Override
	public int selectByContentCount(String content) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("content", content);
		return session.selectOne("givook.mapper.request.selectByContentCount",map);
	}

	@Override
	public int selectByUserCount(String user) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user", user);
		return session.selectOne("givook.mapper.request.selectByUserCount",map);
	}
	
	public RequestDTO selectRequest(int rqNo){
		return session.selectOne("givook.mapper.request.selectRequest", rqNo);
	}
	
	public int updateRequestCount(int count, int rqNo){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rqCount", count);
		map.put("rqNo", rqNo);
		
		return session.update("givook.mapper.request.updateRequestCount", map);
	}
	
	public int insertRequestReply(RequestReplyDTO requestReply){
		
		int rqNo = requestReply.getRqNo();
		String userId = requestReply.getUserId();
		String rqrp_content = requestReply.getRqrp_content();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("rqNo", rqNo+"");
		map.put("userId", userId);
		map.put("rqrp_content", rqrp_content);
		return session.insert("givook.mapper.request.insertRequestReply", map);
	}
	
	public int deleteRequestReply(int rqNo, int rqrp_no, String userId){
		Map<String, String> map = new HashMap<String, String>();
		map.put("rqNo", rqNo+"");
		map.put("rqrp_no", rqrp_no+"");
		map.put("userId", userId);
		
		return session.delete("givook.mapper.request.deleteRqrp", map);
	}
	
	public List<RqrpJoinUsers> selectByRqrp(int rqNo){
		return session.selectList("givook.mapper.request.selectByRqrp", rqNo);
	}
	
	
	public int insertRequestNotice(RequestNoticeDTO rqNotice){
		return session.insert("givook.mapper.request.insertRequestNotice", rqNotice);
	}
	
	public int deleteRequest(int noticeNo){
		return session.delete("givook.mapper.request.deleteRequest", noticeNo);
	}
	
}
