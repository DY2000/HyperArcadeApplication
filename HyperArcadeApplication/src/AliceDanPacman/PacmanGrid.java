package AliceDanPacman;

import guiTeacher.components.AnimatedComponent;

public class PacmanGrid extends AnimatedComponent {
	private String type;
	private boolean dotGrid[][];
	private boolean movementGrid[][];
	private PacmanScreen game;	
	
	public PacmanGrid(int x, int y, int w, int h, String type, PacmanScreen game) {
		super(x,y,w,h);
		this.type = type;
		this.game = game;
		if(type == "dot") {
			dotGrid = new boolean[13][14];
			for(int row = 0; row < dotGrid.length; row++) {
				for(int col = 0; col < dotGrid[row].length; col++) {
					dotGrid[row][col] = true;
				}
			}
		}
		else {
			movementGrid = new boolean[16][18];
			for(int row = 0; row < movementGrid.length; row++) {
				for(int col = 0; col < movementGrid[row].length; col++) {
					movementGrid[row][col] = true;
					
				}
			}
		}

	}
	
	public void checkBehaviors() {
		
	}
	
	public boolean[][] getGrid(){
		if(type == "dot")
			return dotGrid;
		else
			return movementGrid;
	}
	
	public void moveLeft(int pacX, int pacY) {
		if(movementGrid[pacX-1][pacY]) {
			game.getPacman().setGridX(pacX-1);
		}
	}
	public void moveRight(int pacX, int pacY) {
		if(movementGrid[pacX+1][pacY]) {
			game.getPacman().setGridX(pacX+1);
		}
	}
	public void moveUp(int pacX, int pacY) {
		if(movementGrid[pacX][pacY-1]) {
			game.getPacman().setGridY(pacY-1);
		}
	}
	public void moveDown(int pacX, int pacY) {
		if(movementGrid[pacX][pacY+1]) {
			game.getPacman().setGridY(pacY+1);
		}
	}
}
