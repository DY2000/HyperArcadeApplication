package hyperArcade;

import AliceDanPacman.PacmanBackground;
import AliceDanPacman.PacmanScreen;
import guiTeacher.GUIApplication;

public class ArcadeGUI extends GUIApplication{

	public ArcadeGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		ArcadeGUI hyperArcade = new ArcadeGUI(1024,764);
		Thread runner = new Thread(hyperArcade);
		runner.start();
	}

	@Override
	public void initScreen() {
		ArcadeMain Screen1 = new ArcadeMain(getWidth(),getHeight());
		setScreen(Screen1);
		PacmanScreen Screen3 = new PacmanScreen(getWidth(),getHeight());
		setScreen(Screen3);
	}

}
