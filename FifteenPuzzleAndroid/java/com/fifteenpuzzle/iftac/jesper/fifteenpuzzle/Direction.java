package com.fifteenpuzzle.iftac.jesper.fifteenpuzzle;

/**
 * Created by Jesper on 2018-02-26.
 */

public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;


    public static Direction getRandomDirection() {
        return values()[(int) (Math.random() * values().length)];
    }

}
