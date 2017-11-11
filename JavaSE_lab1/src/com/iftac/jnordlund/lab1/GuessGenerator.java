package com.iftac.jnordlund.lab1;

import java.util.ArrayList;

public class GuessGenerator {

	public GuessGenerator() {

	}

	// Guessing the median number of the chosen interval
	public int guess(ArrayList<Integer> interval, int lastGuess) {

		int guess = (interval.get(0) + interval.get(1)) / 2;
		
		if(lastGuess == interval.get(1) -1) {
			guess ++;
		}

		return guess;

	}

}
