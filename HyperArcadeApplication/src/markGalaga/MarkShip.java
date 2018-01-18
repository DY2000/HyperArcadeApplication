package markGalaga;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import HyperArcade.ArcadeGUI;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkShip extends MarkPlayerMovement implements Collidable{
	
	private BufferedImage img;
	private ArrayList<MarkProjectile> shots;
	
	public MarkShip(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		shots = new ArrayList<MarkProjectile>(32);
		for(int i = 0; i < 64; i++) {
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
				if(shots.size() < 64) {
					for(int i = shots.size(); i < 64; i++) {
						shots.add(i, new MarkProjectile(1025,0,9,48,"player"));
					}
				}
				fireShot(shots,getX()+(getWidth()/2)-(shots.get(63).getWidth()/2),getY());
				break;
			case KeyEvent.VK_LEFT :
				if(getX() > 0)
					moveLeft();
				else moveStop();
				break;
			case KeyEvent.VK_RIGHT : 
				if(getX() < 1024-getWidth())
					moveRight();
				else moveStop();
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				moveStop();
			case KeyEvent.VK_RIGHT : 
				moveStop();
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
				arl.get(i).setVy(-10);
				break;
			}
		}	
	}
	
	public ArrayList<MarkProjectile> getShots() {
		return shots;
	}
	
}
