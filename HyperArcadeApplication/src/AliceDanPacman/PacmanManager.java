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
		if(game.isRunning()) {
			if(game.getGrid().getDotCount() == 0 && game.isRunning()) {
				game.nextRound();
			}
			if(!game.getShip().isVisible() && game.getLives() >= 0 && !game.isSpawning()) {
				game.shipRespawn();
			}
		}
	}
}
