package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import willTetris.Collidable;

public class MarkProjectile extends AnimatedComponent implements Collidable{

	private BufferedImage img;
	
	public MarkProjectile(int x, int y, int w, int h, String shooter) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		img = new Graphic(0,0,9,48,"resources/Galaga_"+shooter+"_shot.png").getImage();
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

	public void drawImage(Graphics2D g) {
		if(img != null) {
			g.drawImage(img,0,0,null);
		}
	}
	
}
