package willTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TetrisMain extends FullFunctionScreen {

	private boolean[][] board;
	private Color[][] boardColors;
	private Color emptyColor;
	private Block b;

	public TetrisMain(int width, int height) {
		super(width, height);
		emptyColor = Color.blue;
		boardColors = new Color[10][20];
		for (int w = 0; w < boardColors.length; w++) {
			for (int h = 0; h < boardColors[w].length; h++) {
				boardColors[w][h] = emptyColor;
			}
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		b = new Block(100, 100, emptyColor);
		b.setVisible(true);
		viewObjects.add(b);
	}

	public void paint(Graphics g) {
		
		for (int w = 0; w < boardColors.length; w++) {
			for (int h = 0; h < boardColors[w].length; h++) {
				boardColors[w][h] = emptyColor;
			}
		}
		
		for (int w = 0; w < boardColors.length; w++) {
			for (int h = 0; h < boardColors[w].length; h++) {
				g.setColor(boardColors[w][h]);
				g.fillRect(w * 30, h * 30, 25, 25);
			}
		}
	}

}
