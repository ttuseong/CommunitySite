package com.project_1.vo;

public class BoardVo {
	public int boardNo;
	public String boardName;
	public int boardType;
	
	public BoardVo() {
		
	}
	
	public BoardVo(int boardNo, String boardName, int boardType) {
		this.boardNo = boardNo;
		this.boardName = boardName;
		this.boardType = boardType;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getBoardType() {
		return boardType;
	}
	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}
	
	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", boardName=" + boardName + ", boardType=" + boardType + "]";
	}
	
	
	
}
