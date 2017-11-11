package com.iftac.jnordlund.tilegame;

import java.awt.EventQueue;
import java.util.Scanner;

import com.iftac.jnordlund.tilegame.gfx.GUI;

public class Game {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });

		Scanner scan = new Scanner(System.in);

		Board board = new Board();

		while (!board.isSolved()) {
			board.printBoard();

			Direction dir = null;
			
			
			
//			int row = scan.nextInt();
//			int col = scan.nextInt();

			String move = scan.nextLine();

			if (move.toUpperCase().equals("W")) {
				dir = Direction.UP;
			} else if (move.toUpperCase().equals("S")) {
				dir = Direction.DOWN;
			} else if (move.toUpperCase().equals("A")) {
				dir = Direction.LEFT;
			} else if (move.toUpperCase().equals("D")) {
				dir = Direction.RIGHT;
			} else if (move.toUpperCase().equals("R")) {
				board.shuffled = false;
				board.shuffle();

			}
			
			//moveEmptyTile uses directions A,S,W,D to move the empty tile
			board.moveEmptyTile(dir);
			
			//moveTile use coordinates to move tile
//			board.moveTile(row, col);

		}

		scan.close();

	}

}
