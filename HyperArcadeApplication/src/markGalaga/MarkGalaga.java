package markGalaga;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	ArrayList<MarkProjectile> playerShots;
	ArrayList<MarkMob> mobs;
	ArrayList<MarkProjectile> mobShots;
	Timer bgTimer;

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
		
		playerShots = new ArrayList<MarkProjectile>();
		mobShots = new ArrayList<MarkProjectile>();
		mobs = new ArrayList<MarkMob>();
		
		for(int i = 0; i < 4; i++) {
			playerShots.add(i, new MarkProjectile(1030,400,9,16,this));
			playerShots.get(i).addSequence(galagaSpriteSheet, 1000, 374, 51, 3, 8, 1);
			viewObjects.add(playerShots.get(i));
		}
		
		for(int i = 0; i < 9; i++) {
			mobShots.add(i, new MarkProjectile(1030,300/2,9,16,this));
			mobShots.get(i).addSequence(galagaSpriteSheet, 1000, 366, 195, 3, 8, 1);
			viewObjects.add(mobShots.get(i));
		}
		
		for(int i = 0; i < 16; i++) {
			if(i < 4) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),100,40,42,"abductor",mobShots,game));
				mobs.get(i).addSequence(galagaSpriteSheet, 500, 161, 103, 15, 16, 2);
				viewObjects.add(mobs.get(i));
			}else if(i < 8) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),150,45,31,null,mobShots,game));
				mobs.get(i).addSequence(galagaSpriteSheet, 500, 162, 154, 15, 10, 2);
				viewObjects.add(mobs.get(i));
			}else if(i < 12) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),200,45,31,null,mobShots,game));
				mobs.get(i).addSequence(galagaSpriteSheet, 500, 162, 154, 15, 10, 2);
				viewObjects.add(mobs.get(i));
			}else {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),250,45,34,null,mobShots,game));
				mobs.get(i).addSequence(galagaSpriteSheet, 500, 162, 178, 15, 10, 2);
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
		
		playerShip = new MarkShip(getWidth()/2, 600, 48, 48, playerShots);
		playerShip.addSequence(galagaSpriteSheet, 1000, 184, 55, 15, 16, 1);
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
		
		for(MarkProjectile s : playerShots) {
			s.setDetection( new Action() {
				
				@Override
				public void act() {
					for(MarkMob m : game.getMobs()) {
						if(m.detectCollision(s)) {
							s.setVy(0);
							s.setVx(0);
							s.setY(300);
							s.setX(1030);
						}
					}
				}
			});
		}
	}

	public ArrayList<MarkMob> getMobs() {
		return mobs;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				playerShip.fireShot(playerShip.getShots(),playerShip.getX()+(playerShip.getWidth()/2)-(playerShots.get(0).getWidth()/2),playerShip.getY());
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
