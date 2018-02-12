package AliceDanPacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Timer;

import guiTeacher.components.AnimatedComponent;
import markGalaga.MarkPlayerMovement;
import willTetris.Collidable;

public class DanielPacman extends MarkPlayerMovement{
	
	private PacmanScreen game;
	private boolean canEatGhost;
	private int direction;
	// 0 = LEFT, 1 = UP, 2 = RIGHT, 3 = DOWN

	public DanielPacman(int x, int y, int w, int h, PacmanScreen game) {
		super(x, y, w, h);
		 this.game = game;
		 canEatGhost = false;
	}
	public void drawImage(Graphics2D g) {
		
	}
	
	public boolean ateBlue() {
		return false;
	}
	
	public void whenAtePowerup() {
		canEatGhost = true;
		Timer cooldown = new Timer();
	}
	boolean wentOverPowerUp() {
		//if went over poweruplocation
//      if() {
//        return true;
//      }	else {
//        return false;
//      }
		return false;
	}

	public void checkBehaviors() {
		// calls on all the time
		
	}
	
	public boolean canEatGhost() {
		return canEatGhost;
	}
	
	@Override
	public void moveLeft() {
		direction = 0;
		
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
