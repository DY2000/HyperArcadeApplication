package AliceDanPacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import guiTeacher.components.AnimatedComponent;
import markGalaga.MarkDeathAnimation;
import markGalaga.MarkPlayerMovement;

public class DanielPacman extends MarkPlayerMovement implements AliceGhostInterface{
	
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
		direction = -1;
		gridX = 12;
		gridY = 22;
		setVisible(false);
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
		}else {
			BufferedImage temp;
			try {
				temp = ImageIO.read(new File("resources/Pacman_spriteSheet.png"));
				img = temp.getSubimage(36, 1, 13, 13);
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
	
	public void atePowerup() {
		canEatGhost = true;
		Timer cooldown = new Timer();
		cooldown.schedule(new TimerTask() {
			
			@Override
			public void run() {
				canEatGhost = false;
			}
		}, 8000);
	}

	public void checkBehaviors() {
		setX((17*gridX) +325 + 18);
		setY((17*gridY) +50  + 72);
		if(direction == 0)
			game.getGrid().moveLeft(gridX,gridY);
		else if(direction == 1)
			game.getGrid().moveUp(gridX,gridY);
		else if(direction == 2)
			game.getGrid().moveRight(gridX,gridY);
		else if(direction == 3)
			game.getGrid().moveDown(gridX,gridY);
		if(canEatGhost)
			try {
				Thread.sleep(125);
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
	

	public void death() {
			setVisible(false);
			direction = -1;
			Thread b = new Thread(new Runnable() {
				public void run() {
					DanDeathAnimation boom = new DanDeathAnimation(getX(),getY(),getWidth(),getHeight(),game);
					game.addObject(boom);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					game.remove(boom);
					game.pacRespawn();
				}
			});
			b.start();
		
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
	
	public int getGridX() {
		return gridX;
	}
	
	public int getGridY() {
		return gridY;
	}
	
	public void setDirection(int n) {
		direction = n;
	}

	public int getDirection() {
		return direction;
	}
	
	@Override
	public void moveLeft() {
		game.getGrid().moveLeft(gridX,gridY);
	}
	@Override
	public void moveRight() {
		game.getGrid().moveRight(gridX,gridY);
	}
	@Override
	public void moveUp() {
		game.getGrid().moveUp(gridX,gridY);
	}
	@Override
	public void moveDown() {
		game.getGrid().moveDown(gridX,gridY);
	}
	@Override
	public void moveStop() {
		//dsd
	}
	@Override
	public boolean wentOverPowerUp() {
		return false;
	}
	public void reset() {
		canEatGhost = false;
		direction = -1;
		gridX = 12;
		gridY = 22;
		setVisible(true);
	}
}
