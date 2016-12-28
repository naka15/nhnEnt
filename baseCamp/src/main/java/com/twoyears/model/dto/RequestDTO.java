package com.twoyears.model.dto;

import java.util.Date;

public class RequestDTO {
	private int rqNo;			//요청게시물 번호
	private String userId;		//요청게시물 작성자
	private String rqTitle;		//게시물제목
	private String rqContent;	//게시물 내용
	private String rqDate;		//게시날짜
	private int rqCount;		//조회수
	private String rqLocation;	//작성자 지역
	//users
	private String userPwd;		//비밀번호
	private String userName;	//작성자이름
	private String userNick;	//닉네임
	private String userPhone;	//전화번호
	private String userEmail;	//email주소
	private int userPoint;		//유저포인트
	
	public int getRqNo() {
		return rqNo;
	}
	public void setRqNo(int rqNo) {
		this.rqNo = rqNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRqTitle() {
		return rqTitle;
	}
	public void setRqTitle(String rqTitle) {
		this.rqTitle = rqTitle;
	}
	public String getRqContent() {
		return rqContent;
	}
	public void setRqContent(String rqContent) {
		this.rqContent = rqContent;
	}
	public String getRqDate() {
		return rqDate;
	}
	public void setRqDate(String rqDate) {
		this.rqDate = rqDate;
	}
	public int getRqCount() {
		return rqCount;
	}
	public void setRqCount(int rqCount) {
		this.rqCount = rqCount;
	}
	public String getRqLocation() {
		return rqLocation;
	}
	public void setRqLocation(String rqLocation) {
		this.rqLocation = rqLocation;
	}
	
}
