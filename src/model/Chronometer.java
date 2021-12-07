package model;

import ui.Game;

public class Chronometer extends Thread {

	private Game game;
	private boolean process = true;

	public Chronometer(Game game) {
		this.game = game;
	}

	public void run() {

		for (int i = 60; i >= 0; i--) {

			game.setTimeLabel(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		
		process = false;
		game.tell(process);
	}
	
	public boolean getProcess() {
		return process;
	}

}
