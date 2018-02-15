package AliceDanPacman;

import guiTeacher.components.AnimatedComponent;

public class PacmanManager extends AnimatedComponent{

	PacmanScreen game;
	
	public PacmanManager(int x, int y, int w, int h, PacmanScreen game) {
		super(x, y, w, h);
		this.game = game;
		Thread t = new Thread(this);
		t.start();
	}

	public void checkBehaviors() {
			if(game.getGrid().getDotCount() <= 3 && game.isRunning()) {
				game.nextRound();
			}
			if(game.getGrid().getDotCount() < 200 && game.isRunning() && !game.getPinky().isSpawned()) {
				game.getPinky().spawn();
			}
			if(game.getGrid().getDotCount() < 150 && game.isRunning() && !game.getInky().isSpawned()) {
				game.getInky().spawn();
			}
			if(game.getGrid().getDotCount() < 100 && game.isRunning() && !game.getClyde().isSpawned()) {
				game.getClyde().spawn();
			}
	}
}
