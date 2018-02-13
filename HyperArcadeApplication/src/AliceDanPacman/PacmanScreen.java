package AliceDanPacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;

import devin.DevTicket;
import devin.Ticket;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PacmanScreen extends FullFunctionScreen implements DevTicket {
	
	DanielPacman pac;
	PacmanBackground bg;
	PacmanGrid movementGrid;
	PacmanGrid dotGrid;
	private int score;

	public PacmanScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.DARK_GRAY);
		bg = new PacmanBackground(325,50,480,650);
		viewObjects.add(bg);
		pac = new DanielPacman(100,100,200,20,this);
		viewObjects.add(pac);
		movementGrid = new PacmanGrid(60,85,662,518,"move");
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
	

	public DanielPacman getPacman() {
		return pac;
	}

	@Override
	public void getScore() {
		//BASED ON NUMBER OF DOTS EATEN
		getPacman();
		
	}

	@Override
	public void toTicket() {
		//
		
	}

	@Override
	public void displayTickets() {
		//
	}


}
