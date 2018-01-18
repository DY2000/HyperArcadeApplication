package hyperArcade;

import guiTeacher.GUIApplication;

public class ArcadeGUI extends GUIApplication{
	public static ArcadeGUI hyperArcade;
	
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
	}

}
