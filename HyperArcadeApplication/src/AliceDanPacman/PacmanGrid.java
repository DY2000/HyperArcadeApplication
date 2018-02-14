package AliceDanPacman;

import guiTeacher.components.AnimatedComponent;

public class PacmanGrid extends AnimatedComponent {
	private String type;
	private int grid[][];
	private PacmanScreen game;	
	
	public PacmanGrid(int x, int y, int w, int h, PacmanScreen game) {
		super(x,y,w,h);
		this.type = type;
		this.game = game;
		grid = new int[26][29];
		generateGrid();
		Thread t = new Thread(this);
		t.start();
	}
	
	public void generateGrid() {
		for(int x = 0; x < grid.length; x++) {
			for(int y = 0; y < grid[x].length; y++) {
				grid[x][y] = 0;
			}
		}
		
		//The Walls of the grid
		//My Eyes have seen hell
		grid[0][8] = -1;  grid[0][12] = -1;  grid[0][14] = -1;  grid[0][18] = -1;  grid[0][23] = -1;  grid[0][24] = -1;
		grid[1][1] = -1;  grid[1][2] = -1;   grid[1][3] = -1;   grid[1][5] = -1;   grid[1][6] = -1;
		grid[1][8] = -1;  grid[1][12] = -1;  grid[1][14] = -1;  grid[1][18] = -1;  grid[1][20] = -1;
		grid[1][21] = -1; grid[1][23] = -1;  grid[1][24] = -1;  grid[1][26] = -1;  grid[1][27] = -1;
		grid[2][1] = -1;  grid[2][3] = -1;   grid[2][5] = -1;   grid[2][6] = -1;   grid[2][8] = -1;
		grid[2][12] = -1; grid[2][14] = -1;  grid[2][18] = -1;	grid[2][20] = -1;  grid[2][21] = -1;
		grid[2][26] = -1; grid[2][27] = -1;
		grid[3][1] = -1;  grid[3][3] = -1;   grid[3][5] = -1;   grid[3][6] = -1;   grid[3][8] = -1;
		grid[3][12] = -1; grid[3][14] = -1;  grid[3][18] = -1;  grid[3][20] = -1;  grid[3][21] = -1;
		grid[3][22] = -1; grid[3][23] = -1;  grid[3][24] = -1;  grid[3][26] = -1;  grid[3][27] = -1;
		grid[4][1] = -1;  grid[4][2] = -1;   grid[4][3] = -1;   grid[4][5] = -1;   grid[4][6] = -1;
		grid[4][8] = -1;  grid[4][9] = -1;   grid[4][10] = -1;  grid[4][11] = -1;  grid[4][12] = -1;
		grid[4][14] = -1; grid[4][15] = -1;  grid[4][16] = -1;  grid[4][17] = -1;  grid[4][18] = -1;
		grid[4][20] = -1; grid[4][21] = -1;  grid[4][22] = -1;  grid[4][23] = -1;  grid[4][24] = -1;
		grid[4][26] = -1; grid[4][27] = -1;
		grid[5][26] = -1; grid[5][27] = -1;
		grid[6][1] = -1;  grid[6][2] = -1;   grid[6][3] = -1;  	grid[6][5] = -1;   grid[6][6] = -1;
		grid[6][7] = -1;  grid[6][8] = -1;   grid[6][9] = -1;   grid[6][10] = -1;  grid[6][11] = -1;
		grid[6][12] = -1; grid[6][14] = -1;  grid[6][15] = -1;  grid[6][16] = -1;  grid[6][17] = -1;
		grid[6][18] = -1; grid[6][20] = -1;  grid[6][21] = -1;  grid[6][23] = -1;  grid[6][24] = -1; 
		grid[6][25] = -1; grid[6][26] = -1;  grid[6][27] = -1;
		grid[7][1] = -1;  grid[7][3] = -1;   grid[7][5] = -1;   grid[7][6] = -1;   grid[7][7] = -1;
		grid[7][8] = -1;  grid[7][9] = -1;   grid[7][10] = -1;  grid[7][11] = -1;  grid[7][12] = -1;
		grid[7][14] = -1; grid[7][15] = -1;  grid[7][16] = -1;  grid[7][17] = -1;  grid[7][18] = -1;
		grid[7][20] = -1; grid[7][21] = -1;  grid[7][23] = -1;  grid[7][24] = -1;  grid[7][25] = -1;
		grid[7][26] = -1; grid[7][27] = -1;
		grid[8][1] = -1;  grid[8][3] = -1;   grid[8][8] = -1;   grid[8][9] = -1;   grid[8][20] = -1;
		grid[8][21] = -1; grid[8][26] = -1;  grid[8][27] = -1;
		grid[9][1] = -1;  grid[9][3] = -1;   grid[9][5] = -1;   grid[9][6] = -1;   grid[9][8] = -1;
		grid[9][9] = -1;  grid[9][11] = -1;  grid[9][12] = -1;  grid[9][13] = -1;  grid[9][14] = -1;
		grid[9][15] = -1; grid[9][17] = -1;  grid[9][18] = -1;  grid[9][20] = -1;  grid[9][21] = -1;
		grid[9][23] = -1; grid[9][24] = -1;  grid[9][26] = -1;  grid[9][27] = -1;
		grid[10][1] = -1; grid[10][2] = -1;  grid[10][3] = -1;  grid[10][5] = -1;  grid[10][6] = -1;
		grid[10][8] = -1; grid[10][9] = -1;  grid[10][11] = -1; grid[10][15] = -1; grid[10][17] = -1;
		grid[10][18] = -1;grid[10][20] = -1; grid[10][21] = -1; grid[10][23] = -1; grid[10][24] = -1;
		grid[10][26] = -1;grid[10][27] = -1;
		grid[11][5] = -1; grid[11][6] = -1;  grid[11][11] = -1; grid[11][15] = -1; grid[11][17] = -1;
		grid[11][18] = -1;grid[11][23] = -1; grid[11][24] = -1;
		grid[12][0] = -1; grid[12][1] = -1;  grid[12][2] = -1;  grid[12][3] = -1;  grid[12][5] = -1;
		grid[12][6] = -1; grid[12][7] = -1;  grid[12][8] = -1;  grid[12][9] = -1;  grid[12][11] = -1;
		grid[12][15] = -1;grid[12][17] = -1; grid[12][18] = -1; grid[12][19] = -1; grid[12][20] = -1;
		grid[12][21] = -1;grid[12][23] = -1; grid[12][24] = -1; grid[12][25] = -1; grid[12][26] = -1;
		grid[12][27] = -1;
		grid[13][0] = -1; grid[13][1] = -1;  grid[13][2] = -1;  grid[13][3] = -1;  grid[13][5] = -1;
		grid[13][6] = -1; grid[13][7] = -1;  grid[13][8] = -1;  grid[13][9] = -1;  grid[13][11] = -1;
		grid[13][15] = -1;grid[13][17] = -1; grid[13][18] = -1; grid[13][19] = -1; grid[13][20] = -1;
		grid[13][21] = -1;grid[13][23] = -1; grid[13][24] = -1; grid[13][25] = -1; grid[13][26] = -1;
		grid[13][27] = -1;
		grid[14][5] = -1; grid[14][6] = -1;  grid[14][11] = -1; grid[14][15] = -1; grid[14][17] = -1;
		grid[14][18] = -1;grid[14][23] = -1; grid[14][24] = -1;
		grid[15][1] = -1; grid[15][2] = -1;  grid[15][3] = -1;  grid[15][5] = -1;  grid[15][6] = -1;
		grid[15][8] = -1; grid[15][9] = -1;  grid[15][11] = -1; grid[15][15] = -1; grid[15][17] = -1;
		grid[15][18] = -1;grid[15][20] = -1; grid[15][21] = -1; grid[15][23] = -1; grid[15][24] = -1;
		grid[15][26] = -1;grid[15][27] = -1;
		grid[16][1] = -1; grid[16][3] = -1;  grid[16][5] = -1;  grid[16][6] = -1;  grid[16][8] = -1; 
		grid[16][9] = -1; grid[16][11] = -1; grid[16][12] = -1; grid[16][13] = -1; grid[16][14] = -1;
		grid[16][15] = -1;grid[16][17] = -1; grid[16][18] = -1; grid[16][20] = -1; grid[16][21] = -1;
		grid[16][23] = -1;grid[16][24] = -1; grid[16][26] = -1; grid[16][27] = -1;
		grid[17][1] = -1; grid[17][3] = -1;  grid[17][8] = -1;  grid[17][9] = -1;  grid[17][20] = -1;
		grid[17][21] = -1;grid[17][26] = -1; grid[17][27] = -1;
		grid[18][1] = -1; grid[18][3] = -1;  grid[18][5] = -1;  grid[18][6] = -1;  grid[18][7] = -1;
		grid[18][8] = -1; grid[18][9] = -1;  grid[18][10] = -1; grid[18][11] = -1; grid[18][12] = -1;
		grid[18][14] = -1;grid[18][15] = -1; grid[18][16] = -1; grid[18][17] = -1; grid[18][18] = -1;
		grid[18][20] = -1;grid[18][21] = -1; grid[18][23] = -1; grid[18][24] = -1; grid[18][25] = -1;
		grid[18][26] = -1;grid[18][27] = -1;
		grid[19][1] = -1; grid[19][2] = -1;  grid[19][3] = -1;  grid[19][5] = -1;  grid[19][6] = -1;
		grid[19][7] = -1; grid[19][8] = -1;  grid[19][9] = -1;  grid[19][10] = -1; grid[19][11] = -1;
		grid[19][12] = -1;grid[19][14] = -1; grid[19][15] = -1; grid[19][16] = -1; grid[19][17] = -1;
		grid[19][18] = -1;grid[19][20] = -1; grid[19][21] = -1; grid[19][23] = -1; grid[19][24] = -1;
		grid[19][25] = -1;grid[19][26] = -1; grid[19][27] = -1;
		grid[20][26] = -1;grid[20][27] = -1;
		grid[21][1] = -1; grid[21][2] = -1;  grid[21][3] = -1;  grid[21][5] = -1;  grid[21][6] = -1;
		grid[21][8] = -1; grid[21][9] = -1;  grid[21][10] = -1; grid[21][11] = -1; grid[21][12] = -1;
		grid[21][14] = -1;grid[21][15] = -1; grid[21][16] = -1; grid[21][17] = -1; grid[21][18] = -1;
		grid[21][20] = -1;grid[21][21] = -1; grid[21][22] = -1; grid[21][23] = -1; grid[21][24] = -1;
		grid[21][26] = -1;grid[21][27] = -1;
		grid[22][1] = -1; grid[22][3] = -1;  grid[22][5] = -1;  grid[22][6] = -1;  grid[22][8] = -1;
		grid[22][12] = -1;grid[22][14] = -1; grid[22][18] = -1; grid[22][20] = -1; grid[22][21] = -1;
		grid[22][22] = -1;grid[22][23] = -1; grid[22][24] = -1; grid[22][26] = -1; grid[22][27] = -1;
		grid[23][1] = -1; grid[23][3] = -1;  grid[23][5] = -1;  grid[23][6] = -1;  grid[23][8] = -1;
		grid[23][12] = -1;grid[23][14] = -1; grid[23][18] = -1; grid[23][20] = -1; grid[23][21] = -1;
		grid[23][26] = -1;grid[23][27] = -1;
		grid[24][1] = -1; grid[24][2] = -1;  grid[24][3] = -1;  grid[24][5] = -1;  grid[24][6] = -1;
		grid[24][8] = -1; grid[24][12] = -1; grid[24][14] = -1; grid[24][18] = -1; grid[24][20] = -1;
		grid[24][21] = -1;grid[24][23] = -1; grid[24][24] = -1; grid[24][26] = -1; grid[24][27] = -1;
		grid[25][8] = -1; grid[25][12] = -1; grid[25][14] = -1; grid[25][18] = -1; grid[25][23] = -1; grid[25][24] = -1;
		
		//Now for the Dots
		
	}
	
