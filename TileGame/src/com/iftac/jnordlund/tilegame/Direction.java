package com.iftac.jnordlund.tilegame;

public enum Direction {
	
	UP,
	DOWN,
	LEFT,
	RIGHT;


	public static Direction getRandomDirection() {
        return values()[(int) (Math.random() * values().length)];
    }

}
