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
	private DanielPacmanLeft pacLeft;
	private DanielPacmanRight pacRight;
	private DanielPacmanDown pacDown;
	private DanielPacman pac;
	private AliceGhost blinky;
	private AliceGhost pinky;
	private AliceGhost inky;
	private AliceGhost clyde;
	private AliceRedUp redUp;
	private AliceRedDown redDown;
	private AliceRedRight redRight;
	private AliceRedLeft redLeft;
	private AlicePinkUp pinkUp;
	private AlicePinkDown pinkDown;
	private AlicePinkRight pinkRight;
	private AlicePinkLeft pinkLeft;
	private AliceCyanUp cyanUp;
	private AliceCyanDown cyanDown;
	private AliceCyanRight cyanRight;
	private AliceCyanLeft cyanLeft;
	private AliceOrangeUp orangeUp;
	private AliceOrangeDown orangeDown;
	private AliceOrangeRight orangeRight;
	private AliceOrangeLeft orangeLeft;
	private AliceScaredGhost scaredGhost;
	private PacmanBackground bg;
	private PacmanGrid grid;
	private int score;

	public PacmanScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.DARK_GRAY);
		
		bg = new PacmanBackground(325,50,480,650);
		viewObjects.add(bg);
		
		pacUp = new DanielPacmanUp(0,0,16,16);
		pacLeft = new DanielPacmanLeft(0,0,16,16);
		pacRight = new DanielPacmanRight(0,0,16,16);
		pacDown = new DanielPacmanDown(0,0,16,16);
		pac = new DanielPacman(0,0,20,20,this);
		viewObjects.add(pac);
		
		redUp = new AliceRedUp(0,0,16,16);
		redDown = new AliceRedDown(0,0,16,16);
		redRight = new AliceRedRight(0,0,16,16);
		redLeft = new AliceRedLeft(0,0,16,16);
		pinkUp = new AlicePinkUp(0,0,16,16);
		pinkDown = new AlicePinkDown(0,0,16,16);
		pinkRight = new AlicePinkRight(0,0,16,16);
		pinkLeft = new AlicePinkLeft(0,0,16,16);
		cyanUp = new AliceCyanUp(0,0,16,16);
		cyanDown = new AliceCyanDown(0,0,16,16);
		cyanRight = new AliceCyanRight(0,0,16,16);
		cyanLeft = new AliceCyanLeft(0,0,16,16);
		orangeUp = new AliceOrangeUp(0,0,16,16);
		orangeDown = new AliceOrangeDown(0,0,16,16);
		orangeRight = new AliceOrangeRight(0,0,16,16);
		orangeLeft = new AliceOrangeLeft(0,0,16,16);
		scaredGhost = new AliceScaredGhost(0,0,16,16);
		
		blinky = new AliceGhost(0,0,30,30,"red",this);
		pinky = new AliceGhost(0,0,30,30,"pink",this);
		inky = new AliceGhost(0,0,30,30,"cyan",this);
		clyde = new AliceGhost(0,0,30,30,"orange",this);
		viewObjects.add(blinky);
		viewObjects.add(pinky);
		viewObjects.add(inky);
		viewObjects.add(clyde);
		
		grid = new PacmanGrid(60,85,662,518,this);
		

		score = 0;
	}
	

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP :
				if(pac.getDirection() != 1)
				pac.moveUp();
				break;
			case KeyEvent.VK_LEFT :
				if(pac.getDirection() != 0)
				pac.moveLeft();
				break;
			case KeyEvent.VK_RIGHT :
				if(pac.getDirection() != 2)
				pac.moveRight();
				break;
			case KeyEvent.VK_DOWN :
				if(pac.getDirection() != 3)
				pac.moveDown();
				break;
		}
	}
	

	public DanielPacman getPacman() {
		return pac;
	}


	public void updateScore(int i) {
		
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

	public AliceRedUp getRedUp() {
		return redUp;
	}

	public AliceRedDown getRedDown() {
		return redDown;
	}

	public AliceRedRight getRedRight() {
		return redRight;
	}

	public AliceRedLeft getRedLeft() {
		return redLeft;
	}

	public AlicePinkUp getPinkUp() {
		return pinkUp;
	}

	public AlicePinkDown getPinkDown() {
		return pinkDown;
	}

	public AlicePinkRight getPinkRight() {
		return pinkRight;
	}

	public AlicePinkLeft getPinkLeft() {
		return pinkLeft;
	}

	public AliceCyanUp getCyanUp() {
		return cyanUp;
	}

	public AliceCyanDown getCyanDown() {
		return cyanDown;
	}

	public AliceCyanRight getCyanRight() {
		return cyanRight;
	}

	public AliceCyanLeft getCyanLeft() {
		return cyanLeft;
	}

	public AliceOrangeUp getOrangeUp() {
		return orangeUp;
	}

	public AliceOrangeDown getOrangeDown() {
		return orangeDown;
	}

	public AliceOrangeRight getOrangeRight() {
		return orangeRight;
	}

	public AliceOrangeLeft getOrangeLeft() {
		return orangeLeft;
	}

	public AliceScaredGhost getScaredGhost() {
		return scaredGhost;
	}
}
