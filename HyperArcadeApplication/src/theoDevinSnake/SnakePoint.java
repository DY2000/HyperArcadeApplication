package theoDevinSnake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;

public class SnakePoint extends AnimatedComponent {
	private int x; 
	private int y;
	private int w;
	private int h;
	private TheoSnakeGUI beep;
	

	public SnakePoint(int x, int y, int w, int h,TheoSnakeGUI t) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.beep=t;
		this.addSequence("resources/snakePoint.png",1000,0,0,50,50,1);
		update();
	}
	public boolean checkColision(SnakePart p) {
		return p.getX() < getX() + getWidth() && p.getX() + p.getWidth() > getX() &&
				p.getY() < getY() + getHeight() && p.getHeight() + p.getY() > getY();
	}


}
