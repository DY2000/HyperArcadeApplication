package willTetris;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;

public class Block extends Component {

	private int xPosition;
	private int yPosition;
	Color color;
	private BufferedImage appearance;

	public Block(int xPos, int yPos, Color color) {
		super(xPos, yPos, 5, 5);
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.color = color;
		appearance = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	public void update(Graphics2D g) {

	}

	public int getX() {
		return xPosition;
	}

	public void setX(int x) {
		this.xPosition = x;
	}

	public int getY() {
		return yPosition;
	}

	public void setY(int x) {
		this.yPosition = x;
	}

	public Color getColor() {
		return color;
	}

}
