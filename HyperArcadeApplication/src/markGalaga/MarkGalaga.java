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
		playerShip = new MarkShip(500,500, 128, 128);
		playerShip.setX(400);
		playerShip.setY(400);
		viewObjects.add(playerShip);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE :
				playerShip.fireShot();
				System.out.println("Pew");
				break;
			case KeyEvent.VK_LEFT :
				playerShip.moveLeft();
				System.out.println("Left");
				break;
			case KeyEvent.VK_RIGHT : 
				playerShip.moveRight();
				System.out.println("Right");
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				playerShip.moveStop();
				System.out.print("stop");
			case KeyEvent.VK_RIGHT : 
				playerShip.moveStop();
				System.out.print("stop");
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
