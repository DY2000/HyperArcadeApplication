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

	private boolean[][] board;
	private Color[][] boardColors;
	private Color emptyColor;

	public TetrisMain(int width, int height) {
		super(width, height);
		boardColors = new Color[10][20];
		for (int w = 0; w < boardColors.length; w++) {
			for (int h = 0; h < boardColors.length; h++) {
				boardColors[w][h] = emptyColor;
			}
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

	}

	public void paint(Graphics2D g) {
		g.setColor(Color.blue);
		for (int w = 0; w < boardColors.length; w++) {
			for (int h = 0; h < boardColors.length; h++) {
				g.drawRect(w * 6, h * 6, 5, 5);
			}
		}
	}

	public void drawImage(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
	}
}
