package markGalaga;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import hyperArcade.ArcadeGUI;
import willTetris.Collidable;

public class MarkShip extends MarkPlayerMovement implements Collidable{
	
	private BufferedImage img;
	private ArrayList<MarkProjectile> shots;
	
	public MarkShip(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		shots = new ArrayList<MarkProjectile>();
		for(int i = 0; i < 3; i++) {
			shots.add(i, new MarkProjectile(1025,0,9,48,"player"));
		}
		img = new Graphic(0,0,.5,"resources/Galaga_ship.png").getImage();
		update();
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				if(shots.size() < 3) {
					for(int i = shots.size(); i < 2; i++) {
						shots.add(i, new MarkProjectile(1025,0,9,48,"player"));
					}
				}
				fireShot(shots,getX()+(getWidth()/2)-(shots.get(0).getWidth()/2),getY());
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

	public void drawImage(Graphics2D g) {
		if(img != null) {
			g.drawImage(img,0,0,null);
		}
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
		if(getVx() > 0 && getX() > 1024-(getWidth()*1.3)) {
			moveStop();
		}
		if(getVx() < 0 && getX() < 8) {
			moveStop();
		}
	}
	
	public ArrayList<MarkProjectile> getShots() {
		return shots;
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
