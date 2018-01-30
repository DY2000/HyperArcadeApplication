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
	private ArrayList<Arraylist<Block>> Tetraminos = new ArrayList<ArrayList<<Block>>(7);

	public TetrisMain(int width, int height) {
		super(width, height);
		emptyColor = Color.blue;
		boardColors = new Color[10][20];
		//I PIECE
		Tetramino.add(Block(3,0));
		Tetramino.add(Block(4,0));
		Tetramino.add(Block(5,0));
		Tetramino.add(Block(6,0));
		Tetraminos.add(Tetramino);
		Tetramino = new ArrayList<Block>(4) 
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
	}
	
	public void dropDown(){
		for (Block b: Tetramino){
			boolean canDropDown = true;
			if(board[b.getX][b.getY - 1] != null) boolean canDropDown = false;
		} else{
			Tetramino.remove(0,5);
			newPiece();
		}
		
		if(canDropDown){
			for(Block b: Tetramino){
				b.setX(b.getX - 1);
				b.setY(b.getY - 1);
			}
		}
	}
	
	public void newPiece(){
	
	}

	public void paint(Graphics g) {
		for (int w = 0; w < board.length; w++) {
			for (int h = 0; h < board[w].length; h++) {
				g.setColor(Color.blue);
				if(board[w][h] != null) g.setColor(boardColors[w][h]);
				g.fillRect(w * 30, h * 30, 25, 25);
			}
		}
	}

}
