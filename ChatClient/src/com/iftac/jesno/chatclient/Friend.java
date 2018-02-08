package com.iftac.jesno.chatclient;


public class Friend implements Comparable<Friend>{// implements Comparable so the object can be sorted easily

	private String nickName;
	private String fullName;
	private String ipAddress;
	private String info;

	public Friend(String nickName, String fullName, String ipAddress, String info) {
		this.nickName = nickName;
		this.fullName = fullName;
		this.ipAddress = ipAddress;
		this.info = info;
	}

	@Override
	public String toString() {
		return "Friend [nickName=" + nickName + ", fullName=" + fullName + ", ipAddress=" + ipAddress + ", info=" + info
				+ "]";
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public int compareTo(Friend compareFriend) {
		return 0;

	}
}
