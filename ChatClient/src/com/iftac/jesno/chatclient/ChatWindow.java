package com.iftac.jesno.chatclient;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.text.DefaultCaret;
import javax.swing.ScrollPaneConstants;

public class ChatWindow {

	private JFrame frmChatclient;
	private JTextField txtInput;
	private JTextArea txtpnFriendArea;
	private JScrollPane scrollPane;
	private JTextArea txtpnChatArea;
	private JScrollPane scrollPane2;

	private static ChatWindow instance;
	private JButton btnLogOut;


	public ChatWindow() {
		initialize();
	}




	public static synchronized ChatWindow getInstance(){
		if(instance == null){
			instance = new ChatWindow();
		}
		return instance;
	}


	/**
	 * Initializes the chat window and all it's components
	 */
	private void initialize() {
		frmChatclient = new JFrame();
		frmChatclient.setTitle("ChatClient");
		frmChatclient.setBounds(100, 100, 800, 600);
		frmChatclient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChatclient.setVisible(true);

		txtpnChatArea = new JTextArea();
		scrollPane = new JScrollPane(txtpnChatArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		DefaultCaret caret = (DefaultCaret)txtpnChatArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		frmChatclient.getContentPane().add(scrollPane, BorderLayout.CENTER);
		txtpnChatArea.setWrapStyleWord(true);
		txtpnChatArea.setLineWrap(true);

		JPanel southPanel = new JPanel();
		frmChatclient.getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(5, 5));

		txtInput = new JTextField();
		southPanel.add(txtInput, BorderLayout.CENTER);
		txtInput.setColumns(10);

		JButton btnSend = new JButton("Send");
		southPanel.add(btnSend, BorderLayout.EAST);

		JPanel eastPanel = new JPanel();
		frmChatclient.getContentPane().add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new BorderLayout(5, 5));

		txtpnFriendArea = new JTextArea();
		scrollPane2 = new JScrollPane(txtpnFriendArea);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		eastPanel.add(scrollPane2, BorderLayout.CENTER);



		frmChatclient.getRootPane().setDefaultButton(btnSend);

		btnLogOut = new JButton("Log out");
		eastPanel.add(btnLogOut, BorderLayout.NORTH);

		btnLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ChatDAO.getInstance().logOut();

			}
		});
		
		// Action listener listens for the send button to be
		// pressed. When pressed text input will be processed.
		btnSend.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = txtInput.getText();
				txtInput.setText("");

				String nickName = null;
				String message = null;


				// Checks if input is a command using "-"
				if(text.startsWith("-")) {

					String[] split = text.split(" ");

					String command = (String) Array.get(split, 0);			

					switch (command) {
					case "-ql":
						nickName = (String) Array.get(split, 1);
						try {
							MessageDAO.getInstance().printLog(nickName);

						} catch (Exception e2) {
							System.out.println("Missing name parameter(-ql nickname)");
						}

						break;

					case "-qf":
						nickName = (String) Array.get(split, 1);
						try {
							FriendDAO.getInstance().printFriendInfo(nickName);

						} catch (Exception e2) {
							System.out.println("Missing name parameter(-ql nickname)");
						}

						break;

					case "-qpl":
						MessageDAO.getInstance().printLog("public");

						break;

					case "-pf":
						List<Friend> friends = ChatDAO.getInstance().getFriendsList();

						for(Friend friend : friends) {
							System.out.println(friend); 
						}

						break;
					}
				}
				else {
					
					// @ followed directly by a nickname indicates it's a private message
					// String is split and nickname and message is seperated
					if(text.startsWith("@")) {

						String[] split = text.split(" ");
						nickName = (String) Array.get(split, 0);
						nickName = nickName.substring(1);

						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < split.length; i++) {
							sb.append(split[i]);
							if (i != split.length - 1) {
								sb.append(" ");
							}
						}
						message = sb.toString();

						ChatDAO.getInstance().writePrivateMessage(nickName, message);;

					}

					else {
						message = text;
						ChatDAO.getInstance().writePublicMessage(message);
					}
				}

			}





		});
	}

	/**
	 * Appends a string of text to the chat area of the chat window
	 * @param text
	 */
	public void appendText(String text) {
		txtpnChatArea.append(text + "\n");
	}

	/**
	 * Called when a new friend comes online to update the chat windows list of friends
	 * @param friendsList
	 */
	public void updateFriends(List<Friend> friendsList) {
		for (Friend friend : friendsList) {
			if(!txtpnFriendArea.getText().contains(friend.getNickName())) {
				txtpnFriendArea.append(friend.getNickName() + "\n");
			}
		}

	}

}
