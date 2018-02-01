package willTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TetrisMain extends FullFunctionScreen {

	private Block[][] board;
	private ArrayList<Block> Tetramino = new ArrayList<Block>(4);
	private ArrayList<Block> active = new ArrayList<Block>(4);
	private ArrayList<ArrayList<Block>> Tetraminos = new ArrayList<ArrayList<Block>>(7);
	private ArrayList<ArrayList<ArrayList<Block>>> TetraminoRotations = new ArrayList<ArrayList<ArrayList<Block>>>(4);

	public TetrisMain(int width, int height) {
		super(width, height);
		// I PIECE
		Tetramino.add(new Block(3, 0, Color.blue));
		Tetramino.add(new Block(4, 0, Color.blue));
		Tetramino.add(new Block(5, 0, Color.blue));
		Tetramino.add(new Block(6, 0, Color.blue));
		Tetraminos.add(Tetramino);
		Tetramino = new ArrayList<Block>(4);
		Tetramino.add(new Block(5, 2, Color.cyan));
		Tetramino.add(new Block(5, 3, Color.cyan));
		Tetramino.add(new Block(5, 4, Color.cyan));
		Tetramino.add(new Block(4, 5, Color.cyan));
		Tetraminos.add(Tetramino);
		Tetramino = new ArrayList<Block>(4);

		active = Tetraminos.get(0);
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				lower();
			}
		}, 0, 100);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		board = new Block[10][20];
	}

	public void dropdown() {
	}

	public void lower() {
		boolean canLower = true;

		for (Block b : active) {
			if (board[b.getX()][b.getY() + 1] != null && !board[b.getX()][b.getY()+1].getActive() || b.getY() > 17) {
				canLower = false;
				b.setActive(false);
			}
		}

		if (canLower) {
			for (int i = 0; i < 4; i++) {
				board[active.get(i).getX()][active.get(i).getY()] = null;
				active.set(i, new Block(active.get(i).getX(), active.get(i).getY() + 1, active.get(i).getColor()));
				board[active.get(i).getX()][active.get(i).getY()] = active.get(i);
			}
		} else {
			newPiece();
		}
	}

	public void newPiece() {
		active = Tetraminos.get(1);
	}

	public void gameOver() {

	}

	public void paint(Graphics g) {
		for (int w = 0; w < board.length; w++) {
			for (int h = 0; h < board[w].length; h++) {
				if (board[w][h] != null)
					g.setColor(board[w][h].getColor());
				else
					g.setColor(Color.black);
				g.fillRect(w * 30, h * 30, 25, 25);
			}
		}
	}

}