	public void checkBehaviors() {
		
	}
	
	public int[][] grid(){
		return grid;
	}
	
	public void moveLeft(int pacX, int pacY) {
		if(pacX != 0)
			if(grid[pacX-1][pacY] != -1) {
				game.getPacman().setDirection(0);
				game.getPacman().setGridX(pacX-1);
			}
		if(pacX == 0 && pacY == 13) {
			game.getPacman().setDirection(0);
			game.getPacman().setGridX(grid.length-1);
		}
	}
	public void moveRight(int pacX, int pacY) {
		if(pacX != grid.length-1)
			if(grid[pacX+1][pacY] != -1) {
				game.getPacman().setDirection(2);
				game.getPacman().setGridX(pacX+1);
			}
		if(pacX == grid.length-1 && pacY == 13) {
			game.getPacman().setDirection(2);
			game.getPacman().setGridX(0);
		}
	}
	public void moveUp(int pacX, int pacY) {
		if(pacY != 0)
			if(grid[pacX][pacY-1] != -1) {
				game.getPacman().setDirection(1);
				game.getPacman().setGridY(pacY-1);
			}
	}
	public void moveDown(int pacX, int pacY) {
		if(pacY != grid[pacX].length-1)
			if(grid[pacX][pacY+1] != -1) {
				game.getPacman().setDirection(3);
				game.getPacman().setGridY(pacY+1);
			}
	}
}
