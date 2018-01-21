package markGalaga;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MarkGalaga extends FullFunctionScreen{
	
	String galagaSpriteSheet;
	AnimatedComponent bg1;
	AnimatedComponent bg2;
	MarkShip playerShip;
	ArrayList<MarkProjectile> playerShots;
	ArrayList<MarkMob> enimies;
	ArrayList<MarkProjectile> mobShots;

	public MarkGalaga(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		bg1 = new GalagaBackground(0, 0, getWidth(),784);
		bg2 = new GalagaBackground(0, 0, getWidth(),784);
		bg1.addSequence("resources/Galaga_bg.jpeg", 1000, 0, 0, getWidth(), 784, 1);
		bg2.addSequence("resources/Galaga_bg.jpeg", 1000, 0, 0, getWidth(), 784, 1);
		bg1.setY(0);
		bg2.setY(-764);
		viewObjects.add(bg1);
		viewObjects.add(bg2);
		
		galagaSpriteSheet = "resources/Galaga_spriteSheet.png";
		
		playerShots = new ArrayList<MarkProjectile>();
		mobShots = new ArrayList<MarkProjectile>();
		
		for(int i = 0; i < 4; i++) {
			playerShots.add(i, new MarkProjectile(1025,getHeight()/2,9,16,"player"));
			playerShots.get(i).addSequence(galagaSpriteSheet, 1000, 374, 51, 3, 9, 1);
			viewObjects.add(playerShots.get(i));
		}
		for(int i = 0; i < 16; i++) {
			mobShots.add(i, new MarkProjectile(1025,0,9,16,"mob"));
		}
		
		playerShip = new MarkShip(getWidth()/2, 600, 48, 48, playerShots);
		playerShip.addSequence(galagaSpriteSheet, 1000, 184, 55, 15, 16, 1);
		viewObjects.add(playerShip);
	}

	
	
}
