package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class GameManager extends AnimatedComponent{

	private MarkGalaga game;
	private int rdmErrs;
	
	public GameManager(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		this.game = game;
		Thread t = new Thread(this);
		t.start();
	}

	public void checkBehaviors() {
		if(game.getRunning()) {
			if(game.getMobs().size() == 0 && !game.isSpawning() && game.getShip().isEnabled()) {
				game.nextRound();
			}else if(!game.isSpawning() && game.getShip().isEnabled()) {
				int attacking = 0;
				for(int i = 0; i < game.getMobs().size(); i++) {
					if(Math.random() > .05 && attacking < 3) {
						attacking++;
						game.getMobs().get(i).flyingAttack();
					}
				}
			}
			if(!game.getShip().isVisible() && game.getLives() >= 0 && !game.isSpawning()) {
				game.shipRespawn();
			}
		}
	}
}
