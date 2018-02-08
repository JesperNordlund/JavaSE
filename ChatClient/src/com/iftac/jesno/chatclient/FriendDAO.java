package com.iftac.jesno.chatclient;

import java.util.ArrayList;
import java.util.List;

public class FriendDAO {

	private static FriendDAO instance;


	public static synchronized FriendDAO getInstance(){
		if(instance == null){
			instance = new FriendDAO();
		}
		return instance;
	}


	public FriendDAO() {}


	/**
	 * Returns the message log of chosen friend
	 * @param friend
	 */
	public List<Message> getLog(Friend friend) {
		friend.getNickName();
		List<Message> log = new ArrayList<>();
		return log;

	}

	/**
	 * Prints out all information about a friend
	 * @param nickName
	 */
	public void printFriendInfo(String nickName) {
		try {
			for(int i = 0; i < ChatDAO.getInstance().getFriendsList().size(); i++)
				if(ChatDAO.getInstance().getFriendsList().get(i).getNickName().toLowerCase().equals(nickName.toLowerCase())) {
					System.out.println("Printing info on: " + nickName);
					System.out.println(ChatDAO.getInstance().getFriendsList().get(i).toString());

				}

		} catch (Exception e) {
			System.out.println(nickName + " is not here");
		}

	}

}
