package theoDevinSnake;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TheoSnakeGUI extends FullFunctionScreen implements Runnable {
	
		private Button back;
		private TextArea score;
		private TextArea time;
		private ArrayList<SnakePart> snakeBody;
		private int userscore;
		private SnakePoint point;
		private boolean gameOver;
	public TheoSnakeGUI(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		snakeBody = new ArrayList<SnakePart>();
		snakeBody.add(new SnakePart(500,500,25,25,true,this));
		point = new SnakePoint(getRandomX(),getRandomY(),25,25,this);
		viewObjects.add(point);
		for(int i=0;i<snakeBody.size();i++) {
			viewObjects.add(snakeBody.get(i));
		}
	}

	public int getRandomX() {
		return (int)(Math.random()*1024);
	}
	public int getRandomY() {
		return (int)(Math.random()*764);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void gameOver() {
		if(gameOver) {
			
		}
	}
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case  KeyEvent.VK_UP : 
			snakeBody.get(0).moveUp();
			break;
		case KeyEvent.VK_DOWN :
			snakeBody.get(0).moveDown();
			break;
		case KeyEvent.VK_LEFT :
			snakeBody.get(0).moveLeft();
			break;
		case KeyEvent.VK_RIGHT :
			snakeBody.get(0).moveRight();
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		
	}
}
