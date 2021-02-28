package com.project_1.vo;

public class UserVo {
	private String managerID;
	private String managerPW;
	private String salt;
	
	public UserVo() {

	}

	public UserVo(String managerID, String managerPW, String salt) {
		this.managerID = managerID;
		this.managerPW = managerPW;
		this.salt = salt;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "UserVo [managerID=" + managerID + ", managerPW=" + managerPW + ", salt=" + salt + "]";
	}
}
