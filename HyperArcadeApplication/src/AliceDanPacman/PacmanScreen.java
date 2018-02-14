package AliceDanPacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;

import devin.DevTicket;
import devin.Ticket;
import guiTeacher.components.TextArea;
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
	private TextArea labelBox;
	private TextArea scoreBox;
	private TextArea highscoreBox;	
	private TextArea lifeBox;
	private TextArea messageBox;
	private TextArea stageBox;
	private TextArea resultsBox;
	private PacmanBackground bg;
	private PacmanGrid grid;
	private boolean running;
	private int score;
	private int highscore;
	private int lives;
	private int stage;

	public PacmanScreen(int width, int height) {
		super(width, height);
		running = false;
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
		redRight = new AliceRedRight(0,0,26,26);
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
		
		grid = new PacmanGrid(60,85,662,518,this);
		
		blinky = new AliceGhost(0,0,20,20,"red",this);
		pinky = new AliceGhost(0,0,20,20,"pink",this);
		inky = new AliceGhost(0,0,20,20,"cyan",this);
		clyde = new AliceGhost(0,0,20,20,"orange",this);
		viewObjects.add(blinky);
		viewObjects.add(pinky);
		viewObjects.add(inky);
		viewObjects.add(clyde);
		
		
		stage = 1;
		score = 0;
		lives = 2;
		highscore = 20000;
		
		labelBox = new TextArea(325, 55, 425, 40,"    1UP                                    HIGH SCORE");
		labelBox.setCustomTextColor(Color.WHITE);
		labelBox.setSize(25);
		viewObjects.add(labelBox);
		
		lifeBox = new TextArea(325,640,100,40,"LIVES "+lives);
		lifeBox.setCustomTextColor(Color.WHITE);
		lifeBox.setSize(20);
		viewObjects.add(lifeBox);
		
		scoreBox = new TextArea(350, 75, 425, 40,"");
		scoreBox.setCustomTextColor(Color.WHITE);
		scoreBox.setSize(25);
		viewObjects.add(scoreBox);
		
		messageBox = new TextArea(getWidth()/2-100, getHeight()/2-60, 300, 40, "PRESS  ENTER  TO  START  GAME");
		messageBox.setCustomTextColor(Color.CYAN);
		messageBox.setSize(22);
		addObject(messageBox);
		
		stageBox = new TextArea(getWidth()/2-20, getHeight()/2, 200, 40, "STAGE "+stage);
		stageBox.setCustomTextColor(Color.CYAN);
		stageBox.setSize(32);
		stageBox.setVisible(false);
		addObject(stageBox);
		
		highscoreBox = new TextArea(510, 75, 425, 40,highscore+"");
		highscoreBox.setCustomTextColor(Color.WHITE);
		highscoreBox.setSize(25);
		viewObjects.add(highscoreBox);
		
		resultsBox = new TextArea(400,250,400,400,"GAME OVER");
		resultsBox.setCustomTextColor(Color.RED);
		resultsBox.setSize(26);
		resultsBox.setVisible(false);
		viewObjects.add(resultsBox);
	}
	

	private void startGame() {
		running = true;
		Thread intro = new Thread(new Runnable() {
			
			@Override
			public void run() {
				messageBox.setX(getWidth()/2-20);
				messageBox.setSize(32);
				messageBox.setText("PLAYER 1");
				for(int i = 0; i < 7; i++) {
					messageBox.setVisible(!messageBox.isVisible());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				stageBox.setText("STAGE "+stage);
				stageBox.setVisible(true);
				messageBox.setVisible(true);
				pac.setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				messageBox.setVisible(false);
				stageBox.setVisible(false);
			}
		});
		intro.start();
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP :
				if(running)
				if(pac.getDirection() != 1)
				pac.moveUp();
				break;
			case KeyEvent.VK_LEFT :
				if(running)
				if(pac.getDirection() != 0)
				pac.moveLeft();
				break;
			case KeyEvent.VK_RIGHT :
				if(running)
				if(pac.getDirection() != 2)
				pac.moveRight();
				break;
			case KeyEvent.VK_DOWN :
				if(running)
				if(pac.getDirection() != 3)
				pac.moveDown();
				break;
			case KeyEvent.VK_ENTER : 
				if(pac.getDirection() == -1 && !running)
					startGame();
				break;
		}
	}
	


	public DanielPacman getPacman() {
		return pac;
	}


	public void updateScore(String type) {
		if(type.equals("bit") ) {
			score += 100;
			scoreBox.setText(score+"");
		}else if(type.equals("power")) {
			scoreBox.setText(score+"");
		}
		update();
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

	public boolean isRunning() {
		return running;
	}
}
