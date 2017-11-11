package com.iftac.jnordlund.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Jesper Nordlund
// 2017-10-16
// Java SE Lab 2

public class Lab2Main {

	public static void main(String[] args) throws FileNotFoundException {

		// Instantiating a new Scanner for scanning movies.txt
		// and a fileReader
		Scanner scanner = new Scanner(new File("movies.txt"));
		FileReader fileReader = new FileReader();

		// Instantiating a list of movie objects
		List<Movie> movies = fileReader.readToList(scanner).getMovieList();
		System.out.println("Unsorted list of movie objects:\n\n" + movies);
		scanner.close();

		// Sorting the movies by title and printing out
		Collections.sort(movies, MovieSorter.byTitle);
		System.out.println("Sorted by title:\n\n" + movies);

		// Sorting the movies by actor and printing out
		Collections.sort(movies, MovieSorter.byActor.thenComparing(MovieSorter.byTitle));
		System.out.println("Sorted by lead actor:\n\n" + movies.toString());

		// Instantiating a new PrintWriter for writing a new .txt
		PrintWriter printWriter = new PrintWriter(new File("sorted_movies.txt"));

		// Passing the printwriter and the list of movies for to write to file
		fileReader.writeToFile(printWriter, movies);

		// Scanning the new file and printing it out
		Scanner scanner2 = new Scanner(new File("sorted_movies.txt"));
		System.out.println("Reading sorted_movies.txt:\n");

		while (scanner2.hasNextLine()) {
			System.out.println(scanner2.nextLine());
		}
		scanner2.close();
	}

}
