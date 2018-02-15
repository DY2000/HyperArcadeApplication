package markGalaga;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;

public class MarkMob extends AnimatedComponent {
	
	private int hp;
	private int pos;
	private int idleX;
	private int idleY;
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
		attacking = true;
		enabled = false;
		countA = -135;
		countB = 0;
		this.pos = pos;
		idleX = game.getIdleCoods()[pos][0];
		idleY = game.getIdleCoods()[pos][1];
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
		}
		if(img != null) {
			this.clear();
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
		}
	}
	
	public synchronized void checkBehaviors() {
		if(hp == 0) {
			setVy(0);
			setVx(0);
			setVisible(false);
			enabled = false;
			if(!game.isSpawning() && !enabled && !isVisible()) {
				game.remove(this);
				game.getMobs().remove(this);
				setRunning(false);
			}
		}
		if(hp == 1 && mobType == "green") {
			mobType = "purple";
		}else if(!game.isSpawning() && !attacking && enabled) {
			if(countA/2 > 1) {
				countA--;
				if(countA%3==0)
				setX(getX()-1);
			}else if(countA/3 < -1) {
				countA++;
				if(countA%3==0)
				setX(getX()+1);
			}else if(countA - 1 < 0) {
				countA = 270;
			}else {
				countA = -270;
			}
		}
		if(!game.isSpawning() && enabled && Math.random() < .25) {
			attack();
		}
		if(attacking) {
			try {
				if(game.getShip().detectCollision(this) && isEnabled() && isVisible()) {
					game.getShip().shipHit();
					int newX = getX()-16;
					int newY = getY()-16;
					if(getHp() == 0) {
						Thread b = new Thread(new Runnable() {
							public void run() {
								MarkDeathAnimation boom = new MarkDeathAnimation(newX,newY,64,64,"mob",game);
								game.addObject(boom);
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								game.remove(boom);
							}
						});
						setVy(0);
						setVx(0);
						setY(300);
						setX(1030);
						b.start();
					}else {
						setVy(0);
						setVx(0);
						setY(300);
						setX(1030);
					}
					if(getY() > 764) {
						attacking = false;
						spawn(game.getStage());
					}
				}
			} catch (Exception e) {
					game.remove(this);
					game.getPlayerShots().clear();
					game.getPlayerShots().add(new MarkProjectile(1030,400,6,16,"player",game));
					game.getPlayerShots().add(new MarkProjectile(1030,400,6,16,"player",game));
					game.getPlayerShots().get(0).addSequence("resources/Galaga_spriteSheet.png", 1000, 374, 51, 3, 8, 1);
					game.getPlayerShots().get(1).addSequence("resources/Galaga_spriteSheet.png", 1000, 374, 51, 3, 8, 1);
					setRunning(false);
			}
		}
	}

	public void spawn(int stage) {
		/**
		 * This is going to very bloated and inelegant
		 * Mainly because I want to fit the original
		 * version of how everything spawns and this
		 * is my way of working. Its 'soft' hard coding
		 */
		//1 2 3 4 5 6 7 8 9 10
		//3 2 * 1 2 3 * 1 2 3
		int RIGHT = 750;
		int LEFT = 325;
		//Every spawn sequnce for each mob
		Thread g2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setX(idleX);
				setY(0-getHeight());
				for(int i = getHeight(); i != idleY; i++) {
					setY(i);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread g3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setY(idleY);
				if(pos < 2) {
					setX(RIGHT - getWidth());
					for(int i = RIGHT - getWidth(); i != idleX; i--) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					setX(LEFT);
					for(int i = LEFT; i != idleX; i++) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread r1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setY(idleY);
				if((pos-4)%8 < 4) {
					setX(RIGHT - getWidth());
					for(int i = RIGHT - getWidth(); i != idleX; i--) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					setX(LEFT);
					for(int i = LEFT; i != idleX; i++) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread r2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setX(idleX);
				setY(0-getHeight());
				for(int i = getHeight(); i != idleY; i++) {
					setY(i);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread r3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setY(idleY);
				if((pos-4)%8 > 3) {
					setX(RIGHT - getWidth());
					for(int i = RIGHT - getWidth(); i != idleX; i--) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					setX(LEFT);
					for(int i = LEFT; i != idleX; i++) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread b1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setY(idleY);
				if(pos%10 < 5) {
					setX(RIGHT - getWidth());
					for(int i = RIGHT - getWidth(); i != idleX; i--) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					setX(LEFT);
					for(int i = LEFT; i != idleX; i++) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread b2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setX(idleX);
				setY(0-getHeight());
				for(int i = getHeight(); i != idleY; i++) {
					setY(i);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread b3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				setY(idleY);
				if(pos%10 > 4) {
					setX(RIGHT - getWidth());
					for(int i = RIGHT - getWidth(); i != idleX; i--) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					setX(LEFT);
					for(int i = LEFT; i != idleX; i++) {
						setX(i);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		//AFTER I HAVE FINSIHED, I warn ye above there be dragons
		if(mobType == "green") {
			if(stage%2 == 0) {
				g3.start();
			}else {
				b2.start();
			}
		}
		if(mobType == "red") {
			if(stage%2 == 0) {
				r1.start();
			}else {
				r2.start();
			}
		}
		if(mobType == "blue") {
			if(stage%2 == 0) {
				b1.start();
			}else {
				b2.start();
			}
		}
		attacking = false;
		enabled = true;
	}
	
	public void goToPos(int x, int y) {
		countA = -135;
		setX(x);
		setY(y);
	}
	
	public void flyingAttack() {
		attacking = true;
		Thread at = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(attacking) {
					for(int i = 0; i < 75; i++) {
						setY(getY()+1);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for(int i = 0; i < 75; i++) {
						setX(getX()-1);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					attack();
					for(int i = 0; i < 75; i++) {
						setY(getY()+1);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for(int i = 0; i < 75; i++) {
						setX(getX()+1);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		at.start();
	}
	
	public void attack() {
		MarkShip ship = game.getShip();
		if(ship.isEnabled())
		for(int i = 0; i < getShots().size(); i++) {
			if(getShots().get(i).getVy() == 0) {
				int playerX = ship.getX() + ship.getWidth()/2;
				int playerY = ship.getY() + ship.getHeight()/2;
				int time = (getY() - playerY)/6;
				if(time == 0) time = 1;
				getShots().get(i).setY(getY());
				getShots().get(i).setX((getX()+getWidth()/2)-(getShots().get(i).getWidth()/2));
				getShots().get(i).setVy(6);
				getShots().get(i).setVx((getX() - playerX)/time);
				break;
			}
		}
	}

	public boolean detectCollision(MarkProjectile shot) {
		if((shot.getX() < getX() + getWidth() && shot.getX() + shot.getWidth() > getX() &&
			shot.getY() < getY() + getHeight() && shot.getHeight() + shot.getY() > getY())){
			if(hp != 0)hp--;
			return true; 
		}else{
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
	
	public void setHp(int n) {
		this.hp = n;
	}
	
	public int getPos() {
		return pos;
	}
	
	public void setAttacking(boolean b) {
		this.attacking = b;
	}
	
	public boolean isAttacking() {
		return attacking;
	}

	public void setEnabled(boolean b) {
		this.enabled = b;
	}

	public boolean isEnabled() {
		return enabled;
	}

	
}
