package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class MarkGameManager extends AnimatedComponent{

	private MarkGalaga game;
	private int attacking;
	
	public MarkGameManager(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		this.game = game;
		Thread t = new Thread(this);
		t.start();
	}

	public void checkBehaviors() {
		if(game.getRunning()) {
			if(game.getMobs().size() == 0 && !game.isSpawning() && game.getShip().isEnabled()) {
				game.nextRound();
			}
			if(!game.getShip().isVisible() && game.getLives() >= 0 && !game.isSpawning()) {
				game.shipRespawn();
			}
		}
	}
}
