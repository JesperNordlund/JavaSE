package com.iftac.jesno.chatclient;

import java.io.IOException;

public class Client implements Runnable {


	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;


	public Client() {}


	@Override
	public void run() {
		ChatServerConnectionFactory connection = ChatServerConnectionFactory.getInstance();

		ChatDAO chatDAO = ChatDAO.getInstance();

		chatDAO.registerToServer("jeppzor", "Jesper Nordlund", chatDAO.getIP(), "Gävlebo");


		try {
			chatDAO.listenToStream(connection.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}



}
