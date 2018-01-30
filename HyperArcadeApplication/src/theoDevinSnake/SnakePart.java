package theoDevinSnake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;
import markGalaga.MarkPlayerMovement;
import willTetris.Collidable;

public class SnakePart extends MarkPlayerMovement implements Collidable{
	private int direction;
	private BufferedImage img;

	public SnakePart(int x, int y, int w, int h) {
		super(x, y, w, h);
		img=new Graphic(0,0,50,50,"resources/snakeBody.png").getImage();
		update();
		Thread t = new Thread(this);
		t.start();
	}


	public void update(Graphics2D g) {
//		if(point!=null) {
			g.drawImage(img,0,0,null);
//		}
	}
	

	@Override
	public void drawImage(Graphics2D g) {
		//if(img!=null) {
			g.drawImage(img,0,0,null);
		//}
		
	}
	public void moveUp() {
		direction=1;
		setVx(0);
		setVy(15);
	}
	public void moveDown() {
		direction=3;
		setVx(0);
		setVy(-15);
	}
	public void moveLeft() {
		direction=4;
		setVy(0);
		setVx(-15);
	}
	public void moveRight() {
		direction =2;
		setVy(0);
		setVx(15);
	}
	public void move(int dir) {
		if(dir==1) {
			moveUp();
		}
		if(dir==2) {
			moveRight();
		}
		if(dir==3) {
			moveDown();
		}
		if(dir==4) {
			moveLeft();
		}
	}



	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public void keyReleased(KeyEvent e) {
		
		
	}



	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}



	public void setFocus(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void checkBehaviors() {
		// TODO Auto-generated method stub
		
	}
}
