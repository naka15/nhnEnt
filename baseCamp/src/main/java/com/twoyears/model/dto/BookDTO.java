package com.twoyears.model.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class BookDTO {
	
	private int noticeNo;
	private String bookSubject;
	private String bookPrice;
	private String bookPic;//파일이름 => DB에 저장.
	private String bookGenre;
	private String bookNum;
	private String bookQty;
	private CommonsMultipartFile pic; //업로드한 파일을 웹서버에 저장
	
	public BookDTO(){}

	public BookDTO(int noticeNo, String bookSubject, String bookPrice,
			String bookPic, String bookGenre, String bookNum, String bookQty
		) {
		super();
		this.noticeNo = noticeNo;
		this.bookSubject = bookSubject;
		this.bookPrice = bookPrice;
		this.bookPic = bookPic;
		this.bookGenre = bookGenre;
		this.bookNum = bookNum;
		this.bookQty = bookQty;
		this.pic = pic;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPic() {
		return bookPic;
	}

	public void setBookPic(String bookPic) {
		this.bookPic = bookPic;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookQty() {
		return bookQty;
	}

	public void setBookQty(String bookQty) {
		this.bookQty = bookQty;
	}

	public CommonsMultipartFile getPic() {
		return pic;
	}

	public void setPic(CommonsMultipartFile pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "BookDTO [noticeNo=" + noticeNo + ", bookSubject=" + bookSubject
				+ ", bookPrice=" + bookPrice + ", bookPic=" + bookPic
				+ ", bookGenre=" + bookGenre + ", bookNum=" + bookNum
				+ ", bookQty=" + bookQty + ", pic=" + "]";
	}

	

	
	
	
	

}
