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

	private Block[][] board;
	private Color emptyColor;
	private Block b;
	private ArrayList<Block> Tetramino = new ArrayList<Block>(4);
	private ArrayList<ArrayList<Block>> Tetraminos = new ArrayList<ArrayList<Block>>(7);

	public TetrisMain(int width, int height) {
		super(width, height);
		emptyColor = Color.blue;
		// I PIECE
		Tetramino.add(new Block(3, 0, Color.blue));
		Tetramino.add(new Block(4, 0, Color.blue));
		Tetramino.add(new Block(5, 0, Color.blue));
		Tetramino.add(new Block(6, 0, Color.blue));
		Tetraminos.add(Tetramino);
		Tetramino = new ArrayList<Block>(4);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		board = new Block[10][20];
	}

	public void lower() {
		boolean canLower = true;
		for (Block b : Tetramino) {
			if (board[b.getX()][b.getX() - 1] != null)
				canLower = false;
			else {
				Tetramino.remove(0);
				newPiece();
			}
		}

		if (canLower) {
			for (Block b : Tetramino) {
				b.setX(b.getX() - 1);
				b.setY(b.getY() - 1);
			}
		}
	}

	public void newPiece() {
		Tetramino = Tetraminos.get(0);
		for (Block b : Tetramino) {
			if (board[b.getX()][b.getY()] != null)
				gameOver();
			else
				board[b.getX()][b.getY()] = b;
		}
	}

	private void gameOver() {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		for (int w = 0; w < board.length; w++) {
			for (int h = 0; h < board[w].length; h++) {
				if (board[w][h] != null)
					g.setColor(board[w][h].getColor());
				else
					g.setColor(emptyColor);
				g.fillRect(w * 30, h * 30, 25, 25);
			}
		}
	}
}
