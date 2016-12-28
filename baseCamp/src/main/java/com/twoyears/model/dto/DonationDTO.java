package com.twoyears.model.dto;

public class DonationDTO {

	 private int danationId;
	 private String userId_sender;
	 private String userId_receiver;
	 private int status_sender;
	 private int status_receiver;
	 
	 public DonationDTO(){}
	 
	 
	 public DonationDTO(int danationId, String userId_sender,
			String userId_receiver, int status_sender, int status_receiver) {
		super();
		this.danationId = danationId;
		this.userId_sender = userId_sender;
		this.userId_receiver = userId_receiver;
		this.status_sender = status_sender;
		this.status_receiver = status_receiver;
	}
	public int getDanationId() {
		return danationId;
	}
	public void setDanationId(int danationId) {
		this.danationId = danationId;
	}
	public String getUserId_sender() {
		return userId_sender;
	}
	public void setUserId_sender(String userId_sender) {
		this.userId_sender = userId_sender;
	}
	public String getUserId_receiver() {
		return userId_receiver;
	}
	public void setUserId_receiver(String userId_receiver) {
		this.userId_receiver = userId_receiver;
	}
	public int getStatus_sender() {
		return status_sender;
	}
	public void setStatus_sender(int status_sender) {
		this.status_sender = status_sender;
	}
	public int getStatus_receiver() {
		return status_receiver;
	}
	public void setStatus_receiver(int status_receiver) {
		this.status_receiver = status_receiver;
	}
	@Override
	public String toString() {
		return "DonationDTO [danationId=" + danationId + ", userId_sender="
				+ userId_sender + ", userId_receiver=" + userId_receiver
				+ ", status_sender=" + status_sender + ", status_receiver="
				+ status_receiver + "]";
	}
	 
	 
	 
	 
}
