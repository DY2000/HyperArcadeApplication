package willTetris;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;
import guiTeacher.components.MovingComponent;

public class Block extends MovingComponent {

	private int x;
	private int y;
	Color color;
	private BufferedImage appearance;

	public Block(int x, int y, Color color) {
		super(x, y, 5, 5);
		this.x = x;
		this.y = y;
		this.color = color;
		appearance = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);
	}

	public void checkBehaviors() {

	}

	@Override
	public void update(Graphics2D g) {

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int x) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public void drawImage(Graphics2D g) {

	}

}
