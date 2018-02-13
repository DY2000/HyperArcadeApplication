package willTetris;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class TetrisGUI extends GUIApplication {

	public static Font themeFont;
	private static final long serialVersionUID = 6193168349270768657L;

	public TetrisGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		TetrisGUI hyperArcade = new TetrisGUI(1024, 764);
		Thread runner = new Thread(hyperArcade);
		runner.start();
	}

	@Override
	public void initScreen() {
		try {
			File fontFile = new File("resources/ArcadeClassic.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			themeFont = font.deriveFont(24f);
			StyledComponent.setBaseFont(themeFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TetrisMain Screen1 = new TetrisMain(getWidth(), getHeight());
		setScreen(Screen1);
	}

}
