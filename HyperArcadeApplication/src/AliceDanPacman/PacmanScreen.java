package AliceDanPacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;

import devin.DevTicket;
import devin.Ticket;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PacmanScreen extends FullFunctionScreen implements DevTicket {
	
	PacmanUp pacUp;
	PacmanDown pacDown;
	PacmanLeft pacLeft;
	PacmanRight pacRight;
	DanielPacman pac;
	PacmanBackground bg;
	PacmanGrid movementGrid;
	PacmanGrid dotGrid;

	public PacmanScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.DARK_GRAY);
		pacUp = new PacmanUp(0,0,16,16,this);
		pacDown = new PacmanDown(0,0,16,16,this);
		pacRight = new PacmanRight(0,0,16,16,this);
		pacLeft = new PacmanLeft(0,0,16,16,this);
		
		bg = new PacmanBackground(325,50,480,650);
		viewObjects.add(bg);
		pac = new DanielPacman(400,100,30,30,this);
		viewObjects.add(pac);
		movementGrid = new PacmanGrid(60,85,662,518,"move");
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
		pac.moveUp();
		break;
		case KeyEvent.VK_LEFT :
		pac.moveLeft();
		break;
		case KeyEvent.VK_RIGHT :
		pac.moveRight();
		break;
		case KeyEvent.VK_DOWN :
		pac.moveDown();
		break;
		
		}
	}
	

	public DanielPacman getPacman() {
		return pac;
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

	public PacmanUp getPacUp() {
		return pacUp;
	}

	public PacmanDown getPacDown() {
		return pacDown;
	}

	public PacmanLeft getPacLeft() {
		return pacLeft;
	}

	public PacmanRight getPacRight() {
		return pacRight;
	}

}
