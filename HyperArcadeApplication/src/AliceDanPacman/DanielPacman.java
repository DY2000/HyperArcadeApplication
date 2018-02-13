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
	private BufferedImage img;
	private int gridY;
	private int gridX;
	private boolean canEatGhost;
	private int direction;
	// 0 = LEFT, 1 = UP, 2 = RIGHT, 3 = DOWN

	public DanielPacman(int x, int y, int w, int h, PacmanScreen game) {
		super(x, y, w, h);
		 this.game = game;
		 canEatGhost = false;
		 direction = 0;
		 gridX = 0;
		 gridY = 0;
		Thread t = new Thread(this);
		t.start();
	}
	public void drawImage(Graphics2D g) {
		if(direction == 0) {
			img = game.getPacLeft().getImage();
		}else if(direction == 1) {
			img = game.getPacUp().getImage();
		}else if(direction == 2) {
			img = game.getPacRight().getImage();
		}else if(direction == 3) {
			img = game.getPacDown().getImage();
		}
		if(img != null) {
			this.clear();
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
		}
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
		setX((30*gridX)+320);
		setY((30*gridY)+100);
	}
	
	public boolean canEatGhost() {
		return canEatGhost;
	}
	
	public void setGridX(int n) {
		this.gridX = n;
	}
	
	public void setGridY(int n) {
		this.gridY = n;
	}
	
	@Override
	public void moveLeft() {
		direction = 0;
		game.getMovementGrid().moveLeft(gridX,gridY);
	}
	@Override
	public void moveRight() {
		direction = 2;
		game.getMovementGrid().moveRight(gridX,gridY);
	}
	@Override
	public void moveUp() {
		direction = 1;
		game.getMovementGrid().moveUp(gridX,gridY);
	}
	@Override
	public void moveDown() {
		direction = 3;
		game.getMovementGrid().moveDown(gridX,gridY);
	}
	@Override
	public void moveStop() {
		//dsd
	}
}
