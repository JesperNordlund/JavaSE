package com.iftac.jesno.chatclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatServerConnectionFactory {

	private Socket socket;
	private static String serverAddress = "chatlab.testbed.se";
	private static int port = 8000;
	private OutputStream outputStream;
	private InputStream inputStream;

	private static ChatServerConnectionFactory instance;

	public static synchronized ChatServerConnectionFactory getInstance(){
		if(instance == null){
			instance = new ChatServerConnectionFactory();
		}
		return instance;
	}

	/**
	 * Tries to connect to chat server, create a input and output stream
	 */
	public ChatServerConnectionFactory() {

			startConnection();	

	}


	private void startConnection() {
		try {
			System.out.println("Trying to establish connection to " + serverAddress);
			socket = new Socket(serverAddress, port);
			System.out.println("Connection established to " + socket.getInetAddress());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			System.out.println("Trying to establish output stream");
			outputStream = socket.getOutputStream();
			System.out.println("Output stream successfully established");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("Trying to establish output stream");
			inputStream = socket.getInputStream();
			System.out.println("Output stream successfully established");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Socket getSocket() {
		return socket;
	}


	public String getServerAddress() {
		return serverAddress;
	}



	public int getPort() {
		return port;
	}


	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public InputStream getInputStream() {

		return inputStream;
	}



}
