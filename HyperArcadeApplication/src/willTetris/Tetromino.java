package willTetris;

import java.awt.Color;
import java.util.ArrayList;

public class Tetromino {
	
	private int rotation;
	private boolean rotated;
	private ArrayList<Block> parts;
	private Color color;
	
	public Tetromino(int xOne, int yOne, int xTwo, int yTwo, int xThree, int yThree, int xFour, int yFour, Color color) {
		
		parts = new ArrayList<Block>();
		parts.add(0, new Block (xOne, yOne, color));
		parts.add(1, new Block (xTwo, yTwo, color));
		parts.add(2, new Block (xThree, yThree, color));
		parts.add(3, new Block (xFour, yFour, color));
		this.color = color;
		
		rotation = 0;
		rotated = false;
	}
	
	
	public void rotate() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	public Block getPart(int i) {
		return parts.get(i);
	}
	
	public Color getColor() {
		return color;
	}
}
