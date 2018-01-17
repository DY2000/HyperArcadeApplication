package markGalaga;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import hyperArcade.ArcadeGUI;
import willTetris.Collidable;

public class MarkShip extends MarkPlayerMovement implements Collidable{
	
	private BufferedImage img;
	
	public MarkShip(int x, int y, int w, int h) {
		super(x, y, w, h);
		img = new Graphic(0,0,128,128,"resources/Galaga_ship.png").getImage();
		update();
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				fireShot();
				System.out.println("Pew");
				break;
			case KeyEvent.VK_LEFT :
				moveLeft();
				System.out.println("Left");
				break;
			case KeyEvent.VK_RIGHT : 
				moveRight();
				System.out.println("Right");
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				moveStop();
				System.out.print("stop");
			case KeyEvent.VK_RIGHT : 
				moveStop();
				System.out.print("stop");
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void run() {
		super.run();
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
		 setVx(15);
	}
	
	public void moveLeft() {
		setVx(-15);
	}

	public void fireShot() {
		
	}
	
}
