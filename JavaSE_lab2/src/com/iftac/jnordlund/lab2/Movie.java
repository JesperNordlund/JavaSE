package com.iftac.jnordlund.lab2;


public class Movie  {
	
	private String title;
	private String actor;
	private int year;
	private int length = 0;
	private String imdbScore;
	private String director;
	
	public Movie() {

	}
	
	public Movie(String title, String actor, int year) {
		
		this.title = title;
		this.actor = actor;
		this.year = year;

		
	}
	
	public Movie(String title, String actor, int year, int length, String imdbScore, String director) {
		
		this.title = title;
		this.actor = actor;
		this.year = year;
		this.length = length;
		this.imdbScore = imdbScore;
		this.director = director;
		
	}
	

	
@Override
	public String toString() {
		return  title + " " + actor + " " + year + " " + length + " "
				+ imdbScore + " " + director + "]\n";
	}

public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getImdbScore() {
		return imdbScore;
	}

	public void setImdbScore(String imdbScore) {
		this.imdbScore = imdbScore;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}




}
	


