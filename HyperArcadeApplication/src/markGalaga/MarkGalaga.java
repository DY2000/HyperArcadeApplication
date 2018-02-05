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
import markGalaga.GalagaBackground;

public class MarkGalaga extends FullFunctionScreen{
	
	private String galagaSpriteSheet;
	private GalagaBackground background;
	private TextArea labelBox;
	private TextArea scoreBox;
	private TextArea lifeBox;
	private TextArea player1Box;
	private TextArea stageBox;
	private MarkGalaga game;
	private MarkShip playerShip;
	private ArrayList<MarkProjectile> playerShots;
	private ArrayList<MarkProjectile> mobShots;
	private MarkAlphaGreen alphaGreen;
	private MarkAlphaPurple alphaPurple;
	private MarkAlphaRed alphaRed;
	private MarkAlphaBlue alphaBlue;
	private ArrayList<MarkMob> mobs;
	private int shotsFired;
	private int hits;
	private int score;
	private int highscore;
	private int lives;
	private int stage;
	private boolean spawning;
	private boolean running;
	
	
	public MarkGalaga(int width, int height) {
		super(width, height);
		this.score = 0;
		this.highscore = 10000;
		this.lives = 3;
		this.spawning = false;
		this.running = false;
	}

	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		background = new GalagaBackground(325, -764, 425,getHeight()*2, true);
		viewObjects.add(background);
		
		setBackground(Color.DARK_GRAY);
		
		galagaSpriteSheet = "resources/Galaga_spriteSheet.png";
		
		playerShots = new ArrayList<MarkProjectile>();
		mobShots = new ArrayList<MarkProjectile>();
		
		alphaGreen = new MarkAlphaGreen(1030,600,15,16,this);
		alphaPurple = new MarkAlphaPurple(1030,620,15,16,this);
		alphaRed = new MarkAlphaRed(1030,640,13,10,this);
		alphaBlue = new MarkAlphaBlue(1030,660,13,10,this);
		
		mobs = new ArrayList<MarkMob>();
		
		playerShip = new MarkShip(getWidth()/2 + 16, 600, 32, 32, this);
		viewObjects.add(playerShip);
		
		for(int i = 0; i < 2; i++) {
			playerShots.add(i, new MarkProjectile(1030,400,6,16,"player",this));
			playerShots.get(i).addSequence(galagaSpriteSheet, 1000, 374, 51, 3, 8, 1);
			viewObjects.add(playerShots.get(i));
		}
		
		for(int i = 0; i < 2; i++) {
			mobShots.add(i, new MarkProjectile(1030,300/2,6,16,"mob",this));
			mobShots.get(i).addSequence(galagaSpriteSheet, 1000, 366, 195, 3, 8, 1);
			viewObjects.add(mobShots.get(i));
		}
		
