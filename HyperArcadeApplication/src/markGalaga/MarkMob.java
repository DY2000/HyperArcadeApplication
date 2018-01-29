package markGalaga;

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
	private Action attack;
	
	public MarkMob(int x, int y, int w, int h, String mobType,ArrayList<MarkProjectile> arl, int pos, MarkGalaga game) {
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
		this.pos = pos;
		update();
		Thread t = new Thread(this);
		t.start();
	}

	private void setShots(ArrayList<MarkProjectile> arl) {
		this.mobShots = arl;
	}

	public synchronized void checkBehaviors() {
		if(hp == 0) {
			enabled = false;
			setVy(0);
			setX(1150);
			setY(25);
			
		}
		if(enabled && !attacking) {
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
			//This is gonna be ugly
			if(countB/3 > 1) {
				countB--;
				if(pos < 4) {
					if(countB%30 == 0) {
						setY(getY()+1);
					}
					if(countB%30 == 0) {
						if(pos < 2) {
							setX(getX()+1);
							if(pos%2 == 0) setX(getX()+1);
						}else{
							setX(getX()-1);
							if(pos%2 == 1) setX(getX()-1);
						}
					}
				}else if(pos < 12) {
					if(countB%20 == 0) {
						setY(getY()+1);
					}
					if(countB%25 == 0) {
						if(pos < 8) {
							setX(getX()-1);
							if(pos%8 > 4) setX(getX()-1);
						}else {
							setX(getX()+1);
							if(pos%8 < 3) setX(getX()+1);
						}
					}
				}else if(pos < 20) {
					if(countB%15 == 0) {
						setY(getY()+1);
					}
					if(countB%20 == 0) {
						if(pos < 16) {
							setX(getX()-1);
						}else {
							setX(getX()+1);
						}
					}
				}else if(pos < 30) {
					if(countB%12 == 0) {
						setY(getY()+1);
					}
					if(countB%15 == 0) {
						if(pos < 25) {
							setX(getX()+1);
						}else {
							setX(getX()-1);
						}
					}
				}else if(pos < 40) {
					if(countB%10 == 0) {
						setY(getY()+1);
					}
					if(countB%12 == 0) {
						if(pos < 35) {
							setX(getX()+1);
						}else {
							setX(getX()-1);
						}
					}
				}
			}else if(countB/3 < -1){
				countB++;
				if(pos < 4) {
					if(countB%30 == 0) {
						setY(getY()-1);
					}
					if(countB%30 == 0) {
						if(pos < 2) {
							setX(getX()-1);
							if(pos%2 == 0) setX(getX()-1);
						}else{
							setX(getX()+1);
							if(pos%2 == 1) setX(getX()+1);
						}
					}
				}else if(pos < 12) {
					if(countB%20 == 0) {
						setY(getY()-1);
					}
					if(countB%25 == 0) {
						if(pos < 8) {
							setX(getX()+1);
							if(pos%8 > 4) setX(getX()+1);
						}else {
							setX(getX()-1);
							if(pos%8 < 3) setX(getX()-1);
						}
					}
				}else if(pos < 20) {
					if(countB%15 == 0) {
						setY(getY()-1);
					}
					if(countB%20 == 0) {
						if(pos < 16) {
							setX(getX()+1);
						}else {
							setX(getX()-1);
						}
					}
				}else if(pos < 30) {
					if(countB%12 == 0) {
						setY(getY()-1);
					}
					if(countB%15 == 0) {
						if(pos < 25) {
							setX(getX()-1);
						}else {
							setX(getX()+1);
						}
					}
				}else if(pos < 40) {
					if(countB%10 == 0) {
						setY(getY()-1);
					}
					if(countB%12 == 0) {
						if(pos < 35) {
							setX(getX()-1);
						}else {
							setX(getX()+1);
						}
					}
				}
			}else {
				if(countB - 1 < 0) {
					countB = 300;
				}else {
						countB = -300;
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
	
	public boolean isAttacking() {
		return attacking;
	}
	
	public void setAttack(Action a) {
		this.attack = a;
	}
}
