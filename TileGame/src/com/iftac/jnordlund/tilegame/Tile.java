package com.iftac.jnordlund.tilegame;
	

public class Tile {

	private int value;
	private boolean isEmpty;
	private int height;
	private int width;

	public Tile(int value, boolean isEmpty, int width, int height) {

		this.value = value;
		this.isEmpty = isEmpty;
		this.width = width;
		this.height = height;

	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Tile [value=" + value + ", isEmpty=" + isEmpty + "]\n";
	}

	public void setValue(int value) {

		if (this.value >= 0 && this.value <= 15) {

			this.value = value;

		} else {

			throw new IllegalArgumentException("Number out of range");
		}

	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	


}
