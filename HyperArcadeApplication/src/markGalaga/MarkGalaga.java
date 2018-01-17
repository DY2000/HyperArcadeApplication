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
		playerShip = new MarkShip(0,0, 128, 128);
		MarkProjectile shot1 = new MarkProjectile(0,0,10,40);
		shot1.setVy(-1);
		shot1.setY(400);
		shot1.setX(400);
		viewObjects.add(shot1);
//		MarkProjectile shot2 = new MarkProjectile(10,10,40,40);
//		MarkProjectile shot3 = new MarkProjectile(10,10,40,40);
//		MarkProjectile shot4 = new MarkProjectile(10,10,40,40);
//		MarkProjectile shot5 = new MarkProjectile(10,10,40,40);
//		MarkProjectile shot6 = new MarkProjectile(10,10,40,40);
//		MarkProjectile shot7 = new MarkProjectile(10,10,40,40);
//		MarkProjectile shot8 = new MarkProjectile(10,10,40,40);
		playerShip.setX(400);
		playerShip.setY(400);
		viewObjects.add(playerShip);
	}

	
	
}
