package theoDevinSnake;

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
	public TheoSnakeGUI(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		snakeBody = new ArrayList<SnakePart>();
		snakeBody.add(new SnakePart(100,100,50,50));
		point = new SnakePoint(getRandomX(),getRandomY(),50,50);
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
		//if()
	}
}
