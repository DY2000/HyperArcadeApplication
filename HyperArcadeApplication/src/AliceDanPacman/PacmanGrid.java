package AliceDanPacman;

import guiTeacher.components.AnimatedComponent;

public class PacmanGrid extends AnimatedComponent {
	private boolean dotGrid[][];
	private boolean movementGrid[][];
		
	public PacmanGrid(int x, int y, int w, int h, String type) {
		super(x,y,w,h);
		if(type == "dot") {
			dotGrid = new boolean[13][14];
		}
		else {
			movementGrid = new boolean[13][14];
		}

	}
	
	public void checkBehaviors() {
		for(int row = 0; row < movementGrid.length; row++) {
			for(int col = 0; col < movementGrid[row].length; col++) {
				movementGrid[row][col] = true;
				
			}
		}
		movementGrid[0][0] = false;
		movementGrid[0][1] = false;
		movementGrid[0][2] = false;
		movementGrid[0][3] = false;
		movementGrid[0][4] = false;
		movementGrid[0][5] = false;
		movementGrid[0][6] = false;
		movementGrid[0][7] = false;
		for(int row = 0; row < dotGrid.length; row++) {
			for(int col = 0; col < dotGrid[row].length; col++) {
				dotGrid[row][col] = true;
			}
		}
		
	}
	
}
