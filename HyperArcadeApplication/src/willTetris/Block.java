package willTetris;

import java.awt.Color;

public class Block {

	int xPosition;
	int yPosition;
	Color color;
	
	public Block(int xPos, int yPos, Color color2) {
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.color = color2;
	}
	
	
	public int xPos() {
		return xPosition;
	}
	public int yPos() {
		return yPosition;
	}
	public Color blockColor() {
		return color;
	}
}
