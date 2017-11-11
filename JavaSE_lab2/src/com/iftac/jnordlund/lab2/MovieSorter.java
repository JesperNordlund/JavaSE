package com.iftac.jnordlund.lab2;

import java.util.Comparator;

public class MovieSorter implements Comparable<Movie> {
	
	// Comparator to sort a list of Movies by title
	public static Comparator<Movie> byTitle = new Comparator<Movie>() {

		public int compare(Movie movie1, Movie movie2) {

			String movieTitle1 = movie1.getTitle().toUpperCase();
			String movieTitle2 = movie2.getTitle().toUpperCase();

			//ascending order
			//return movieTitle1.compareTo(movieTitle2);
			
			//descending order
		      return movieTitle2.compareTo(movieTitle1);
		}

};
	
	//Comparator to sort a list of Movies by actor
	public static Comparator<Movie> byActor = new Comparator<Movie>() {

	public int compare(Movie movie1, Movie movie2) {

		String movieActor1 = movie1.getActor().toUpperCase();
		String movieActor2 = movie2.getActor().toUpperCase();

		//ascending order
		return movieActor1.compareTo(movieActor2);
		
		//descending order
	      //return movieActor2.compareTo(movieActor1);
	}

};

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
