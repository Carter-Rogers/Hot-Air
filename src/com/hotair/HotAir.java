package com.hotair;

import com.hotair.graphics.Display;

public class HotAir implements Runnable{

	private boolean running;
	private Thread thread;
	
	private Display display;
	
	private void init() {
		display = new Display();
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		
		init();
		
		thread = new Thread(this, "Hot Air");
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public void render() {
		display.render();
	}
	
	public void update() {
		
	}
	
	public void run() {
		while(running) {
			update();
			render();
		}
	}
	
	
}