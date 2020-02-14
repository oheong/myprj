package com.ssafy.prj.board.vo;

public class Board {
	private int no;
	private int viewCnt;
	
	private String title;
	private String writer;
	private String content;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", viewCnt=" + viewCnt + ", title=" + title + ", writer=" + writer + ", content="
				+ content + "]";
	}

}
