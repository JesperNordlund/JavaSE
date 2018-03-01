package com.fifteenpuzzle.iftac.jesper.fifteenpuzzle;

/**
 * Created by Jesper on 2018-02-26.
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    private int row;
    private int col;
    private boolean isSolved = false;
    private List<Tile> tiles;
    private int indexOfEmptyTile;
    private int counter = 0;
    boolean shuffled = false;
    private List<Tile> solved;

    private TextView tv;
    private TextView systemOut;

    private static Board instance;


    public Board() {
        setUp();

    }

    public static synchronized Board getInstance(){
        if(instance == null){
            instance = new Board();
        }
        return instance;
    }


    /**
     * This method creates two arrays of tiles, one for reference to compare if the
     * board has been solved. The other array is shuffled. Counter is reset.
     */

    public void setUp() {

        tiles = new ArrayList<Tile>();
        solved = new ArrayList<Tile>();

        int t = 0;

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                if (t == 0) {
                    tiles.add(new Tile(t, true));
                    solved.add(new Tile(t, true));

                } else {
                    tiles.add(new Tile(t, false));
                    solved.add(new Tile(t, false));
                }

                t++;
            }

        }

        tiles.add(tiles.remove(0));
        solved.add(solved.remove(0));

        shuffle();
        setCounter(counter - counter);

    }

    public Tile getTile(int row, int col) {
        int index = row * 4 + col;

        return getTiles().get(index);
    }

    /**
     * Sets tile to given coordinates
     *
     * @param row
     * @param col
     * @param tile
     */

    public void setTile(int row, int col, Tile tile) {

        try {
            Tile emptyTemp = tiles.get(getIndexOfEmptyTile());
            tiles.set(getIndexOfEmptyTile(), tile);
            tiles.set((row * 4 + col), emptyTemp);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't move in that direction. Try another!\n");
            systemOut.setText("Can't move in that direction. Try another!\n");

        }
    }

    public boolean moveTile(int row, int col) {
        if ((row * 4 + col == getIndexOfEmptyTile() - 1 || row * 4 + col == getIndexOfEmptyTile() + 1
                || row * 4 + col == getIndexOfEmptyTile() - 4 || row * 4 + col == getIndexOfEmptyTile() + 4) && row <= 3
                && col <= 3) {

            setTile(row, col, getTile(row, col));

        } else {
            System.out.println("Can't move in that direction. Try another!\n");
            systemOut.setText("Can't move in that direction. Try another!\n");
        }
        setEmptyTile();
        checkIfSolved();

        return isSolved;

    }

    /**
     * The direction to move the emptytile. Swaps places with the tile next to it in
     * the moving direction.
     *
     * @param dir
     * @return isSolved
     */

    public boolean moveEmptyTile(Direction dir) {

        try {
            if (dir == Direction.UP) {
                Collections.swap(getTiles(), getIndexOfEmptyTile(), getIndexOfEmptyTile() - 4);

            } else if (dir == Direction.DOWN) {
                Collections.swap(getTiles(), getIndexOfEmptyTile(), getIndexOfEmptyTile() + 4);

            } else if (dir == Direction.LEFT && !((getIndexOfEmptyTile() == 4) || (getIndexOfEmptyTile() == 8)
                    || (getIndexOfEmptyTile() == 12))) {
                Collections.swap(getTiles(), getIndexOfEmptyTile(), getIndexOfEmptyTile() - 1);

            } else if (dir == Direction.RIGHT && !((getIndexOfEmptyTile() == 3) || (getIndexOfEmptyTile() == 7)
                    || (getIndexOfEmptyTile() == 11))) {
                Collections.swap(getTiles(), getIndexOfEmptyTile(), getIndexOfEmptyTile() + 1);

            }else {
                if (shuffled) {
                    System.out.println("Can't move in that direction. Try another!\n");
                    //systemOut.setText("Can't move in that direction. Try another!\n");
                }
            }

        } catch (IndexOutOfBoundsException e) {

            if (shuffled) {
                System.out.println("Can't move in that direction. Try another!\n");
                //systemOut.setText("Can't move in that direction. Try another!\n");
            }
        }
        checkIfSolved();

        if (tiles.equals(solved)) {
            isSolved = true;
        }

        setEmptyTile();
        setCounter(counter + 1);

        return isSolved;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    /**
     * Moves the empty tile randomly from the solved position. Board will always be
     * solvable.
     */

    public void shuffle() {

        for (int i = 0; i < 100; i++) {

            Direction dir = Direction.getRandomDirection();

            if (dir.equals(Direction.UP)) {
                dir = Direction.UP;

            } else if (dir.equals(Direction.DOWN)) {
                dir = Direction.DOWN;

            } else if (dir.equals(Direction.RIGHT)) {
                dir = Direction.RIGHT;

            } else if (dir.equals(Direction.LEFT)) {
                dir = Direction.LEFT;
            }

            setEmptyTile();
            moveEmptyTile(dir);
        }

        shuffled = true;
        setCounter(0);
        setSolved(false);

    }

    /**
     *
     * @return indexOfEmptyTile
     */

    public int getIndexOfEmptyTile() {
        return indexOfEmptyTile;

    }

    /**
     * Sets the coordinates on the board of the empty tile
     */

    public void setEmptyTile() {

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (tiles.get(index).isEmpty()) {
                    indexOfEmptyTile = index;
                }
                index++;
            }

        }
        col = indexOfEmptyTile % 4;
        row = indexOfEmptyTile / 4;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Prints the board to console. Is called after every move.
     */





    /**
     * Compares current array of tile with the reference to check if it is solved
     */

    public void checkIfSolved() {

        List<Integer> c1 = new ArrayList<Integer>();
        List<Integer> c2 = new ArrayList<Integer>();

        for (Tile tile : solved) {
            c1.add(tile.getValue());
        }

        for (Tile tile : tiles) {
            c2.add(tile.getValue());
        }

        if (Arrays.asList(c1).equals(Arrays.asList(c2))) {
            setSolved(true);
        }

    }


    public boolean isSolved() {

        return isSolved;

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;

    }

    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }

    public TextView getSystemOut() {
        return systemOut;
    }

    public void setSystemOut(TextView systemOut) {
        this.systemOut = systemOut;
    }

}