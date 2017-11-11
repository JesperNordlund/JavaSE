package com.iftac.jnordlund.tilegame.gfx;

import javax.swing.JFrame;

public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 800;
	private int height = 800;

	public GUI() {
		
		initGUI();
	}
	
	private void initGUI() {
		
		add(new Surface());
		
		setTitle("15-Puzzle");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
