package com.twoyears.model.dto;

public class FavoriteDTO {
	

	private String userId;
	private int noticeNo;
	
	public FavoriteDTO(){}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}



	@Override
	public String toString() {
		return "FavoriteDTO [userId=" + userId + ", noticeNo=" + noticeNo + "]";
	}



}
