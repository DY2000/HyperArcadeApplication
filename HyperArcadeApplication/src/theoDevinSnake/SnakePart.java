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
		this.addSequence("resources/SnakeBody.png",1000,0, 0,50,50, 1);
		this.head=head;
		t.start();
		update();
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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
	public void turn(int x,int y,int dir) {
		while(x== this.getX() && this.getY()==y) {
			direction=dir;
			break;
			}
		if(direction==dir) {
			if(beep.getSnakeBody().indexOf(this)!= beep.getSnakeBody().size()-1) {
				beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)+1).turn(this.getX(),this.getY(),dir);
			}
		}
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
		if(beep.getSnakeBody().get(0).checkColision(this)) {
			beep.gameOver();
		}
		if(beep.getSnakeBody().get(0).checkColision(beep.getPoint())) {
			beep.pointGet();
		}
		//if(!head) {
		//if((beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()>=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() ) || (beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()<=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() )){
		//	beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).setDirection(beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getDirection());
		//}
		//if( (beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()>=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX()) ||(beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()<=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX())){
		//	beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).setDirection(beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getDirection());
		//}
	//}
}
	//private void act() {
	//	detectColision.act();
	//	
	//}

	public boolean checkColision(SnakePart p) {
		return p.getX() < getX() + getWidth() && p.getX() + p.getWidth() > getX() &&
				p.getY() < getY() + getHeight() && p.getHeight() + p.getY() > getY();
	}
	public boolean checkColision(SnakePoint p) {
	 return p.getX() < getX() + getWidth() && p.getX() + p.getWidth() > getX() &&
				p.getY() < getY() + getHeight() && p.getHeight() + p.getY() > getY();
	}
	//public void setAction(Action a) {
		//this.detectColision= a;
	//}
}
