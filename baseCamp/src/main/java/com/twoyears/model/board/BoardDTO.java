package com.twoyears.model.board;

import java.util.Date;

public class BoardDTO {
	private int noticeNo; 				//게시물 번호 primary key
	private String noticeTitle;			//게시물 제목
	private String noticeContent;		//게시물 내용
	private String userID;				//등록한 게시자 아이디, FK
	private Date noticeDate;			//게시판 등록 날자, 시간
	private String noticeStatus;		//거래완료되었는지 상태
	private int noticeCount;			//조회수
	private String noticeMethod;		//기부방법, 거래방법
	private String noticeLocation;		//거래 지역
	
	
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(int noticeNo, String noticeTitle, String noticeContent,
			String userID, Date noticeDate, String noticeStatus,
			String donateMethod, int noticeCount, String noticeLocation) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userID = userID;
		this.noticeDate = noticeDate;
		this.noticeStatus = noticeStatus;
		this.noticeMethod = donateMethod;
		this.noticeCount = noticeCount;
		this.noticeLocation = noticeLocation;
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
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	
	public String getNoticeMethod() {
		return noticeMethod;
	}

	public void setNoticeMethod(String noticeMethod) {
		this.noticeMethod = noticeMethod;
	}

	public int getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	public String getNoticeLocation() {
		return noticeLocation;
	}
	public void setNoticeLocation(String noticeLocation) {
		this.noticeLocation = noticeLocation;
	}

	
	
	
	
}
