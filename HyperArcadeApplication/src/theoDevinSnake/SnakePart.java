package theoDevinSnake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;
import markGalaga.MarkPlayerMovement;

public class SnakePart extends MovingComponent implements MarkPlayerMovement{
	private int direction;
	private BufferedImage img;

	public SnakePart(int x, int y, int w, int h) {
		super(x, y, w, h);
		img=new Graphic(0,0,50,50,"resources/snakeBody.png").getImage();
		update();
		Thread t = new Thread(this);
		t.start();
	}


	@Override
	public void drawImage(Graphics2D g) {
		if(img!=null) {
			g.drawImage(img,0,0,null);
		}
		
	}
	public void moveUp() {
		direction=1;
		setVy(15);
	}
	public void moveDown() {
		direction=3;
		setVy(-15);
	}
	public void moveLeft() {
		direction=4;
		setVx(-15);
	}
	public void moveRight() {
		direction =2;
		setVx(15);
	}
}
