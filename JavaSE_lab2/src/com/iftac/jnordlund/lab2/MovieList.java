package com.iftac.jnordlund.lab2;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

	private List<Movie> movieList;

	public MovieList() {
		this.setMovieList(new ArrayList<Movie>());

	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	
}



