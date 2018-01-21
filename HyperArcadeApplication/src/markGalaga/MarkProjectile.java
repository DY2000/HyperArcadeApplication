package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkProjectile extends AnimatedComponent implements Collidable{
	
	String shooter;
	
	public MarkProjectile(int x, int y, int w, int h, String shooter) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		setShooter(shooter);
		update();
		Thread t = new Thread(this);
		t.start();
	}

	

	public void checkBehaviors() {
		if(this.getY() < 0) {
			setVy(0);
			setY(300);
			setX(1025);
		}
	}

	public boolean detectsCollision() {
		return false;
	}

	public String getShooter() {
		return shooter;
	}
	
	private void setShooter(String shooter) {
		this.shooter = shooter;
	}
}
