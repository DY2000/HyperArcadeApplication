package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkProjectile extends AnimatedComponent implements Collidable{
	
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
		if(this.getY() < 0) {
			setVy(0);
			setVx(0);
			setY(400);
			setX(1030);
		}
		if(this.getY() > 764) {
			setVy(0);
			setVx(0);
			setY(300);
			setX(1030);
		}
//		this.act();
		if(shooter == "player" && getVy() != 0) {
			for(MarkMob m : game.getMobs()) {
				if(m.detectCollision(this)) {
					int newX = m.getX();
					int newY = m.getY();
					game.setHits(game.getHits() + 1);
					if(m.getHp() == 0) {
						Thread b = new Thread(new Runnable() {
							public void run() {
								DeathAnimation boom = new DeathAnimation(newX,newY,64,64,"mob",game);
								game.addObject(boom);
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								game.remove(boom);
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
		}else {
			if(game.getShip() != null && game.getShip().detectCollision(this)) {
				setVy(0);
				setVx(0);
				setY(400);
				setX(1030);
				game.getShip().shipHit();
			}
		}
	}
}
