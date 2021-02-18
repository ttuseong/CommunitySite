package com.project_1.vo;

public class ContentVo {
	int contentNo;
	int boardNo;
	String boardTitle;
	String boardTime;
	String boardContent;
	
	public ContentVo() { }

	public ContentVo(int contentNo, int boardNo, String boardTitle, String boardTime, String boardContent) {
		super();
		this.contentNo = contentNo;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardTime = boardTime;
		this.boardContent = boardContent;
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

	public String getBoardTime() {
		return boardTime;
	}

	public void setBoardTime(String boardTime) {
		this.boardTime = boardTime;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "ContentVo [contentNo=" + contentNo + ", boardNo=" + boardNo + ", boardTitle=" + boardTitle
				+ ", boardTime=" + boardTime + ", boardContent=" + boardContent + "]";
	}

	
	
}
