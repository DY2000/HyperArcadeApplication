package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;

public class MarkShip extends AnimatedComponent implements MarkPlayerMovement {
	
	private BufferedImage img;
	
	public MarkShip(int x, int y, int w, int h) {
		super(x, y, w, h);
		img = new Graphic(0,0,128,128,"resources/Galaga_ship.png").getImage();
		update();
		Thread t = new Thread(this);
		t.start();
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
		MarkProjectile shot = new MarkProjectile(getX()+getWidth()/2,getY(),40,40);
	}
	
}
