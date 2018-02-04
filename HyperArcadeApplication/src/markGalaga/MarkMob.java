package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import willTetris.Collidable;

public class MarkMob extends AnimatedComponent implements Collidable{
	
	private int hp;
	private int pos;
	private int countA;
	private int countB;
	private boolean enabled;
	private boolean attacking;
	private String mobType;
	private ArrayList<MarkProjectile> mobShots;
	private MarkGalaga game;
	private BufferedImage img;
	
	public MarkMob(int x, int y, int w, int h, String mobType, int pos, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		mobShots = game.getMobShots();
		if(mobType == "green") {
			hp = 2;
		}
		if(mobType == "red") {
			hp = 1;
		}
		if(mobType == "blue") {
			hp = 1;
		}
		this.mobType = mobType;
		this.game = game;
		attacking = false;
		enabled = true;
		countA = -135;
		countB = 0;
		this.pos = pos;
		update();
		Thread t = new Thread(this);
		t.start();
	}

	private void setShots(ArrayList<MarkProjectile> arl) {
		this.mobShots = arl;
	}

	public void drawImage(Graphics2D g) {
		if(mobType == "green") {
			img = game.getAlphaGreen().getImage();
		}else if(mobType == "purple") {
			img = game.getAlphaPurple().getImage();
		}else if(mobType == "red") {
			img = game.getAlphaRed().getImage();
		}else if(mobType == "blue") {
			img = game.getAlphaBlue().getImage();
		}
		if(img != null) {
			this.clear();
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
		}
	}
	
	public synchronized void checkBehaviors() {
		if(hp == 0) {
			enabled = false;
//			game.remove(this);
//			game.getMobs().remove(this);
			setVy(0);
			setX(1150);
			setY(25);
		}
		if(hp == 1 && mobType == "green") {
			mobType = "purple";
		}
		if(enabled && !attacking) {
			
		}else if(countA == -135) {
			
		}
		if(Math.random() < .0005 && enabled)
			this.attack();
	}

	private void flyingAttack(int x, int y, String mobType) {
		attack();
	}
	
	private void attack() {
		MarkShip ship = game.getShip();
		if(getShots().get(0).getVy() == 0) {
			int playerX = ship.getX() + ship.getWidth()/2;
			int playerY = ship.getY() + ship.getHeight()/2;
			int time = (getY() - playerY)/6;
			getShots().get(0).setY(getY());
			getShots().get(0).setX((getX()+getWidth()/2)-(getShots().get(0).getWidth()/2));
			getShots().get(0).setVy(6);
			getShots().get(0).setVx(((getX() - playerX)/time));
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			playerX = ship.getX();
			playerY = ship.getY();
			time = (getY() - playerY)/6;
			getShots().get(1).setY(getY());
			getShots().get(1).setX((getX()+getWidth()/2)-(getShots().get(0).getWidth()/2));
			getShots().get(1).setVy(6);
			getShots().get(1).setVx(((getX() - playerX)/time));
		}
	}

	public boolean detectCollision(MarkProjectile shot) {
		if((shot.getX() < getX() + getWidth() && shot.getX() + shot.getWidth() > getX() &&
			shot.getY() < getY() + getHeight() && shot.getHeight() + shot.getY() > getY())){
			hp--;
			return true; 
		}
		else{
			return false; 
		}
	}
	
	
	
	public ArrayList<MarkProjectile> getShots(){
		return mobShots;
	}
	
	public String getType() {
		return mobType;
	}
	
	public int getHp() {
		return hp;
	}
	
	public boolean isAttacking() {
		return attacking;
	}
}
