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
	private Thread t;
	
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
		if(enabled && !attacking) {
			if(mobType == "green") {
				img = game.getAlphaGreen().getImage();
			}else if(mobType == "purple") {
				img = game.getAlphaPurple().getImage();
			}else if(mobType == "red") {
				img = game.getAlphaRed().getImage();
			}else if(mobType == "blue") {
				img = game.getAlphaBlue().getImage();
			}
		}else if(!enabled || attacking){
			super.drawImage(g);
		}
		if(img != null) {
			this.clear();
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
		}
	}
	
	public synchronized void checkBehaviors() {
		if(hp == 0) {
			game.remove(this);
			game.getMobs().remove(this);
			this.setRunning(false);
		}
		if(hp == 1 && mobType == "green") {
			mobType = "purple";
		}
		if(!game.isSpawning() && !attacking) {
			
		}else if(countA == -135) {
			
		}
		if(Math.random() < .25 && enabled)
			if(game.getShip() != null)
				flyingAttack();
	}

	public void spawn(int stage) {
		/**
		 * This is going to very bloated and inelegant
		 * Mainly because I want to fit the original
		 * version of how everything spawns and this
		 * is my way of working. Its 'soft' hard coding
		 */
		//1 2 3 4 5 6 7 8 9 10
		//1 2 * 1 2 3 * 1 2 3
		if(mobType == "green") {
			if(stage == 1 || stage%4== 0) {
				
			}else if(stage == 2 || stage%4 == 1) {
				
			}else if(stage%4 == 2) {
				
			}else {
				/**
				 * This will contain spawn sequence for challenge stages
				 */
			}
		}
		if(mobType == "red") {
			if(stage == 1 || stage%4== 0) {
				//Because of how sequences are created I will manually add them to the sprite sheet as needed
			}else if(stage == 2 || stage%4 == 1) {
				
			}else if(stage%4 == 2) {
				
			}else {
				/**
				 * This will contain spawn sequence for challenge stages
				 */
			}
		}
		if(mobType == "blue") {
			if(stage == 1 || stage%4== 0) {
				
			}else if(stage == 2 || stage%4 == 1) {
				
			}else if(stage%4 == 2) {
				
			}else {
				/**
				 * This will contain spawn sequence for challenge stages
				 */
			}
		}
	}
	
	private void flyingAttack() {
		int startX = getX();
		int startY = getY();
		attack();
	}
	
	private void attack() {
		MarkShip ship = game.getShip();
		if(ship.isEnabled())
		for(int i = 0; i < getShots().size(); i++) {
			if(getShots().get(i).getVy() == 0) {
				int playerX = ship.getX() + ship.getWidth()/2;
				int playerY = ship.getY() + ship.getHeight()/2;
				int time = (getY() - playerY)/6;
				getShots().get(i).setY(getY());
				getShots().get(i).setX((getX()+getWidth()/2)-(getShots().get(i).getWidth()/2));
				getShots().get(i).setVy(6);
				getShots().get(i).setVx(((getX() - playerX)/time));
				break;
			}
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
