package com.iftac.jesno.chatclient;

public class Message {

	private String nickName;
	private String message;
	
	public Message(String nickName, String message) {
		this.message = message;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "<" + nickName + "> " + message;
	}

	public String getNickName() {
		return nickName;

	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getMesssage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}




}
