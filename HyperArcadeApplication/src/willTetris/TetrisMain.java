package willTetris;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import devin.DevTicket;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.ArcadeGUI;

public class TetrisMain extends FullFunctionScreen implements DevTicket {

	private TextArea scoreBox;
	private TextArea textBox;
	private ArrayList<Block> ghost = new ArrayList<Block>(4);
	private Button start;
	private Button back;
	private Timer timer;
	private Block[][] board;
	private ArrayList<Block> tetramino = new ArrayList<Block>();
	private ArrayList<Block> active = new ArrayList<Block>();
	private ArrayList<ArrayList<Block>> tetraminos = new ArrayList<ArrayList<Block>>();
	private ArrayList<ArrayList<Block>> nextTetraminos = new ArrayList<ArrayList<Block>>();
	private int lines;
	private int delay;
	private int score;
	private TextArea linesBox;
	private TextArea levelBox;

	public TetrisMain(int width, int height) {
		super(width, height);
		board = new Block[10][20];
		delay = 2000;
		lines = 0;
		score = 0;
		// I PIECE 0
		tetramino.add(new Block(3, 0, Color.cyan));
		tetramino.add(new Block(5, 0, Color.cyan));
		tetramino.add(new Block(4, 0, Color.cyan));
		tetramino.add(new Block(6, 0, Color.cyan));
		tetraminos.add(tetramino);
		tetramino = new ArrayList<Block>();
		// O PIECE 1
		tetramino.add(new Block(4, 0, Color.yellow));
		tetramino.add(new Block(5, 0, Color.yellow));
		tetramino.add(new Block(4, 1, Color.yellow));
		tetramino.add(new Block(5, 1, Color.yellow));
		tetraminos.add(tetramino);
		tetramino = new ArrayList<Block>();
		// T PIECE 2
		tetramino.add(new Block(3, 1, Color.white));
		tetramino.add(new Block(4, 1, Color.white));
		tetramino.add(new Block(5, 1, Color.white));
		tetramino.add(new Block(4, 0, Color.white));
		tetraminos.add(tetramino);
		tetramino = new ArrayList<Block>();
		// S PIECE 3
		tetramino.add(new Block(3, 1, Color.green));
		tetramino.add(new Block(4, 1, Color.green));
		tetramino.add(new Block(4, 0, Color.green));
		tetramino.add(new Block(5, 0, Color.green));
		tetraminos.add(tetramino);
		tetramino = new ArrayList<Block>();
		// Z PIECE 4
		tetramino.add(new Block(5, 1, Color.red));
		tetramino.add(new Block(4, 1, Color.red));
		tetramino.add(new Block(3, 0, Color.red));
		tetramino.add(new Block(4, 0, Color.red));
		tetraminos.add(tetramino);
		tetramino = new ArrayList<Block>();
		// J PIECE 5
		tetramino.add(new Block(4, 0, Color.blue));
		tetramino.add(new Block(5, 1, Color.blue));
		tetramino.add(new Block(4, 1, Color.blue));
		tetramino.add(new Block(6, 1, Color.blue));
		tetraminos.add(tetramino);
		tetramino = new ArrayList<Block>();
		// L PIECE 6
		tetramino.add(new Block(6, 0, Color.orange));
		tetramino.add(new Block(5, 1, Color.orange));
		tetramino.add(new Block(6, 1, Color.orange));
		tetramino.add(new Block(4, 1, Color.orange));
		tetraminos.add(tetramino);
		tetramino = new ArrayList<Block>();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.black);

