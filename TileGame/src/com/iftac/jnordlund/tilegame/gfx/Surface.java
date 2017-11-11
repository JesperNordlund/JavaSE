package com.iftac.jnordlund.tilegame.gfx;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Surface extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void draw(Graphics g) {
		
		Graphics g2d = (Graphics2D) g;
		
		//g2d.drawLine(arg0, arg1, arg2, arg3);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		draw(g);
		
		
		
	}

}
