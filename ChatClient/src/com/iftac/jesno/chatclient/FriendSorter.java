package com.iftac.jesno.chatclient;

import java.util.Comparator;

public class FriendSorter implements Comparable<Friend> {


	// Comparator to sort a list of friends by nickname a-z
	public static Comparator<Friend> byNickName = new Comparator<Friend>() {

		public int compare(Friend friend1, Friend friend2) {

			String friendName1 = friend1.getNickName().toUpperCase();
			String friendName2 = friend2.getNickName().toUpperCase();

			//ascending order
			return friendName1.compareTo(friendName2);

			//descending order
			//return friendName2.compareTo(friendName1);




		}};

		@Override
		public int compareTo(Friend o) {
			// TODO Auto-generated method stub
			return 0;
		}



}
