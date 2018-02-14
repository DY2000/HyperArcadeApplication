package AliceDanPacman;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import willTetris.Collidable;

public class AliceGhost extends AnimatedComponent{
	
	//there are 4 main ghosts named blinky (red), pinky, clyde (orange), inky (blue)
	//scatter mode-each ghost has a predefined corner of the grid that they follow
	//The red ghost starts outside of the ghost house, and is usually the first one to be seen as a threat
	//http://gameinternals.com/post/2072558330/understanding-pac-man-ghost-behavior	
	//The pink ghost starts inside the ghost house, but always exits immediately, even in the first level. 
	//The blue ghost is nicknamed Inky, and remains inside the ghost house for a short time on the first level, 
	//not joining the chase until Pac-Man has managed to consume at least 30 of the dots. 
	//The orange ghost, â€œClydeâ€�, is the last to leave the ghost house, and does not exit 
	//at all in the first level until over a third of the dots have been eaten. 
	//The ghosts are always in one of three possible modes: Chase, Scatter, or Frightened. 
	//chase-normal mode with ghosts chasing pacman
	// While in Chase mode, all of the ghosts use Pac-Manâ€™s position as a factor in selecting their target tile, 
	//though it is more significant to some ghosts than others.
	//Frightened mode is unique because the ghosts do not have a specific target tile while in this mode. 
	//A ghost in Frightened mode also turns dark blue, moves much more slowly and can be eaten by Pac-Man.
	//red is leader
	//red gets a boost after having eaten a certain number of dots
	//pink kind of follows red
	//blue unpredictable 
	//orange acts stupid
	private boolean canBeEaten;
	private boolean eaten;
	private boolean spawned;
	private BufferedImage img;
	private String ghostType;
	private int direction;
	//0 = LEFT, 1 = UP, 2 = RIGHT, 3 = DOWN
	private int gridX;
	private int gridY;
	private PacmanScreen game;
	
	public AliceGhost(int x, int y, int w, int h, String ghostType, PacmanScreen game) {
		super(x, y, w, h);
		this.game = game;
		this.ghostType = ghostType;
		spawned = false;
		if(ghostType == "red") {
			gridX = 12;
			gridY = 10;
			spawned = true;
		}else if(ghostType == "pink") {
			gridX = 12;
			gridY = 13;
		}else if(ghostType == "cyan") {
			gridX = 10;
			gridY = 13;
		}else if(ghostType == "orange") {
			gridX = 14;
			gridY = 13;
		}
		direction = 0;
		canBeEaten = false;
		eaten = false;
		update();
		Thread t = new Thread(this);
		t.start();
	}
	
	public void drawImage(Graphics2D g) {
		if(!canBeEaten && !eaten) {
			if(ghostType == "red") {
				if(direction == 0 ) {
					img = game.getRedLeft().getImage();
				}else if(direction == 1 ) {
					img = game.getRedUp().getImage();
				}else if(direction == 2 ) {
					img = game.getRedRight().getImage();
				}else if(direction == 3 ) {
					img = game.getRedDown().getImage();
				}
			}else if(ghostType == "pink") {
				if(direction == 0 ) {
					img = game.getPinkLeft().getImage();
				}else if(direction == 1 ) {
					img = game.getPinkUp().getImage();
				}else if(direction == 2 ) {
					img = game.getPinkRight().getImage();
				}else if(direction == 3 ) {
					img = game.getPinkDown().getImage();
				}
			}else if(ghostType == "cyan") {
				if(direction == 0 ) {
					img = game.getCyanLeft().getImage();
				}else if(direction == 1 ) {
					img = game.getCyanUp().getImage();
				}else if(direction == 2 ) {
					img = game.getCyanRight().getImage();
				}else if(direction == 3 ) {
					img = game.getCyanDown().getImage();
				}
			}else if(ghostType == "orange") {
				if(direction == 0 ) {
					img = game.getOrangeLeft().getImage();
				}else if(direction == 1 ) {
					img = game.getOrangeUp().getImage();
				}else if(direction == 2 ) {
					img = game.getOrangeRight().getImage();
				}else if(direction == 3 ) {
					img = game.getOrangeDown().getImage();
				}
			}
		}else if(canBeEaten && !eaten) {
			img = game.getScaredGhost().getImage();
		}
		if(img != null) {
			this.clear();
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
		}
	}
	
	public void checkBehaviors() {
		setX((17*gridX) +325 + 18);
		setY((17*gridY) +50  + 72);
		if(spawned && !eaten && game.isRunning()) {
			move();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void move() {
		int[][] grid = game.getGrid().grid();
		 direction = (int)(Math.random()*4);
		
		 if(direction == 0) {
			 if(gridX != 0) {
				 	System.out.println(grid[gridX-1][gridY]);
					if(grid[gridX-1][gridY] != -1) {
						setDirection(0);
						setGridX(gridX-1);
					}
				}
				if(gridX == 0 && gridY == 13) {
					game.getPacman().setDirection(0);
					game.getPacman().setGridX(grid.length-1);
				}
		 }
		 if(direction == 1) {
			 if(gridY != 0) {
					if(grid[gridX][gridY-1] != -1) {
						setDirection(1);
						setGridY(gridY-1);
					}
				}
		 }
		 if(direction == 2) {
			 if(gridX != grid.length-1) {
					if(grid[gridX+1][gridY] != -1) {
						setDirection(0);
						setGridX(gridX+1);
					}
				}
				if(gridX == grid.length-1 && gridY == 13) {
					game.getPacman().setDirection(0);
					game.getPacman().setGridX(grid.length-1);
				}
		 }
		 if(direction == 3) {
			 if(gridY != grid[gridX].length-1) {
					if(grid[gridX][gridY+1] != -1) {
						setDirection(0);
						setGridX(gridX-1);
					}
				}
		 }
		 
	}
	 
	
	private void setGridY(int i) {
		gridY = i;
	}

	private void setGridX(int i) {
		gridX = i;
	}

	private void setDirection(int i) {
		direction = i;
	}

	private boolean isBlue(DanielPacman pacman) {
		if(pacman.wentOverPowerUp()) {
			return true;
		}
		return false;
	}
	
	private boolean wentOverDots() {
		return false;
	}
	
}
