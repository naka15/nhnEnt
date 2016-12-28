package com.twoyears.model.dto;

import java.util.Date;

public class RqrpJoinUsers {
	
	private int rqrp_no;
	private int rqNo;
	private String userId;
	private String rqrp_content;
	private String rqrp_date;
	
	
	private String userPwd;
	private String userName;
	private String userNick;
	private String userPhone;
	private String userEmail;
	private int userPoint;
	
	public RqrpJoinUsers(){}
	public RqrpJoinUsers(int rqrp_no, int rqNo, String userId,
			String rqrp_content, String rqrp_date, String userPwd,
			String userName, String userNick, String userPhone,
			String userEmail, int userPoint) {
		super();
		this.rqrp_no = rqrp_no;
		this.rqNo = rqNo;
		this.userId = userId;
		this.rqrp_content = rqrp_content;
		this.rqrp_date = rqrp_date;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNick = userNick;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPoint = userPoint;
	}
	public int getRqrp_no() {
		return rqrp_no;
	}
	public void setRqrp_no(int rqrp_no) {
		this.rqrp_no = rqrp_no;
	}
	public int getRqNo() {
		return rqNo;
	}
	public void setRqNo(int rqNo) {
		this.rqNo = rqNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRqrp_content() {
		return rqrp_content;
	}
	public void setRqrp_content(String rqrp_content) {
		this.rqrp_content = rqrp_content;
	}
	public String getRqrp_date() {
		return rqrp_date;
	}
	public void setRqrp_date(String rqrp_date) {
		this.rqrp_date = rqrp_date;
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
	@Override
	public String toString() {
		return "RqrpJoinUsers [rqrp_no=" + rqrp_no + ", rqNo=" + rqNo
				+ ", userId=" + userId + ", rqrp_content=" + rqrp_content
				+ ", rqrp_date=" + rqrp_date + ", userPwd=" + userPwd
				+ ", userName=" + userName + ", userNick=" + userNick
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", userPoint=" + userPoint + "]";
	}
	
	
	
	

}
