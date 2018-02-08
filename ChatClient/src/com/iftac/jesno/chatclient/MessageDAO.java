package com.iftac.jesno.chatclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class MessageDAO {

	private static MessageDAO instance;


	public static synchronized MessageDAO getInstance(){
		if(instance == null){
			instance = new MessageDAO();
		}
		return instance;
	}

	public MessageDAO() {

	}

	/**
	 * Saves the message to a logfile named nickName_logfile.txt
	 * @param message
	 */
	public void logPrivateMessage(Message message) {

		try(FileWriter fw = new FileWriter(message.getNickName() + "_logfile.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
		{
			out.print("<" + message.getNickName() + "> " + message.getMesssage());
			System.out.println("<" + message.getNickName() + "> " + message.getMesssage());

		} catch (IOException e) {
			e.printStackTrace();
		}   
	}    

/**
 * Saves the message to a logfile named public_logfile.txt
 * @param message
 */
	public void logPublicMessage(Message message) {

		try(FileWriter fw = new FileWriter("public_logfile.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
		{
			out.print("<" + message.getNickName() + "> " + message.getMesssage());
			System.out.println("<" + message.getNickName() + "> " + message.getMesssage());

		} catch (IOException e) {
			e.printStackTrace();
		}   

	}

	/**
	 * 
	 * @param nickName
	 */
	public void printLog(String nickName) {

		BufferedReader br = null;
		FileReader fr = null;

		if(nickName.matches("public")) {
			try {

				br = new BufferedReader(new FileReader(nickName + "_logfile.txt"));

				String sCurrentLine;
				System.out.println("Printing public chatlog");

				while ((sCurrentLine = br.readLine()) != null) {

					System.out.println(sCurrentLine.toString());
				}

				System.out.println("END OF LOG");

			} catch (IOException e) {

				System.out.println("Public chatlog not found");

			} finally {



				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
		}
		else {

			try {

				br = new BufferedReader(new FileReader(nickName + "_logfile.txt"));

				String sCurrentLine;
				System.out.println("Printing private chatlog with: " + nickName);

				while ((sCurrentLine = br.readLine()) != null) {

					System.out.println(sCurrentLine.toString());
				}

				System.out.println("END OF LOG");

			} catch (IOException e) {

				System.out.println("Chatlog for " + nickName + " not found");

			} finally {



				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
		}


	}

}