		start = new Button(235, 100, 100, 50, "START", new Action() {
			@Override
			public void act() {
				nextTetraminos.clear();
				for (int i = 0; i < 6; i++) {
					nextTetraminos.add((ArrayList<Block>) tetraminos.get((int) (Math.random() * tetraminos.size())).clone());
				}
				active = (ArrayList<Block>) nextTetraminos.get(0).clone();
				timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						lower();
					}
				}, delay, delay);
				start.setEnabled(false);
				start.setVisible(false);
				back.setEnabled(false);
				back.setVisible(false);
			}
		});
		start.setText("START");
		start.setSize(25);
		start.setForeground(Color.white);
		start.setVisible(true);
		viewObjects.add(start);

		scoreBox = new TextArea(250, 175, 100, 100, "SCORE \n" + score);
		scoreBox.setCustomTextColor(Color.WHITE);
		scoreBox.setVisible(true);
		viewObjects.add(scoreBox);

		linesBox = new TextArea(250, 250, 100, 100, "LINES \n" + lines);
		linesBox.setCustomTextColor(Color.WHITE);
		linesBox.setVisible(true);
		viewObjects.add(linesBox);

		levelBox = new TextArea(250, 325, 100, 100, "LEVEL \n" + (int) (lines / 10));
		levelBox.setCustomTextColor(Color.WHITE);
		levelBox.setVisible(true);
		viewObjects.add(levelBox);

		textBox = new TextArea(250, 400, 100, 100, "");
		textBox.setCustomTextColor(Color.WHITE);
		textBox.setVisible(true);
		viewObjects.add(textBox);

		back = new Button(230, 475, 100, 50, "BACK", new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.homeScreen);
				board = new Block[10][20];
				delay = 2000;
				lines = 0;
				score = 0;
				start.setVisible(true);
				start.setEnabled(true);
				textBox.setText("");
				scoreUp(0);
			}
		});
		back.setSize(25);
		back.setForeground(Color.WHITE);
		back.setVisible(true);
		viewObjects.add(back);
	}

	public void dropdown() {
		while (canLower()) {
			lower();
			scoreUp(2);
		}
	}

	public boolean canLower() {
		for (Block b : active) {
			if (b.getY() > 18) {
				return false;
			} else if (board[b.getX()][b.getY() + 1] != null) {
				if (!board[b.getX()][b.getY() + 1].getActive())
					return false;
			}
		}
		return true;
	}

	public void lower() {
		if (canLower()) {
			deleteActiveOnBoard();
			for (int i = 0; i < active.size(); i++) {
				active.set(i, new Block(active.get(i).getX(), active.get(i).getY() + 1, active.get(i).getColor()));
				board[active.get(i).getX()][active.get(i).getY()] = active.get(i);
			}

		} else {
			for (Block b : active) {
				b.setActive(false);
			}
			checkRows();
			newPiece();
		}
	}

	public void moveLeft() {
		boolean canMove = true;

		for (Block b : active) {
			if (b.getX() < 1) {
				canMove = false;
			} else if (board[b.getX() - 1][b.getY()] != null) {
				if (!board[b.getX() - 1][b.getY()].getActive()) {
					canMove = false;
				}
			}
		}

		if (canMove) {
			deleteActiveOnBoard();
			for (int i = 0; i < active.size(); i++) {
				active.set(i, new Block(active.get(i).getX() - 1, active.get(i).getY(), active.get(i).getColor()));
				board[active.get(i).getX()][active.get(i).getY()] = active.get(i);
			}
		}
	}

	public void moveRight() {
		boolean canMove = true;

		for (Block b : active) {
			if (b.getX() > 8) {
				canMove = false;
			} else if (board[b.getX() + 1][b.getY()] != null) {
				if (!board[b.getX() + 1][b.getY()].getActive()) {
					canMove = false;
				}
			}
		}

		if (canMove) {
			deleteActiveOnBoard();
			for (int i = 0; i < active.size(); i++) {
				active.set(i, new Block(active.get(i).getX() + 1, active.get(i).getY(), active.get(i).getColor()));
				board[active.get(i).getX()][active.get(i).getY()] = active.get(i);
			}
		}
	}

	public void checkRows() {
		boolean row = true;
		int rowCount = 0;

		for (int r = board[0].length - 1; r >= 0; r--) {
			row = true;
			for (int c = board.length - 1; c >= 0; c--) {
				if (board[c][r] == null)
					row = false;
			}
			if (row) {
				lines++;
				clearRow(r);
				moveDownAbove(r + 1);
				rowCount++;
				r++;
			}
		}
		if (rowCount > 0)
			scoreUp((rowCount * 200 - 100) * (int) (lines / 10));
	}

	public void newPiece() {
		active = (ArrayList<Block>) nextTetraminos.get(0).clone();
		nextTetraminos.remove(0);
		nextTetraminos.add((ArrayList<Block>) tetraminos.get((int) (Math.random() * tetraminos.size())).clone());

		if (gameOver()) {
			textBox.setText("GAME OVER");
			timer.cancel();
			active.clear();
			back.setEnabled(true);
			back.setVisible(true);
		} else
			lower();

	}

	private void scoreUp(int i) {
		score += i;
		scoreBox.setText("SCORE \n" + score);
		linesBox.setText("LINES \n" + lines);
		levelBox.setText("LEVEL \n" + (int) (lines / 10));
		delay = (int) (2000 * Math.pow(.7, (int) (lines / 10)));
	}

	private void moveDownAbove(int r) {
		for (int x = r - 1; x > 0; x--) {
			for (int b = board.length - 1; b >= 0; b--) {
				board[b][x] = board[b][x - 1];
			}
		}
	}

	private void clearRow(int h) {
		for (int b = board.length - 1; b >= 0; b--) {
			board[b][h] = null;
		}
	}

	public boolean gameOver() {
		for (Block b : active) {
			if (board[b.getX()][b.getY()] != null)
				return true;
		}
		return false;
	}

	public void rotate() {
		int transX = active.get(1).getX() - active.get(1).getY();
		int transY = active.get(1).getX() + active.get(1).getY();
		boolean canRotate = true;
		for (Block b : active) {
			if (b.getY() + transX < 0 || b.getY() + transX > 9 || -b.getX() + transY > 19 || -b.getX() + transY < 0)
				canRotate = false;
			else if (board[b.getY() + transX][-b.getX() + transY] != null)
				if (!board[b.getY() + transX][-b.getX() + transY].getActive())
					canRotate = false;

		}
		if (canRotate) {
			for (Block b : active) {
				board[b.getX()][b.getY()] = null;
			}
			for (Block b : active) {
				active.set(active.indexOf(b), new Block(b.getY() + transX, -b.getX() + transY, b.getColor()));
			}
			for (Block b : active) {
				board[b.getX()][b.getY()] = b;
			}
		}
	}

	public void deleteActiveOnBoard() {
		for (Block b : active) {
			board[b.getX()][b.getY()] = null;
		}
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (!active.isEmpty())
				moveRight();
			break;
		case KeyEvent.VK_LEFT:
			if (!active.isEmpty())
				moveLeft();
			break;
		case KeyEvent.VK_UP:
			if (!active.isEmpty() && active.get(0).getColor() != Color.yellow)
				rotate();
			break;
		case KeyEvent.VK_DOWN:
			if (!active.isEmpty()) {
				lower();
				scoreUp(1);
			}
			break;
		case KeyEvent.VK_SPACE:
			if (!active.isEmpty()) {
				dropdown();
				lower();
			}
			break;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(357, 79, 310, 610);
		g.setColor(Color.black);
		g.fillRect(362, 84, 300, 600);

		for (int w = 0; w < board.length; w++) {
			for (int h = 0; h < board[w].length; h++) {
				if (board[w][h] != null)
					g.setColor(board[w][h].getColor());
				else
					g.setColor(Color.black);
				g.fillRect(w * 30 + 362, h * 30 + 84, 27, 27);
			}
		}

		for (int i = 0; i < nextTetraminos.size(); i++) {
			for (int j = 0; j < 4; j++) {
				g.setColor(nextTetraminos.get(i).get(j).getColor());
				g.fillRect(nextTetraminos.get(i).get(j).getX() * 30 + 600, nextTetraminos.get(i).get(j).getY() * 30 + 105 + 100 * i, 27,
						27);
			}
		}
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void toTicket() {
		ArcadeGUI.homeScreen.updateTickets((int) score / 20);
	}

	@Override
	public void displayTickets() {
		// TODO Auto-generated method stub

	}
}
