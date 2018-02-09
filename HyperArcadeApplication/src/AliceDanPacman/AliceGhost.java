package AliceDanPacman;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import willTetris.Collidable;

public class AliceGhost extends AnimatedComponent implements Collidable{
	static Thread counter = new Thread();
	public boolean canBeEaten = true;
	private Random r = new Random();
	
	private BufferedImage img;
	
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
	
	//if ghost goes over dot, setvisible of dots to false
	
	//arraylist of active and inactive ghost
	

	public AliceGhost(int x, int y, int w, int h, String ghostType, PacmanScreen screen3) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		img = new Graphic(x,y,1000,900,"resources/pink ghost.png").getImage();
		update();
		ArrayList<String> active = new ArrayList<String>();
		ArrayList<String> inactive = new ArrayList<String>();
		

		//first is speed, then is location
	
		
	}

	

	public void initAllObjects(List<Visible> viewObjects) {
//		ghost = new PacmanBackground(getX(),getY(),getWidth(),getHeight());
//		
		viewObjects.add(this);
//		ghost.setVisible(true);
		
		
	}
	
	public void drawImage(Graphics2D g) {
		if(img != null) {
			g.drawImage(img,getX(),getY(),null);
		}
	}

//	public void checkIfBlue() {
//		
//		while(isBlue()) {
//			canBeEaten=false;
//			
//		}
			
			//make a blue ghost
		//}
		
	 public void move(PacmanGrid grid) {
		 int x = grid.getWidth();
		 int y = grid.getHeight();
		 int nextX= r.nextInt(2)-1+getX();
		 int nextY = r.nextInt(2)-1+getY();
		 
		 if (nextX >0 && nextX <x) {
			 setX(nextX);
		 }
		 if (nextY >0 && nextY <y) {
			 setY(nextY);
		 }
		 
		 update();
	 }
		public final void whenBlue(PacmanGrid grid, DanielPacman pacman) {
			
			Thread timer = new Thread(new Runnable() {
				
				public void run() {
					
//					while(isBlue(pacman)) {
					while(true) {	
						try {
							move(grid);
							if (checkIfCanEatPackMan( pacman)) {
								System.out.println("Ate pacman !!!");
								return;
							}
							Thread.sleep(1000);
						}
						
						catch(Throwable e) {
							e.printStackTrace();
							
						}
					}
					
				}

				
				
			});
			timer.start();
		}
			
	
	protected  boolean checkIfCanEatPackMan(DanielPacman pacman) {
			if (pacman.getX() == getX() &&  pacman.getY() == getY()) {
				return true;
			}
			return false;
		}



	private boolean isBlue(DanielPacman pacman) {
		
		
		if(pacman.wentOverPowerUp()) {
			
			return true;
		}
		return false;
		//return DanielPacman.ateBlue();

	}
	
	private boolean wentOverDots() {
		
		return false;
		
	}
	
	
	
}
