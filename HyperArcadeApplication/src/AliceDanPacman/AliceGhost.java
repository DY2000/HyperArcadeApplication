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
		spawned = true;
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
		}else if(eaten){
			BufferedImage temp;
			try {
				temp = ImageIO.read(new File("resources/Pacman_spriteSheet.png"));
				img = temp.getSubimage(16, 80, 14, 14);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(img != null) {
			this.clear();
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
		}
	}
	
	public void checkBehaviors() {
		setX((17*gridX) +325 + 18);
		setY((17*gridY) +50  + 72);
		canBeEaten = game.getPacman().canEatGhost();
		if(canBeEaten && game.isRunning() && spawned) {
			if(gridX == game.getPacman().getGridX() && gridY == game.getPacman().getGridY()) {
				eaten = true;
			}
		}else if(!canBeEaten && game.isRunning() && spawned){
			if(gridX == game.getPacman().getGridX() && gridY == game.getPacman().getGridY()) {
				game.getPacman().death();
			}
		}
		if(eaten) {
			update();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eaten = false;
			reset();
		}
		if(spawned && !eaten && game.isRunning()) {
			move();
			game.getGrid().moveGhost(this);
			if(game.getGrid().getDotCount() > 20)
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void move() {
		int[][] grid = game.getGrid().grid();
		int newD = direction;
		boolean canLeft = false;
		boolean canRight = false;
		boolean canUp = false;
		boolean canDown = false;
		if(gridX != 0)
			canLeft = (grid[gridX-1][gridY] != -1);
		if(gridY != 0)
			canUp = (grid[gridX][gridY-1] != -1);
		if(gridX != grid.length-1)
			canRight = (grid[gridX+1][gridY] != -1);
		if(gridY != grid[gridX].length-1)
			canDown = (grid[gridX][gridY+1] != -1);
		String intersection = "_";
		ArrayList<Integer> options = new ArrayList<Integer>();
		if(canLeft) {
			intersection += "L";
		}
		if(gridX != grid.length-1)
		if(canRight) {
			intersection += "R";
		}
		if(gridY != 0)
		if(canUp) {
			intersection += "U";
		}
		if(gridY != grid[gridX].length -1)
		if(canDown) {
			intersection += "D";
		}
		if(intersection.contains("L")) {
			options.add(0);
		}
		if(intersection.contains("R")) {
			options.add(2);
		}
		if(intersection.contains("U")) {
			options.add(1);
		}
		if(intersection.contains("D")) {
			options.add(3);
		}
		if(options.size() > 2) {
			newD = options.get((int)(Math.random()*options.size()));
			while(newD == (direction+2%4)) {
				newD = options.get((int)(Math.random()*options.size()));
			}
			direction = newD;
		}else if((canLeft && canRight) || (canUp && canDown)) {
			direction = newD;
		}else {
			newD = options.get((int)(Math.random()*options.size()));
			while(newD == (direction+2%4)) {
				newD = options.get((int)(Math.random()*options.size()));
			}
			direction = newD;
		}
		options.clear();
		intersection = "";
	}
	 
	
	public void setGridY(int i) {
		gridY = i;
	}

	public void setGridX(int i) {
		gridX = i;
	}

	public void setDirection(int i) {
		direction = i;
	}

	public boolean isBlue(DanielPacman pacman) {
		if(pacman.wentOverPowerUp()) {
			return true;
		}
		return false;
	}
	
	public boolean wentOverDots() {
		return false;
	}

	public int getGridX() {
		return gridX;
	}
	
	public int getGridY() {
		return gridY;
	}

	public int getDirection() {
		return direction;
	}

	public void reset() {
		if(ghostType == "red") {
			gridX = 12;
			gridY = 10;
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
	}
}
