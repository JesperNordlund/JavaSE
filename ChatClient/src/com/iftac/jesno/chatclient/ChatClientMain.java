package com.iftac.jesno.chatclient;

import java.awt.EventQueue;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ChatClientMain {

	public static void main(String[] args) {

		/*
		 * Starting the GUI chatwindow
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatWindow.getInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*
		 * Starting the client thread
		 */
		(new Thread(new Client())).start();

		
		/*
		 * Running the the command line argument check on a 2 second delay
		 * to allow for server connection to establish
		 */
			Timer timer = new Timer();

			TimerTask delayedThreadStartTask = new TimerTask() {

				public void run() {
					if(args.length != 0) {
						String command = (String) Array.get(args, 0);
						System.out.println(command);

						String nickName = null;

						switch (command) {
						case "-ql":
							nickName = (String) Array.get(args, 1);
							MessageDAO.getInstance().printLog(nickName);

							break;

						case "-qf":
							nickName = (String) Array.get(args, 1);
							FriendDAO.getInstance().printFriendInfo(nickName);

							break;

						case "-qpl":
							MessageDAO.getInstance().printLog("public");

							break;

						case "-pf":
							List<Friend> friends = ChatDAO.getInstance().getFriendsList();
							Collections.sort(friends, FriendSorter.byNickName);
							for(Friend friend : friends) {
								System.out.println(friend); 
							}

							break;
						}


					}

				}};
				timer.schedule(delayedThreadStartTask, 2 * 1000);


	}
}
