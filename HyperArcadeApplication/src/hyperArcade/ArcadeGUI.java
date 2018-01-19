package hyperArcade;

import java.awt.Font;
import java.io.File;

import AliceDanPacman.PacmanBackground;
import AliceDanPacman.PacmanScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import markGalaga.MarkGalaga;

public class ArcadeGUI extends GUIApplication{
	public static ArcadeGUI hyperArcade;
	public static Font themeFont;
	
	public ArcadeGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		hyperArcade = new ArcadeGUI(1024,764);
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
		ArcadeMain Screen1 = new ArcadeMain(getWidth(),getHeight());
		setScreen(Screen1);
		MarkGalaga Screen2 = new MarkGalaga(getWidth(),getHeight());
		
		PacmanScreen Screen3 = new PacmanScreen(getWidth(),getHeight());
	}

}
