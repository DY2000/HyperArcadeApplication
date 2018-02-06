package markGalaga;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkShip extends MarkPlayerMovement implements Collidable{
	
	private MarkGalaga game;
	private boolean enabled;
	
	public MarkShip(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.enabled = false;
		this.game = game;
		this.addSequence("resources/Galaga_spriteSheet.png", 1000, 184, 55, 15, 16, 1);
		update();
		Thread t = new Thread(this);
		t.start();
	}
	
	public void fireShot(ArrayList<MarkProjectile> arl, int x, int y) {
		for(int i = 0; i<arl.size();i++) {
			if(arl.get(i).getVy() == 0) {
				arl.get(i).setX(x);
				arl.get(i).setY(y);
				arl.get(i).setVy(-14);			
				break;
			}
		}	
	}
	
	public void checkBehaviors() {
		if(getVx() > 0 && getX() > 712) {
			moveStop();
		}
		if(getVx() < 0 && getX() < 330) {
			moveStop();
		}
	}
	
	public boolean detectCollision(MarkProjectile shot) {
		return (shot.getX() < getX() + getWidth() && shot.getX() + shot.getWidth() > getX() &&
			shot.getY() < getY() + getHeight() && shot.getHeight() + shot.getY() > getY());
	}
	
	public boolean detectCollision(MarkMob mob) {
		return (mob.getX() < getX() + getWidth() && mob.getX() + mob.getWidth() > getX() &&
			mob.getY() < getY() + getHeight() && mob.getHeight() + mob.getY() > getY());
		
	}
		
	public void shipHit() {
		int newX = getX()-16;
		int newY = getY()-16;
		Thread b = new Thread(new Runnable() {
			public void run() {
				DeathAnimation boom = new DeathAnimation(newX,newY,64,64,"player",game);
				game.addObject(boom);
				try {
					Thread.sleep(375);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				game.remove(boom);
			}
		});
		setVisible(false);
		b.start();
		enabled = false;
	}
	
	public void moveStop() {
		setVx(0);
	}
	
	public void moveRight() {
		setVx(5);
	}
	
	public void moveLeft() {
		setVx(-5);
	}

	public void moveUp() {
		
	}

	public void moveDown() {
	
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean b) {
		this.enabled = b;
	}
	
}
