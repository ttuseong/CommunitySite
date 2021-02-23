package com.project_1.vo;

public class UserVo {
	private String managerID;
	private String managerPW;
	
	public UserVo() {

	}

	public UserVo(String managerID, String managerPW) {
		super();
		this.managerID = managerID;
		this.managerPW = managerPW;
	}

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public String getManagerPW() {
		return managerPW;
	}

	public void setManagerPW(String managerPW) {
		this.managerPW = managerPW;
	}

	@Override
	public String toString() {
		return "UserVo [managerID=" + managerID + ", managerPW=" + managerPW + "]";
	}

	
	

}
