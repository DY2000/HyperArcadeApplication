package AliceDanPacman;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;
import willTetris.Collidable;

public class AliceGhost extends AnimatedComponent implements Collidable{
	
	//there are 4 main ghosts named blinky (red), pinky, clyde (orange), inky (blue)
	//scatter mode-each ghost has a predefined corner of the grid that they follow
	//The red ghost starts outside of the ghost house, and is usually the first one to be seen as a threat
	//http://gameinternals.com/post/2072558330/understanding-pac-man-ghost-behavior	
	//The pink ghost starts inside the ghost house, but always exits immediately, even in the first level. 
	//The blue ghost is nicknamed Inky, and remains inside the ghost house for a short time on the first level, 
	//not joining the chase until Pac-Man has managed to consume at least 30 of the dots. 
	//The orange ghost, “Clyde”, is the last to leave the ghost house, and does not exit 
	//at all in the first level until over a third of the dots have been eaten. 
	//The ghosts are always in one of three possible modes: Chase, Scatter, or Frightened. 
	//chase-normal mode with ghosts chasing pacman
	// While in Chase mode, all of the ghosts use Pac-Man’s position as a factor in selecting their target tile, 
	//though it is more significant to some ghosts than others.
	//Frightened mode is unique because the ghosts do not have a specific target tile while in this mode. 
	//A ghost in Frightened mode also turns dark blue, moves much more slowly and can be eaten by Pac-Man.
	
	//if ghost goes over dot, setvisible of dots to false
	
	

	public AliceGhost(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		ArrayList<String> ghosts = new ArrayList<String>();
		ArrayList<String> redGhost = new ArrayList<String>();
		ArrayList<String> blueGhost = new ArrayList<String>();
		ArrayList<String> orangeGhost = new ArrayList<String>();
		ArrayList<String>pinkGhost = new ArrayList<String>();


	;
		
		ArrayList<String> redArray = new ArrayList<String>();
		ArrayList<String> blue = new ArrayList<String>();
		ArrayList<String> pink = new ArrayList<String>();
		ArrayList<String> orange = new ArrayList<String>();
		
		//first is speed, then is location
			redArray.add(20);		
			redArray.add();	
			
			orangeArray.add(20);		
			orangeArray.add();	
			
			blueArray.add(20);		
			blueArray.add();	
			
			pinkArray.add(20);		
			pinkArray.add();	

		
		  ArrayList<ArrayList<AliceGhost>> ghost = new ArrayList<ArrayList<AliceGhost>>();
          AliceGhost.add(redGhost);
          AliceGhost.add(blueGhost);
          AliceGhost.add(pinkGhost);
          AliceGhost.add(orangeGhost);

		
	}

	

	public void initAllObjects(List<Visible> viewObjects) {
	//	PacmanBackground Image = new PacmanBackground(0,0,getWidth(),getHeight());
		//viewObjects.add(Image);
	}
	
	
}
