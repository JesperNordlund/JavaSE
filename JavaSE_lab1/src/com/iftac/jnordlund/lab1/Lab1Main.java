package com.iftac.jnordlund.lab1;

// Jesper Nordlund
// 2017-10-03
// Java SE Lab 1

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab1Main {

	public static void main(String[] args) throws IOException {

		boolean letsPlay = true;
		boolean correctGuess = false;
		boolean playAgain = true;
		boolean validAnswer = false;

		int lastGuess = 0;
		int minValue = 0;
		int maxValue = 0;
		int answer = 0;
		int numberOfGuesses = 1;

		// Instantiating a scanner for keyboard input
		Scanner scan = new Scanner(System.in);

		// Instantiating a guessing generator for number guessing
		GuessGenerator guessGenerator = new GuessGenerator();

		System.out.println("Hi! What's your name?");

		String name = scan.nextLine();

		// Saving interval numbers in two arraylists. One for the changing interval and
		// one for the starting interval that the player chooses
		ArrayList<Integer> changingInterval = new ArrayList<Integer>();
		ArrayList<Integer> startingInterval = new ArrayList<Integer>();

		// Program runs while letsPlay is true
		while (letsPlay && playAgain) {

			System.out.println("Ok, " + name + "! Think of an integer in an interval of your choosing:");

			System.out.println("Type in the low number of the interval:");

			// hasNextInt will return false until it there is an int to be read and will
			// handle any exception.
			// When it returns true the int will be scanned and stored.
			while (!scan.hasNextInt())
				scan.next();
			minValue = scan.nextInt();

			System.out.println("Type in the high number of the interval:");

			while (!scan.hasNextInt())
				scan.next();
			maxValue = scan.nextInt();

			// Storing interval in two arraylists
			// Starting interval will remain the same until the player chooses to play
			// again.
			startingInterval.add(minValue);
			startingInterval.add(maxValue);

			// Changing interval will change as the player chooses if the guessed number is
			// higher or lower.
			changingInterval.add(minValue);
			changingInterval.add(maxValue);

			System.out.println("So you are thinking of a number between " + startingInterval.get(0) + " and "
					+ startingInterval.get(1));

			// Keeps guessing until correctGuess is true
			while (!correctGuess) {

				// Generating a guess
				int guess = guessGenerator.guess(changingInterval, lastGuess);

				System.out.println("Is the number you're thinking of " + guess + "?\n" + "1. Yes!\n"
						+ "2. No! It's higher.\n" + "3. No! It's lower.");

				lastGuess = guess;

				while (!scan.hasNextInt())
					scan.next();
				answer = scan.nextInt();

				if (answer == 1) {
					System.out.println("I guessed it on " + numberOfGuesses + " tries.");
					System.out.println("May I guess on a new number, " + name + "?\n" + "1. Yes\n" + "2. No");
					validAnswer = false;
					correctGuess = true;

					// Sets the guessed number as the new minValue in the changingInterval.
				} else if (answer == 2) {
					changingInterval.set(0, guess);
					numberOfGuesses++;

					// Sets the guessed number as the new maxValue in the changingInterval.
				} else if (answer == 3) {
					changingInterval.set(1, guess);
					numberOfGuesses++;

				} else {
					System.out.println("Only 1, 2, 3 are accepted answers");

				}

			}

			while (!validAnswer) {
				while (!scan.hasNextInt())
					scan.next();
				answer = scan.nextInt();

					// Resetting the intervals to play again
				if (answer == 1) {
					changingInterval.clear();
					startingInterval.clear();

					playAgain = true;
					validAnswer = true;
					correctGuess = false;

					// Terminates the game by getting out of this loop and the main loop
				} else if (answer == 2) {
					scan.close();
					System.out.println("Game terminated");
					letsPlay = false;
					playAgain = false;
					validAnswer = true;

				} else {
					System.out.println("Accepted answers are 1 or 2");

				}
			}

		}

	}
}
