package AliceDanPacman;

import java.awt.event.KeyEvent;
import java.util.List;

import devin.Ticket;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PacmanScreen extends FullFunctionScreen   {
	DanielPacman pac;
	AliceGhost ghost;

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
		PacmanGrid movementGrid = new PacmanGrid(60,85,662,518,"move");
		ghost = new AliceGhost(60,60, 180,160,"gohst1", this);
		ghost.initAllObjects(viewObjects);
		viewObjects.add(ghost);
//		ghost.whenBlue(movementGrid, pac);
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
	
	

	@Override
	public void getScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTickets() {
		// TODO Auto-generated method stub
		
	}

}
