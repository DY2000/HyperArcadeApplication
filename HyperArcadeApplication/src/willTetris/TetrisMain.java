package willTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TetrisMain extends FullFunctionScreen {

	private Tetromino[] partsOnBoard;
	private Graphics g;
	public TetrisMain(int width, int height) {
		super(width, height);
		partsOnBoard = new Tetromino[0];
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		viewObjects.add(new TetrisBoard())
	
	}
	public void drawBoard()
	{
		Graphics2D g = new Graphics2D();
		for (int w = 0; w < 10; w++) {
			for (int h = 0; h < 24; h++) {
				g.fillRect(26 * w, 26 * h, 25, 25);
			}
		}
	}
//	public void getColors() {
//		for(int w = 0; w < 10; w++) {
//			for(int h = 0; h < 24; h++) {
//			}
//		}
//		
//		for(Tetromino t: partsOnBoard) {
//			colors[t.getPart(0).xPos()][t.getPart(0).xPos()] = t.getColor();
//			colors[t.getPart(1).xPos()][t.getPart(1).xPos()] = t.getColor();
//			colors[t.getPart(2).xPos()][t.getPart(2).xPos()] = t.getColor();
//			colors[t.getPart(3).xPos()][t.getPart(3).xPos()] = t.getColor();
//		}
//	}

	public void drawImage(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
	}
}
