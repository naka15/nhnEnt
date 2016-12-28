package com.twoyears.model.dto;

import java.util.Date;

public class ReplyDTO {

	
	
	private int replyNo;
	private int noticeNo;
	private String userId;
	private String replyContent;
	private String replyDate;
	
	public ReplyDTO(){}

	public ReplyDTO(int replyNo, int noticeNo, String userId,
			String replyContent, String replyDate) {
		super();
		this.replyNo = replyNo;
		this.noticeNo = noticeNo;
		this.userId = userId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "ReplyDTO [replyNo=" + replyNo + ", noticeNo=" + noticeNo
				+ ", userId=" + userId + ", replyContent=" + replyContent
				+ ", replyDate=" + replyDate + "]";
	}

	
	
	
	
	
}
