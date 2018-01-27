package markGalaga;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import willTetris.Collidable;

public class MarkMob extends AnimatedComponent implements Collidable{
	
	private int hp;
	private int countA;
	private int countB;
	private boolean enabled;
	private boolean attacking;
	private String mobType;
	private ArrayList<MarkProjectile> mobShots;
	private MarkGalaga game;
	private Action attack;
	
	public MarkMob(int x, int y, int w, int h, String mobType,ArrayList<MarkProjectile> arl, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		setShots(arl);
		String galagaSpriteSheet = "resources/Galaga_spriteSheet.png";
		if(mobType == "abductor") {
			this.addSequence(galagaSpriteSheet, 1000, 161, 103, 15, 16, 2);
			hp = 2;
		}
		if(mobType == "red") {
			this.addSequence(galagaSpriteSheet, 1000, 162, 154, 15, 10, 2);
			hp = 1;
		}
		if(mobType == "morpher") {
			this.addSequence(galagaSpriteSheet, 1000, 162, 178, 13, 10, 2);
			hp = 1;
		}
		this.attack = null;
		this.mobType = mobType;
		this.game = game;
		attacking = true;
		enabled = true;
		countA = -135;
		countB = 0;
		update();
		Thread t = new Thread(this);
		t.start();
	}

	private void setShots(ArrayList<MarkProjectile> arl) {
		this.mobShots = arl;
	}

	public synchronized void checkBehaviors() {
		if(enabled && !attacking) {
			if(hp == 0) {
				enabled = false;
				setVy(0);
				setX(1150);
				setY(25);
				
			}
			if(countA/3 > 1) {
				countA--;
				if(countA%3 == 0) {
					setX(getX()-1);
				}
			}else if(countA/3 < -1){
				countA++;
				if(countA%3 == 0) {
					setX(getX()+1);
				}
			}else {
				if(countA - 1 < 0) {
					countA = 300;
				}else {
					countA = -300;
				}
			}
		}else if(countA == -135) {
			if(hp == 0) {
				enabled = false;
				setVy(0);
				setX(1150);
				setY(25);
			}
			if(countB/3 > 1) {
				countB--;
				if(countB%3 == 0) {
					setY(getY()-1);
				}
			}else if(countB/3 < -1){
				countB++;
				if(countB%3 == 0) {
					setY(getY()+1);
				}
			}else {
				if(countB - 1 < 0) {
					countB = 60;
				}else {
					countB = -60;
				}
			}
		}
	}

	private void flyingAttack(int x, int y, String mobType) {
		attack();
	}
	
	private void attack() {
			this.act();
	}

	public void act() {
		if(this.attack != null) {
			attack.act();
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
	
	public void setAttack(Action a) {
		this.attack = a;
	}
}
