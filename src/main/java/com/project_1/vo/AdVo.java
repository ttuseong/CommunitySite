package com.project_1.vo;

public class AdVo {
	private int adNo;
	private String adTitle;
	private String adDesc;
	private String adImg;
	private int adEffect;
	
	public AdVo() {
		super();
	}

	public AdVo(int adNo, String adTitle, String adDesc, String adImg, int adEffect) {
		super();
		this.adNo = adNo;
		this.adTitle = adTitle;
		this.adDesc = adDesc;
		this.adImg = adImg;
		this.adEffect = adEffect;
	}

	public int getAdNo() {
		return adNo;
	}

	public void setAdNo(int adNo) {
		this.adNo = adNo;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdDesc() {
		return adDesc;
	}

	public void setAdDesc(String adDesc) {
		this.adDesc = adDesc;
	}

	public String getAdImg() {
		return adImg;
	}

	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}

	public int getAdEffect() {
		return adEffect;
	}

	public void setAdEffect(int adEffect) {
		this.adEffect = adEffect;
	}

	@Override
	public String toString() {
		return "AdVo [adNo=" + adNo + ", adTitle=" + adTitle + ", adDesc=" + adDesc + ", adImg=" + adImg + ", adEffect="
				+ adEffect + "]";
	}
	
	
}
