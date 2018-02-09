package hyperArcade;

import java.awt.Font;
import java.io.File;

import AliceDanPacman.PacmanBackground;
import AliceDanPacman.PacmanScreen;
import devin.Inventory;
import devin.TicketShop;
import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import markGalaga.MarkGalaga;
import theoDevinSnake.TheoSnakeGUI;
import willTetris.TetrisMain;

public class ArcadeGUI extends GUIApplication {
	public static ArcadeGUI hyperArcade;
	public static ArcadeMain homeScreen;
	public static TetrisMain tetrisScreen;
	public static MarkGalaga galagaScreen;
	public static TheoSnakeGUI snakeScreen;
	public static PacmanScreen pacmanScreen;
	public static TicketShop ticketScreen;
	public static Inventory inventoryScreen;
	public static Font themeFont;

	public ArcadeGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		hyperArcade = new ArcadeGUI(1024, 764);
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
		homeScreen = new ArcadeMain(getWidth(), getHeight());
		tetrisScreen = new TetrisMain(getWidth(), getHeight());
		galagaScreen = new MarkGalaga(getWidth(), getHeight());
		snakeScreen = new TheoSnakeGUI(getWidth(), getHeight());
		pacmanScreen = new PacmanScreen(getWidth(), getHeight());
//		ticketScreen  = new TicketShop(getWidth(), getHeight());
//		inventoryScreen = new Inventory(getWidth(), getHeight());
		setScreen(homeScreen);
	}

}
