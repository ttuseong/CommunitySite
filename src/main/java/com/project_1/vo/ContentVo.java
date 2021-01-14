package com.project_1.vo;

public class ContentVo {
	int contentNo;
	int boardNo;
	String boardTitle;
	
	public ContentVo() {}
	
	public ContentVo(int contentNo, int boardNo, String boardTitle) {
		this.contentNo = contentNo;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
	}

	public int getContentNo() {
		return contentNo;
	}
	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}
	
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	@Override
	public String toString() {
		return "ContentVo [contentNo=" + contentNo + ", boardNo=" + boardNo + ", boardTitle=" + boardTitle + "]";
	}
	
}
