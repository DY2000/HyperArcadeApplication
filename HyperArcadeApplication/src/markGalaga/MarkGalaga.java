package markGalaga;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MarkGalaga extends FullFunctionScreen{
	
	String galagaSpriteSheet;
	AnimatedComponent bg1;
	MarkGalaga game;
	MarkShip playerShip;
	ArrayList<MarkProjectile> playerShots1;
	ArrayList<MarkMob> mobs;
	ArrayList<MarkProjectile> mobShots;
	int lives;

	public MarkGalaga(int width, int height) {
		super(width, height);
		game = this;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		bg1 = new GalagaBackground(0, 0, getWidth(),1528);
		bg1.addSequence("resources/Galaga_bg.jpeg", 1000, 0, 0, getWidth(), 1528, 1);
		bg1.setY(-764);
		viewObjects.add(bg1);
		
		galagaSpriteSheet = "resources/Galaga_spriteSheet.png";
		
		playerShots1 = new ArrayList<MarkProjectile>();
		mobShots = new ArrayList<MarkProjectile>();
		mobs = new ArrayList<MarkMob>();
		
		for(int i = 0; i < 2; i++) {
			playerShots1.add(i, new MarkProjectile(1030,400,6,16,this));
			playerShots1.get(i).addSequence(galagaSpriteSheet, 1000, 374, 51, 3, 8, 1);
			viewObjects.add(playerShots1.get(i));
		}
		
		for(int i = 0; i < 4; i++) {
			mobShots.add(i, new MarkProjectile(1030,300/2,6,16,this));
			mobShots.get(i).addSequence(galagaSpriteSheet, 1000, 366, 195, 3, 8, 1);
			viewObjects.add(mobShots.get(i));
		}
		
		for(int i = 0; i < 40; i++) {
			if(i < 4) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*32)-((i%4)*32),100,30,32,"abductor",mobShots));
				viewObjects.add(mobs.get(i));
			}else if(i < 12) {
				mobs.add(i, new MarkMob((getWidth()/2)+(4*32)-((i%8)*32),134,30,20,"red",mobShots));
				viewObjects.add(mobs.get(i));
			}else if(i < 20) {
				mobs.add(i, new MarkMob((getWidth()/2)+(4*32)-((i%8)*32),168,30,20,"red",mobShots));
				viewObjects.add(mobs.get(i));
			}else if(i < 30) {
				mobs.add(i, new MarkMob((getWidth()/2)+(5*32)-((i%10)*32),202,26,20,"morpher",mobShots));
				viewObjects.add(mobs.get(i));
			}else if(i < 40) {
				mobs.add(i, new MarkMob((getWidth()/2)+(5*32)-((i%10)*32),236,26,20,"morpher",mobShots));
				viewObjects.add(mobs.get(i));
			}
			
		}
		
		mobShots = new ArrayList<MarkProjectile>();
		for(int i = 0; i < mobs.size(); i++) {
			mobShots.addAll(mobs.get(i).getShots());
		}
		
		for(int i = 0; i< mobShots.size(); i++) {
			mobShots.get(i).addSequence(galagaSpriteSheet, 1000, 366, 195, 3, 8, 1);
			viewObjects.add(mobShots.get(i));
		}
		
		playerShip = new MarkShip(getWidth()/2, 600, 32, 32, playerShots1);
		viewObjects.add(playerShip);
		
		for(MarkProjectile s : mobShots) {
			s.setDetection( new Action() {
				
				@Override
				public void act() {
					if(game.playerShip.detectCollision(s)) {
						s.setVy(0);
						s.setVx(0);
						s.setY(400);
						s.setX(1030);
					};
				}
			});
		}
		
		for(MarkProjectile s : playerShots1) {
			s.setDetection( new Action() {
				
				@Override
				public void act() {
					for(MarkMob m : mobs) {
						if(m.detectCollision(s)) {
							if(m.getHp() == 0) {
								DeathAnimation boom = new DeathAnimation(m.getX(),m.getY(),32,32);
								addObject(boom);
								s.setVy(0);
								s.setVx(0);
								s.setY(300);
								s.setX(1030);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								remove(boom);
								boom = null;
							}else {
								s.setVy(0);
								s.setVx(0);
								s.setY(300);
								s.setX(1030);
							}
						}
					}
				}
			});
		}
		
		for(MarkMob m : mobs) {
			m.setAttack( new Action() {
				
				@Override
				public void act() {
					if(m.getShots().get(3).getVy() == 0) {
						int playerX = game.playerShip.getX() + game.playerShip.getWidth()/2;
						int playerY = game.playerShip.getY() + game.playerShip.getHeight()/2;
						int time = (m.getY() - playerY)/5;
						m.getShots().get(0).setY(m.getY());
						m.getShots().get(0).setX((m.getX()+m.getWidth()/2)-(m.getShots().get(0).getWidth()/2));
						m.getShots().get(0).setVy(5);
						m.getShots().get(0).setVx((m.getX() - playerX)/time);
						if(m.getShots().get(0).getVx() > 5) {
							m.getShots().get(0).setVx(5);
						}
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						playerX = game.playerShip.getX();
						playerY = game.playerShip.getY();
						time = (m.getY() - playerY)/5;
						m.getShots().get(1).setY(m.getY());
						m.getShots().get(1).setX((m.getX()+m.getWidth()/2)-(m.getShots().get(0).getWidth()/2));
						m.getShots().get(1).setVy(5);
						m.getShots().get(1).setVx((m.getX() - playerX)/time);
						if(m.getShots().get(1).getVx() > 5) {
							m.getShots().get(1).setVx(5);
						}
					}
				}
			});
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				playerShip.fireShot(playerShip.getShots(),playerShip.getX()+(playerShip.getWidth()/2)-(playerShots1.get(0).getWidth()/2),playerShip.getY());
				break;
			case KeyEvent.VK_LEFT :
					playerShip.moveLeft();
				break;
			case KeyEvent.VK_RIGHT : 
					playerShip.moveRight();
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				if(playerShip.getVx() < 0)
					playerShip.moveStop();
				else break;
			case KeyEvent.VK_RIGHT : 
				if(playerShip.getVx() > 0)
					playerShip.moveStop();
				else break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
