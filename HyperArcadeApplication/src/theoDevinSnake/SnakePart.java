package theoDevinSnake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;
import markGalaga.MarkPlayerMovement;
import willTetris.Collidable;

public class SnakePart extends MarkPlayerMovement implements Collidable{
	private int direction;
	private boolean head;
	private TheoSnakeGUI beep;
	private Action detectColision;

	public SnakePart(int x, int y, int w, int h, boolean head,TheoSnakeGUI snake) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.beep=snake;
		Thread t = new Thread(this);
		this.addSequence("resources/snakeBody.png",1000,0, 0,50,50, 1);
		this.head=head;
		t.start();
		update();
	}

	public void moveUp() {
		direction=1;
		setVx(0);
		setVy(-5);
	}
	public void moveDown() {
		direction=3;
		setVx(0);
		setVy(5);
	}
	public void moveLeft() {
		direction=4;
		setVy(0);
		setVx(-5);
	}
	public void moveRight() {
		direction =2;
		setVy(0);
		setVx(5);
	}
	@Override
	public void checkBehaviors() {
		if(direction==1) {
			moveUp();
		}
		if(direction==2) {
			moveRight();
		}
		if(direction==3) {
			moveDown();
		}
		if(direction==4) {
			moveLeft();
		}
		this.act();
	}
	private void act() {
		detectColision.act();
		
	}

	public boolean checkColision(SnakePart p) {
		return p.getX() < getX() + getWidth() && p.getX() + p.getWidth() > getX() &&
				p.getY() < getY() + getHeight() && p.getHeight() + p.getY() > getY();
	}
	public boolean checkColision(SnakePoint p) {
	 return p.getX() < getX() + getWidth() && p.getX() + p.getWidth() > getX() &&
				p.getY() < getY() + getHeight() && p.getHeight() + p.getY() > getY();
	}
}
