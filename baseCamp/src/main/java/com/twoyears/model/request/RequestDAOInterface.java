package com.twoyears.model.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twoyears.model.dto.RequestDTO;
import com.twoyears.model.dto.RequestNoticeDTO;
import com.twoyears.model.dto.RequestReplyDTO;
import com.twoyears.model.dto.RqrpJoinUsers;

public interface RequestDAOInterface {
	public List<RequestDTO> selectByRownum(int low, int high);
	public int selectCount();
	public List<RequestDTO> selectByTitle(String title, int low, int high);
	public List<RequestDTO> selectByContent(String content, int low, int high);
	public List<RequestDTO> selectByUser(String user, int low, int high);
	public int selectByTitleCount(String title);
	public int selectByContentCount(String content);
	public int selectByUserCount(String user);
	
	public RequestDTO selectRequest(int rqNo);
	
	public int updateRequestCount(int count, int rqNo);
	public int insertRequestReply(RequestReplyDTO requestReply);
	public List<RqrpJoinUsers> selectByRqrp(int rqNo);
	 public int deleteRequestReply(int rqNo, int rqrp_no, String userId);
	 public int insertRequestNotice(RequestNoticeDTO rqNotice);
	 public int deleteRequest(int noticeNo);
}
