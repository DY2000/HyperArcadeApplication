package AliceDanPacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import markGalaga.MarkPlayerMovement;

public class DanielPacman extends AnimatedComponent implements MarkPlayerMovement, AliceMethods {
	
	private boolean canEatGhost=false;

	public DanielPacman(int x, int y, int w, int h) {
		super(x, y, w, h);
		 
	}
	public void drawImage(Graphics2D g) {
		 g.setColor(Color.yellow);
		  g.fillArc(0,0,100,100,20,270);
	}
	public boolean ateBlue() {
		
		
		
		return false;
	}
	
	public void whenAtePowerup() {
		if(wentOverPowerUp()) {
		canEatGhost = true;
		}
		canEatGhost = false;
	}
	boolean wentOverPowerUp() {
		//if went over poweruplocation
		if() {
		return true;
		}
		else {
			
			return false;
		}
	}


}
