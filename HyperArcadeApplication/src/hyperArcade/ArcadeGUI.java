package hyperArcade;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class ArcadeGUI extends GUIApplication{

	public static Font themeFont;
	
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
		  try {

			  File fontFile = new File("resources/ArcadeClassic.ttf");

			  // File fontFile = new File("resources//DayRoman.ttf");

			  Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			  themeFont=font.deriveFont(24f);

			  StyledComponent.setBaseFont(themeFont);

			  } catch (Exception e) {

			  e.printStackTrace();

			  }
		ArcadeMain Screen1 = new ArcadeMain(getWidth(),getHeight());
		setScreen(Screen1);
	}

}
