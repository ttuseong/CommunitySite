package com.project_1.vo;

public class EventVo {
	private int eventNo;
	private String eventImg;
	private String eventLink;
	private String eventName;
	
	
	public EventVo() {
		super();
	}

	public EventVo(int eventNo, String eventImg, String eventLink, String eventName) {
		super();
		this.eventNo = eventNo;
		this.eventImg = eventImg;
		this.eventLink = eventLink;
		this.eventName = eventName;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLink() {
		return eventLink;
	}

	public void setEventLink(String eventLink) {
		this.eventLink = eventLink;
	}

	@Override
	public String toString() {
		return "EventVo [eventNo=" + eventNo + ", eventImg=" + eventImg + ", eventName=" + eventName + ", eventLink="
				+ eventLink + "]";
	}
	
	
}
