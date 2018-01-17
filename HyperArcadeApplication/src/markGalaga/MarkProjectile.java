package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkProjectile extends AnimatedComponent implements Collidable{

	private BufferedImage img;
	
	public MarkProjectile(int x, int y, int w, int h) {
		super(x, y, w, h);
		img = new Graphic(155,21,9,48,"resources/Galaga_projectiles.png").getImage();
		addSequence("resources/Galaga_projectiles.png",5,155,21,9,48,3);
		setVy(-1);
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public void checkBehaviors() {
		if(this.getY() < 0) {
			setVy(0);
			setY(400);
			setX(1000);
		}
	}

	public void drawImage(Graphics2D g) {
		if(img != null) {
			g.drawImage(img,0,0,null);
		}
	}
	
}
