package com.iftac.jnordlund.lab2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	public FileReader() {

	}

	// Transferring the text file to an arraylist and returns the arraylist
	public MovieList readToList(Scanner scanner) {

		MovieList movieList = new MovieList();

		String title;
		String actor;
		int year;
		int length;
		String imdbScore;
		String director;

		// While scanner has next line the line is split into tokens and invokes a movie
		// constrauctor depending on the number of tokens.
		while (scanner.hasNextLine()) {
			String tempString = scanner.nextLine();

			String[] tempStringArray = tempString.split(" ");

			int index = tempStringArray.length;

			if (index == 3) {

				title = this.getElement(tempStringArray, 0);
				actor = this.getElement(tempStringArray, 1);
				year = Integer.parseInt(this.getElement(tempStringArray, 2));

				Movie partialMovieObject = new Movie(title, actor, year);

				movieList.getMovieList().add(partialMovieObject);

			} else if (index == 6) {

				title = this.getElement(tempStringArray, 0);
				actor = this.getElement(tempStringArray, 1);
				year = Integer.parseInt(this.getElement(tempStringArray, 2));
				length = Integer.parseInt(this.getElement(tempStringArray, 3));
				imdbScore = this.getElement(tempStringArray, 4);
				director = this.getElement(tempStringArray, 5);

				Movie fullMovieObject = new Movie(title, actor, year, length, imdbScore, director);

				movieList.getMovieList().add(fullMovieObject);

			}

		}

		return movieList;

	}

	// A method to get the the elements from the String[]
	public String getElement(String[] arrayOfStrings, int index) {
		return arrayOfStrings[index];
	}

	// Writing the a list of movies to a file using a printWriter
	public void writeToFile(PrintWriter printWriter, List<Movie> movies) throws FileNotFoundException {

		for (Movie m : movies)
			printWriter.println(m);

		printWriter.close();

		System.out.println("Movielist has been saved to file\n");

	}

}
