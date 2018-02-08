package com.iftac.jesno.chatclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ChatDAO {

	private ChatServerConnectionFactory connection;
	private PrintStream printStream;
	private List<Friend> friendsList;
	private boolean isLoggedIn;


	private static ChatDAO instance;


	public static synchronized ChatDAO getInstance(){
		if(instance == null){
			instance = new ChatDAO();
		}
		return instance;
	}

	public ChatDAO() {
		this.connection = ChatServerConnectionFactory.getInstance();
		this.printStream = new PrintStream(connection.getOutputStream());


	}

	/**
	 * Listens to an inputstream using the InputStreamReader then depending on the first tag word
	 * performs appropriate action.
	 * @param inputStream
	 * @throws IOException
	 */
	public void listenToStream(InputStream inputStream) throws IOException {

		InputStreamReader isr = new InputStreamReader(inputStream);

		String nickName;
		String fullName;
		String ipAddress;
		String info;
		String message;
		String tag;

		friendsList = new ArrayList<Friend>();

		// Runs while program is running
		while(true) {
			tag = readTag(isr);


			switch(tag) {
			case "FRIEND":
				nickName = readTag(isr);
				fullName = readTag(isr);
				ipAddress = readTag(isr);
				info = readTag(isr);

				System.out.println("Nickname: " + nickName + " Full name: " + fullName + " IP: " + ipAddress + " info: " + info);
				ChatWindow.getInstance().appendText("Nickname: " + nickName + " Full name: " + fullName + " IP: " + ipAddress + " info: " + info);
				addFriendtoList(nickName, fullName, ipAddress, info);
				ChatWindow.getInstance().updateFriends(friendsList);


				break;

			case "PRIVATE":
				nickName = readTag(isr);
				message = readTag(isr);
				printOutPrivateMessage(nickName, message);

				Message privateMessage = new Message(nickName, message);
				MessageDAO.getInstance().logPrivateMessage(privateMessage);

				break;

			case "PUBLIC":
				nickName = readTag(isr);
				message = readTag(isr);
				printOutPublicMessage(nickName, message);

				Message publicMessage = new Message(nickName, message);
				MessageDAO.getInstance().logPublicMessage(publicMessage);

				break;

			case "LOGOUT":
				nickName = readTag(isr);
				printLogoutMessage(nickName);
			}

		}
	}

	/**
	 * Creates a friend object and adds it to the friendList
	 * @param nickName
	 * @param fullName
	 * @param ipAddress
	 * @param info
	 */
	private void addFriendtoList(String nickName, String fullName, String ipAddress, String info) {
		Friend friend = new Friend(nickName, fullName, ipAddress, info);
		friendsList.add(friend);
	}

	/**
	 * Returns the friendslist
	 * @return friendsList
	 */
	public List<Friend> getFriendsList() {
		return this.friendsList;
	}

	public void setFriendsList(ArrayList<Friend> friendsList) {
		this.friendsList = friendsList;
	}

	/**
	 * Prints out the logout message to console and chat window
	 * @param nickName
	 */
	private void printLogoutMessage(String nickName) {
		System.out.println(nickName + " logged out");
		ChatWindow.getInstance().appendText(nickName + " logged out");

	}

	/**
	 * Prints out a public message to console and chat window
	 * @param nickName
	 * @param message
	 */
	public void printOutPublicMessage(String nickName, String message) {
		System.out.println(nickName + " says: " + message);
		ChatWindow.getInstance().appendText(nickName + " says: " + message);

	}

	/**
	 * Prints out a private message to console and chat window
	 * @param nickName
	 * @param message
	 */
	public void printOutPrivateMessage(String nickName, String message) {
		System.out.println("Private message from " + nickName + ": " + message);
		ChatWindow.getInstance().appendText("Private message from " + nickName + ": " + message);

	}

	/**
	 * Reads text seperated by tags <> and returns a string
	 * @param InputStreamReader
	 * @return String
	 * @throws IOException
	 */
	public String readTag(InputStreamReader isr) throws IOException {
		StringBuilder sb = new StringBuilder();
		int data;
		while((data = isr.read()) != -1) {
			char character = (char) data;
			if(character == '>') {
				String tag = sb.toString();

				return tag.substring(1);
			}else {
				sb.append((char) data);

			}
		}
		return sb.toString();
	}

	/**
	 * Used for sending a public message to the printStream. Prints in console and chat window
	 * @param message
	 */
	public void writePublicMessage(String message) {
		if(isLoggedIn) {
			printStream.print("<PUBLIC><JEPPZOR>" + message + ">");
			System.out.println("Me: " + message);
			ChatWindow.getInstance().appendText("Me: " + message);
		}
		else {
			System.out.println("OFFLINE: " + message);
			ChatWindow.getInstance().appendText("Me: " + message);
		}
	}

	/**
	 * Used for sending a private message to the printStream. Prints in console and chat window
	 * @param nickName
	 * @param message
	 */
	public void writePrivateMessage(String nickName, String message) {
		if(isLoggedIn) {
			printStream.print("<PRIVATE><jeppzor><" + nickName + "><" + message + ">");
			System.out.println("Private message sent to " + nickName + ": " + message);
			ChatWindow.getInstance().appendText("Private message sent to " + nickName + ": " + message);
		}
		else {
			System.out.println("OFFLINE MESSAGE NOT SENT TO: " + nickName + ": " + message);
			ChatWindow.getInstance().appendText("Private message sent to " + nickName + ": " + message);
		}

	}

	/**
	 * Used to register(log on) to chat server
	 * @param nickName
	 * @param fullName
	 * @param ipAddress
	 * @param info
	 */
	public void registerToServer(String nickName, String fullName, String ipAddress, String info) {

		printStream.print("<REGISTER><" + nickName + "><" + fullName + "><" + ipAddress + "><" + info + ">");
		System.out.println("<REGISTER><" + nickName + "><" + fullName + "><" + ipAddress + "><" + info + ">");
		ChatWindow.getInstance().appendText("Logging in...");
		isLoggedIn = true;

	}

	/**
	 * Logs the user out
	 */
	public void logOut() {
		printStream.print("<LOGOUT><jeppzor>");
		System.out.println("You logged out");
		ChatWindow.getInstance().appendText("You logged out");
		isLoggedIn = false;
	}


	public ChatServerConnectionFactory getConnection() {
		return connection;
	}

	public void setConnection(ChatServerConnectionFactory connection) {
		this.connection = connection;
	}

	/**
	 * Gets external ip address by asking http://checkip.amazonaws.com/
	 * @return
	 */
	public String getIP() {
		URL url = null;
		try {
			url = new URL("http://checkip.amazonaws.com/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
