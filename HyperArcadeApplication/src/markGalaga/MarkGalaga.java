package markGalaga;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import java.util.concurrent.CountDownLatch;

public class MarkGalaga extends FullFunctionScreen{
	
	String galagaSpriteSheet;
	AnimatedComponent bg1;
	AnimatedComponent bg2;
	MarkShip playerShip;
	ArrayList<MarkMob> enimies;

	public MarkGalaga(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		galagaSpriteSheet = "resources/Galaga_spriteSheet.png";
		
		bg1 = new GalagaBackground(0, 0, getWidth(),getHeight());
		bg2 = new GalagaBackground(0, 0, getWidth(),getHeight());
		bg1.addSequence("resources/Galaga_bg.jpeg", 1000, 0, 0, getWidth(), getHeight(), 1);
		bg2.addSequence("resources/Galaga_bg.jpeg", 1000, 0, 0, getWidth(), getHeight(), 1);
		bg1.setY(0);
		viewObjects.add(bg1);
		viewObjects.add(bg2);
		playerShip = new MarkShip(getWidth()/2, 600, 64, 64);
		for(int i = 0; i < playerShip.getShots().size(); i++) {
			playerShip.getShots().get(i).addSequence(galagaSpriteSheet, 500, 374, 51, 3, 8, 1);
			viewObjects.add(playerShip.getShots().get(i));
		}
		playerShip.addSequence(galagaSpriteSheet, 1000, 184, 55, 15, 16, 1);
		viewObjects.add(playerShip);
	}

	
	
}
