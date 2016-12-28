package com.twoyears.modelDAO;

public class TestDTO {
	private String title;
	private int tno;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public TestDTO(String title, int tno) {
		super();
		this.title = title;
		this.tno = tno;
	}

	public TestDTO() {
		super();
	}

}
