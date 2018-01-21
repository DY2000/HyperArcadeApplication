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

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				fireShot(playerShots,getX()+(getWidth()/2)-(playerShots.get(0).getWidth()/2),getY());
				break;
			case KeyEvent.VK_LEFT :
					moveLeft();
				break;
			case KeyEvent.VK_RIGHT : 
					moveRight();
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				if(getVx() < 0)
					moveStop();
				else break;
			case KeyEvent.VK_RIGHT : 
				if(getVx() > 0)
					moveStop();
				else break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
				arl.get(i).setVy(-25);			
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

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
