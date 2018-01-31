package AliceDanPacman;

import java.awt.event.KeyEvent;
import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.Ticket;

public class PacmanScreen extends FullFunctionScreen implements Ticket {
	DanielPacman pac;

	public PacmanScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PacmanBackground Image = new PacmanBackground(0,0,getWidth(),getHeight());
		viewObjects.add(Image);
		DanielPacman pac = new DanielPacman(100,100,200,20);
		viewObjects.add(pac);
	}
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
		pac.moveUp();
		case KeyEvent.VK_LEFT :
		pac.moveLeft();
		case KeyEvent.VK_RIGHT :
		pac.moveRight();
		case KeyEvent.VK_DOWN :
		pac.moveDown();
		
		}
	}
	
	
	

}
