package com.twoyears.model.dto;


public class NoticeDTO {

	private int noticeNo;
	private String noticeTitle;
	private String noticeDate;
	private String noticeStatus;
	private String noticeContent;
	private int noticeCount;
	private String noticeMethod;
	private String noticeLocation;
	private String userId;
	
	public NoticeDTO(){}

	public NoticeDTO(int noticeNo, String noticeTitle, String noticeDate,
			String noticeStatus, String noticeContent, int noticeCount,
			String noticeMethod, String noticeLocation, String userId) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeStatus = noticeStatus;
		this.noticeContent = noticeContent;
		this.noticeCount = noticeCount;
		this.noticeMethod = noticeMethod;
		this.noticeLocation = noticeLocation;
		this.userId = userId;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticTitle) {
		this.noticeTitle = noticTitle;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	public String getNoticeMethod() {
		return noticeMethod;
	}

	public void setNoticeMethod(String noticeMethod) {
		this.noticeMethod = noticeMethod;
	}

	public String getNoticeLocation() {
		return noticeLocation;
	}

	public void setNoticeLocation(String noticeLocation) {
		this.noticeLocation = noticeLocation;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle
				+ ", noticeDate=" + noticeDate + ", noticeStatus="
				+ noticeStatus + ", noticeContent=" + noticeContent
				+ ", noticeCount=" + noticeCount + ", noticeMethod="
				+ noticeMethod + ", noticeLocation=" + noticeLocation
				+ ", userId=" + userId + "]";
	}
	
	

}