		for(int i = 0; i < 40; i++) {
			if(i < 4) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*32)-((i%4)*32),100,30,32,"green",i,this));
				viewObjects.add(mobs.get(i));
			}else if(i < 12) {uk
				mobs.add(i, new MarkMob((getWidth()/2)+(4*32)-((i%8)*32),134,30,20,"red",i,this));
				viewObjects.add(mobs.get(i));
			}else if(i < 20) {
				mobs.add(i, new MarkMob((getWidth()/2)+(4*32)-((i%8)*32),168,30,20,"red",i,this));
				viewObjects.add(mobs.get(i));
			}else if(i < 30) {
				mobs.add(i, new MarkMob((getWidth()/2)+(5*32)-((i%10)*32),202,26,20,"blue",i,this));
				viewObjects.add(mobs.get(i));
			}else if(i < 40) {
				mobs.add(i, new MarkMob((getWidth()/2)+(5*32)-((i%10)*32),236,26,20,"blue",i,this));
				viewObjects.add(mobs.get(i));
			}
		}
		
		labelBox.setTextColor(Color.RED);
		labelBox = new TextArea(325, 10, 425, 40,"    1UP                                    HIGH SCORE");
		labelBox.setSize(25);
		viewObjects.add(labelBox);
		
		scoreBox.setTextColor(Color.WHITE);
		scoreBox = new TextArea(325, 30, 425, 40,"");
		scoreBox.setSize(25);
		viewObjects.add(scoreBox);
		
		updateScore(null);
	}
	
	private void startGame() {
		Thread intro = new Thread(new Runnable() {
			
			@Override
			public void run() {
				background.setEnabled(false);
				player1Box.setTextColor(Color.CYAN);
				player1Box = new TextArea(getWidth()/2-20, getHeight()/2, 200, 40, "PLAYER 1");
				player1Box.setSize(32);
				addObject(player1Box);
				for(int i = 0; i < 9; i++) {
					player1Box.setVisible(!player1Box.isVisible());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				stage = 1;
				stageBox = new TextArea(getWidth()/2-20, getHeight()/2, 200, 40, "STAGE "+stage);
				stageBox.setSize(32);
				addObject(stageBox);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				background.setEnabled(true);
				player1Box.setY(player1Box.getY()-25);
				player1Box.setVisible(true);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				player1Box.setVisible(false);
				stageBox.setVisible(false);
			}
		});
		intro.start();
		
		
	}
	
	public void gameOver() {
		System.out.print("Ship goes boom");
	}

	public void updateScore(MarkMob m) {
		if(m == null) {
			score = 0;
			highscore = 10000;
				scoreBox.setText("        "+score+"0                                          "+highscore);
			update();
		}else if(m.getType() == "red") {
			if(m.isAttacking()) {
				score = score + 160;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                           "+highscore);
				update();
			}else {
				score = score + 80;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                           "+highscore);
				update();
			}
		}else if ( m.getType() == "blue") {
			if(m.isAttacking()) {
				score = score + 100;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                           "+highscore);
				update();
			}else {
				score = score + 50;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                           "+highscore);
				update();
			}
		}else if ( m.getType() == "purple") {
			if(m.isAttacking()) {
				score = score + 400;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                           "+highscore);
				update();
			}else {
				score = score + 200;
				if( score >= highscore)
					highscore = score;
				scoreBox.clear();
				update();
				scoreBox.setText("        "+score+"                                           "+highscore);
				update();
			}
		}
	}
	
	

	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				if(playerShip.isEnabled()) {
					shotsFired++;
					playerShip.fireShot(playerShots,playerShip.getX()+(playerShip.getWidth()/2)-(playerShots.get(0).getWidth()/2),playerShip.getY());
					break;
				}
			case KeyEvent.VK_LEFT :
				if(playerShip.isEnabled())
					playerShip.moveLeft();
				break;
			case KeyEvent.VK_RIGHT : 
				if(playerShip.isEnabled())
					playerShip.moveRight();
				break;
			case KeyEvent.VK_ENTER : 
//				if(playerShip == null)
					startGame();
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

	
	public int getScore() {
		return score;
	}
	
	public MarkShip getShip() {
		return playerShip;
	}
	
	public void setShip(MarkShip o) {
		playerShip = o;
	}
	
	public ArrayList<MarkMob> getMobs(){
		return mobs;
	}
	
	public ArrayList<MarkProjectile> getMobShots() {
		return mobShots;
	}
	
	public ArrayList<MarkProjectile> getPlayerShots() {
		return playerShots;
	}
	
	public MarkAlphaGreen getAlphaGreen() {
		return alphaGreen;
	}
	
	public MarkAlphaPurple getAlphaPurple() {
		return alphaPurple;
	}
	
	public MarkAlphaRed getAlphaRed() {
		return alphaRed;
	}

	public MarkAlphaBlue getAlphaBlue() {
		return alphaBlue;
	}
	
	public boolean isSpawning() {
		return spawning;
	}
	
	public void setHits(int n) {
		this.hits = n;
	}
	
	public int getHits() {
		return hits;
	}


	
}
