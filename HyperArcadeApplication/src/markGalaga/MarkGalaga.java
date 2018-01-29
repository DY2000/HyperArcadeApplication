package markGalaga;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MarkGalaga extends FullFunctionScreen{
	
	private String galagaSpriteSheet;
	private AnimatedComponent background;
	private TextArea labelBox;
	private TextArea scoreBox;
	private TextArea lifeBox;
	private MarkGalaga game;
	private MarkShip playerShip;
	private ArrayList<MarkProjectile> playerShots1;
	private ArrayList<MarkMob> mobs;
	private ArrayList<MarkProjectile> mobShots;
	private int shotsFired;
	private int shotsHit;
	private int score;
	private int highscore;
	private int lives;
	private boolean spawning;

	public MarkGalaga(int width, int height) {
		super(width, height);
		score = 0;
		highscore = 10000;
		lives = 3;
		spawning = false;
	}

	public boolean getSpawning() {
		return spawning;
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		background = new GalagaBackground(325, -764, 425,getHeight()*2);
		viewObjects.add(background);
		
		setBackground(Color.DARK_GRAY);
		
		galagaSpriteSheet = "resources/Galaga_spriteSheet.png";
		
		playerShots1 = new ArrayList<MarkProjectile>();
		mobShots = new ArrayList<MarkProjectile>();
		mobs = new ArrayList<MarkMob>();
		
		for(int i = 0; i < 2; i++) {
			playerShots1.add(i, new MarkProjectile(1030,400,6,16,"player",this));
			playerShots1.get(i).addSequence(galagaSpriteSheet, 1000, 374, 51, 3, 8, 1);
			viewObjects.add(playerShots1.get(i));
		}
		
		for(int i = 0; i < 4; i++) {
			mobShots.add(i, new MarkProjectile(1030,300/2,6,16,"mob",this));
			mobShots.get(i).addSequence(galagaSpriteSheet, 1000, 366, 195, 3, 8, 1);
			viewObjects.add(mobShots.get(i));
		}
		
		for(int i = 0; i < 40; i++) {
			if(i < 4) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*32)-((i%4)*32),100,30,32,"abductor2",mobShots,i,game));
				viewObjects.add(mobs.get(i));
			}else if(i < 12) {
				mobs.add(i, new MarkMob((getWidth()/2)+(4*32)-((i%8)*32),134,30,20,"red",mobShots,i,game));
				viewObjects.add(mobs.get(i));
			}else if(i < 20) {
				mobs.add(i, new MarkMob((getWidth()/2)+(4*32)-((i%8)*32),168,30,20,"red",mobShots,i,game));
				viewObjects.add(mobs.get(i));
			}else if(i < 30) {
				mobs.add(i, new MarkMob((getWidth()/2)+(5*32)-((i%10)*32),202,26,20,"morpher",mobShots,i,game));
				viewObjects.add(mobs.get(i));
			}else if(i < 40) {
				mobs.add(i, new MarkMob((getWidth()/2)+(5*32)-((i%10)*32),236,26,20,"morpher",mobShots,i,game));
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
					if(playerShip.detectCollision(s)) {
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
							int newX = m.getX();
							int newY = m.getY();
							shotsHit++;
							if(m.getHp() == 0) {
								Thread b = new Thread(new Runnable() {
									
									@Override
									public void run() {
										DeathAnimation boom = new DeathAnimation(newX,newY,32,32,game);
										addObject(boom);
										try {
											Thread.sleep(500);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										remove(boom);
									}
								});
								updateScore(m);
								s.setVy(0);
								s.setVx(0);
								s.setY(300);
								s.setX(1030);
								b.start();
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
						int playerX = playerShip.getX() + playerShip.getWidth()/2;
						int playerY = playerShip.getY() + playerShip.getHeight()/2;
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
						playerX = playerShip.getX();
						playerY = playerShip.getY();
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
			
			labelBox = new TextArea(325, 10, 425, 40,"    1UP                                    HIGH SCORE");
			labelBox.setTextColor(Color.WHITE);
			update();
			viewObjects.add(labelBox);
			
			scoreBox = new TextArea(325, 24, 425, 40,"");
			scoreBox.setTextColor(Color.RED);
			update();
			viewObjects.add(scoreBox);
			
		}
	}

	public void updateScore(MarkMob m) {
		if(m.getType() == "red") {
			if(m.isAttacking()) {
				score = score + 160;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                          "+highscore);
				update();
			}else {
				score = score + 80;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                          "+highscore);
				update();
			}
		}else if ( m.getType() == "morpher") {
			if(m.isAttacking()) {
				score = score + 100;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                          "+highscore);
				update();
			}else {
				score = score + 50;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                          "+highscore);
				update();
			}
		}else if ( m.getType() == "abductor") {
			if(m.isAttacking()) {
				score = score + 400;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                          "+highscore);
				update();
			}else {
				score = score + 200;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                          "+highscore);
				update();
			}
		}else {
			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				shotsFired++;
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
	
	public int getScore() {
		return score;
	}
	
}
