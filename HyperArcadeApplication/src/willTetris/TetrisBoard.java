package willTetris;

import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;

public class TetrisBoard extends AnimatedComponent{

	public TetrisBoard(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	public void drawBoard()
	{
		for (int w = 0; w < 10; w++) {
			for (int h = 0; h < 24; h++) {
				g.fillRect(26 * w, 26 * h, 25, 25);
			}
		}
	}
	public void getColors() {
		for(int w = 0; w < 10; w++) {
			for(int h = 0; h < 24; h++) {
			}
		}
		
		for(Tetromino t: partsOnBoard) {
			colors[t.getPart(0).xPos()][t.getPart(0).xPos()] = t.getColor();
			colors[t.getPart(1).xPos()][t.getPart(1).xPos()] = t.getColor();
			colors[t.getPart(2).xPos()][t.getPart(2).xPos()] = t.getColor();
			colors[t.getPart(3).xPos()][t.getPart(3).xPos()] = t.getColor();
		}
	}

	public void drawImage(Graphics2D g) {
		g.drawRect(x, y, w, h);
	}
}
