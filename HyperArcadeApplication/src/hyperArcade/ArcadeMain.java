package hyperArcade;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ArcadeMain extends FullFunctionScreen {

	public ArcadeMain(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/homescreen.png"));
		Button tetris = new Button(200,500,100,30,"",new Action() {
			@Override
			public void act() {
			//	HolidayCard.card.setScreen(HolidayCard.inside);
			}
		});
		tetris.setBackground(Color.black);
		tetris.setForeground(Color.black);
		viewObjects.add(tetris);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
