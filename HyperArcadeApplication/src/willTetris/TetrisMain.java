package willTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
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
		emptyColor = Color.black;
		// I PIECE
		Tetramino.add(new Block(3, 0, Color.blue));
		Tetramino.add(new Block(4, 0, Color.blue));
		Tetramino.add(new Block(5, 0, Color.blue));
		Tetramino.add(new Block(6, 0, Color.blue));
		board[3][0] = Tetramino.get(0);
		board[4][0] = Tetramino.get(0);
		board[5][0] = Tetramino.get(0);
		board[6][0] = Tetramino.get(0);
		Tetraminos.add(Tetramino);
		Tetramino = new ArrayList<Block>(4);
		Thread dropdown = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					lower();
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		dropdown.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		board = new Block[10][20];
	}

	public void dropdown() {
	}

	public void lower() {
//		boolean canLower = true;
//		for (Block b : Tetramino) {
//			if (board[b.getX()][b.getY() - 1] != null)
//				canLower = false;
//			else {
//				Tetramino.remove(0);
//				newPiece();
//			}
//		}
//
//		if (canLower) {
			for (Block b : Tetramino) {
				Tetramino.set(0, new Block(b.getX(), b.getY() - 1, b.getColor()));
				board[b.getX()][b.getY()] = b;
			}
//		}
		repaint();
	}

	public void newPiece() {
		Tetramino = Tetraminos.get(0);
		for (Block b : Tetramino) {
			if (board[b.getX()][b.getY()] != null)
				gameOver();
			else
				board[b.getX()][b.getY()] = b;
		}
		repaint();
	}

	public void gameOver() {

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
