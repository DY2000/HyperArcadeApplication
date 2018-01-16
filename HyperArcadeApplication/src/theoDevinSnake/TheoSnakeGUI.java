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
		snakeBody.add(new SnakePart(50,50,0,0));
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
