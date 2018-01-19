package hyperArcade;

import java.awt.Font;
import java.io.File;

import AliceDanPacman.PacmanBackground;
import AliceDanPacman.PacmanScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import markGalaga.MarkGalaga;
import theoDevinSnake.TheoSnakeGUI;
import willTetris.TetrisMain;

public class ArcadeGUI extends GUIApplication{
	public static ArcadeGUI hyperArcade;
	public static ArcadeMain Screen1;
	public static TetrisMain Screen2;
	public static MarkGalaga Screen3;
	public static TheoSnakeGUI Screen4;
	public static PacmanScreen Screen5;	
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
		Screen1 = new ArcadeMain(getWidth(),getHeight());
		Screen2 = new TetrisMain(getWidth(),getHeight());
		Screen3 = new MarkGalaga(getWidth(),getHeight());
		Screen4 = new TheoSnakeGUI(getWidth(),getHeight());
		Screen5 = new PacmanScreen(getWidth(),getHeight());
		setScreen(Screen1);
	}

}
