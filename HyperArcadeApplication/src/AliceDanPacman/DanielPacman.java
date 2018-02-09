package AliceDanPacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import markGalaga.MarkPlayerMovement;
import willTetris.Collidable;

public class DanielPacman extends MarkPlayerMovement implements Collidable{
	
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
      if(true) {
        return true;
      }	else {
        return false;
      }
	}

	public void checkBehaviors() {
		// calls on all the time
		
	}
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveStop() {
		// TODO Auto-generated method stub
		
	}
}
