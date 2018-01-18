package HyperArcade;

import guiTeacher.GUIApplication;
import markGalaga.MarkGalaga;

public class ArcadeGUI extends GUIApplication{

	public static MarkGalaga Screen2;
	
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
		Screen2 = new MarkGalaga(getWidth(),getHeight());
		setScreen(Screen2);
	}

}
