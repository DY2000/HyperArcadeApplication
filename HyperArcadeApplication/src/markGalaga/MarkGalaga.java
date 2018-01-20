package markGalaga;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MarkGalaga extends FullFunctionScreen{
	
	MarkShip playerShip;
	ArrayList<MarkMob> enimies;

	public MarkGalaga(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/Galaga_bg.jpeg"));
		playerShip = new MarkShip(400, 600, 64, 64);
		for(int i = 0; i < playerShip.getShots().size(); i++) {
			viewObjects.add(playerShip.getShots().get(i));
		}
		viewObjects.add(playerShip);
	}

	
	
}
