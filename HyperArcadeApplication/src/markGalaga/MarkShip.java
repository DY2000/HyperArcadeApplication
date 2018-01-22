package markGalaga;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkShip extends MarkPlayerMovement implements Collidable{
	
	ArrayList<MarkProjectile> playerShots;
	
	public MarkShip(int x, int y, int w, int h, ArrayList<MarkProjectile> shots) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		setShots(shots);
		update();
		Thread t = new Thread(this);
		t.start();
	}
	
	private void setShots(ArrayList<MarkProjectile> shots) {
		this.playerShots = shots;
	}

	

	public void moveStop() {
		setVx(0);
	}
	
	public void moveRight() {
		setVx(10);
	}
	
	public void moveLeft() {
		setVx(-10);
	}

	public void fireShot(ArrayList<MarkProjectile> arl, int x, int y) {
		for(int i = 0; i<arl.size();i++) {
			if(arl.get(i).getVy() == 0) {
				arl.get(i).setX(x);
				arl.get(i).setY(y);
				arl.get(i).setVy(-20);			
				break;
			}
		}	
	}
	
	public void checkBehaviors() {
		if(getVx() > 0 && getX() > 1024-(72)) {
			moveStop();
		}
		if(getVx() < 0 && getX() < 8) {
			moveStop();
		}
		if(detectCollision()) {
			
		}
	}
	
	private boolean detectCollision() {
		return false;
	}

	public ArrayList<MarkProjectile> getShots() {
		return playerShots;
	}
		
}
