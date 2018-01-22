package markGalaga;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MarkGalaga extends FullFunctionScreen{
	
	String galagaSpriteSheet;
	AnimatedComponent bg1;
	MarkShip playerShip;
	ArrayList<MarkProjectile> playerShots;
	ArrayList<MarkMob> mobs;
	ArrayList<MarkProjectile> mobShots;
	Timer bgTimer;

	public MarkGalaga(int width, int height) {
		super(width, height);
		
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
			playerShots.add(i, new MarkProjectile(1030,400,9,16,"player"));
			playerShots.get(i).addSequence(galagaSpriteSheet, 1000, 374, 51, 3, 8, 1);
			viewObjects.add(playerShots.get(i));
		}
		
		for(int i = 0; i < 16; i++) {
			if(i < 4) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),100,40,42));
				mobs.get(i).addSequence(galagaSpriteSheet, 500, 161, 103, 15, 16, 2);
				viewObjects.add(mobs.get(i));
			}else if(i < 8) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),150,45,31));
				mobs.get(i).addSequence(galagaSpriteSheet, 500, 162, 154, 15, 10, 2);
				viewObjects.add(mobs.get(i));
			}else if(i < 12) {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),200,45,31));
				mobs.get(i).addSequence(galagaSpriteSheet, 500, 162, 154, 15, 10, 2);
				viewObjects.add(mobs.get(i));
			}else {
				mobs.add(i, new MarkMob((getWidth()/2)+(2*72)-((i%4)*72),250,45,34));
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
