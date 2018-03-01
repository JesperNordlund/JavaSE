package com.fifteenpuzzle.iftac.jesper.fifteenpuzzle;

import android.widget.Button;

/**
 * Created by Jesper on 2018-02-13.
 */

public class Tile {

    private int value;
    private boolean isEmpty;
    private Button button;


    public Tile(int value, boolean isEmpty) {

        this.value = value;
        this.isEmpty = isEmpty;

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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}

