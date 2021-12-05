package model;

import ui.Game;

public class Chronometer extends Thread {

	private Game game;

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
		//mw.tell("Juego acabado");
	}

}
