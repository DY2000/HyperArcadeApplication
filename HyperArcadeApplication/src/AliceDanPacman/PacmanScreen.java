package AliceDanPacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;

import devin.DevTicket;
import devin.Ticket;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PacmanScreen extends FullFunctionScreen implements DevTicket {
	
	private DanielPacmanUp pacUp;
	public DanielPacmanUp getPacUp() {
		return pacUp;
	}

	public DanielPacmanLeft getPacLeft() {
		return pacLeft;
	}

	public DanielPacmanRight getPacRight() {
		return pacRight;
	}

	public DanielPacmanDown getPacDown() {
		return pacDown;
	}


	private DanielPacmanLeft pacLeft;
	private DanielPacmanRight pacRight;
	private DanielPacmanDown pacDown;
	private DanielPacman pac;
	private PacmanBackground bg;
	private PacmanGrid grid;
	private int score;

	public PacmanScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.DARK_GRAY);
		
		pacUp = new DanielPacmanUp(0,0,16,16,this);
		pacLeft = new DanielPacmanLeft(0,0,16,16,this);
		pacRight = new DanielPacmanRight(0,0,16,16,this);
		pacDown = new DanielPacmanDown(0,0,16,16,this);
		
		bg = new PacmanBackground(325,50,480,650);
		viewObjects.add(bg);
		pac = new DanielPacman(0,0,20,20,this);
		viewObjects.add(pac);
		grid = new PacmanGrid(60,85,662,518,this);
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


	public PacmanGrid getGrid() {
		return grid;
	}

}
