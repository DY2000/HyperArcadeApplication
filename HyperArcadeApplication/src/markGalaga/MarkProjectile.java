package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkProjectile extends AnimatedComponent implements Collidable{
	
	private MarkGalaga game;
	private Action detectCollision;
	
	public MarkProjectile(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
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
		this.act();
	}
	private void act() {
		if(this.detectCollision != null)
			detectCollision.act();
	}

	public  void setDetection(Action a) {
		this.detectCollision = a;
	}
}
