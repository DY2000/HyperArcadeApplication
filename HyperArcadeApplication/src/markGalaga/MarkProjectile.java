package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;

public class MarkProjectile extends AnimatedComponent {
	
	private MarkGalaga game;
	private String shooter;
	private Action detectCollision;
	
	public MarkProjectile(int x, int y, int w, int h, String shooter, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.shooter = shooter;
		this.game = game;
		this.detectCollision = null;
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public void checkBehaviors() {
		if(getY() < 0) {
			setVy(0);
			setVx(0);
			setY(400);
			setX(1030);
		}
		if(getY() > 764) {
			setVy(0);
			setVx(0);
			setY(300);
			setX(1030);
		}
		if(getVy() != 0 && getX() < 325) {
			setVy(0);
			setVx(0);
			setY(400);
			setX(1030);
		}
		if(getVy() != 0 && getX() > 750) {
			setVy(0);
			setVx(0);
			setY(400);
			setX(1030);
		}
		if(shooter == "player" && getVy() != 0) {
			try {
				for(MarkMob m : game.getMobs()) {
					if(m.detectCollision(this) && m.isEnabled()) {
						int newX = m.getX()-16;
						int newY = m.getY()-16;
						game.setHits(game.getHits() + 1);
						if(m.getHp() == 0) {
							Thread b = new Thread(new Runnable() {
								public void run() {
									MarkDeathAnimation boom = new MarkDeathAnimation(newX,newY,64,64,"mob",game);
									game.addObject(boom);
									try {
										Thread.sleep(250);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									game.remove(boom);
									boom = null;
								}
							});
							game.updateScore(m);
							setVy(0);
							setVx(0);
							setY(300);
							setX(1030);
							b.start();
							break;
						}else {
							setVy(0);
							setVx(0);
							setY(300);
							setX(1030);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				game.remove(this);
				game.getPlayerShots().clear();
				game.getPlayerShots().add(new MarkProjectile(1030,400,6,16,"player",game));
				game.getPlayerShots().add(new MarkProjectile(1030,400,6,16,"player",game));
				game.getPlayerShots().get(0).addSequence("resources/Galaga_spriteSheet.png", 1000, 374, 51, 3, 8, 1);
				game.getPlayerShots().get(1).addSequence("resources/Galaga_spriteSheet.png", 1000, 374, 51, 3, 8, 1);
				setRunning(false);
			}
		}else {
			if(game.getShip().isEnabled() && game.getShip().detectCollision(this)) {
				setVy(0);
				setVx(0);
				setY(400);
				setX(1030);
				game.getShip().shipHit();
			}
		}
	}
}
