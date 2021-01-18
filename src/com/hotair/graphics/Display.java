package com.hotair.graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.hotair.reference.Reference;

public class Display extends Canvas{
	
	public static final long serialVersionUID = 1L;
	
	protected JFrame window;
	
	protected BufferedImage image;
	protected int[] pixels;
	
	public Display() {
		setMinimumSize(new Dimension(1280, 720));
		setPreferredSize(new Dimension(1280, 720));
		setFocusable(true);
		
		image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		
		window = new JFrame(Reference.TITLE);
		window.setLayout(new BorderLayout());
		window.add(this);
		window.pack();
		window.setDefaultCloseOperation(3);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}

	
	
}