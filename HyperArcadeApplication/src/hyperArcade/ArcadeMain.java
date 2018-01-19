package hyperArcade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import AliceDanPacman.PacmanScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.DrawInstructions;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import markGalaga.MarkGalaga;
import theoDevinSnake.TheoSnakeGUI;
import willTetris.TetrisMain;

public class ArcadeMain extends FullFunctionScreen {

	public ArcadeMain(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(), getHeight(), "resources/homescreen.png"));
		TextArea tetrisScreen = new TextArea(110, 400, 100, 70, "TETRIS");
		CustomImageButton tetris = new CustomImageButton(110, 400, 120, 75, new DrawInstructions() {

			@Override
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
//					g.setColor(Color.black);
//					g.fillRect(0, 0, 100, 65);
//					viewObjects.remove(tetrisScreen);
				} else {
//					g.setColor(Color.white);
//					g.fillRect(0, 0, 100, 65);
//					viewObjects.add(tetrisScreen);
				}
			}
		}, new Action() {

			@Override
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.Screen2);
			}
		});
		tetris.setBackground(Color.black);
		tetris.setForeground(Color.black);
		viewObjects.add(tetris);
		
		Button snake = new Button(320,400,100,70,"",new Action() {
			@Override
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.Screen4);
			}
		});
		snake.setBackground(Color.black);
		snake.setForeground(Color.black);
		viewObjects.add(snake);
		
		Button galaga = new Button(545,400,100,70,"",new Action() {
			@Override
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.Screen3);
			}
		});
		galaga.setBackground(Color.black);
		galaga.setForeground(Color.black);
		viewObjects.add(galaga);
		
		Button pacman = new Button(760,400,100,70,"",new Action() {
			@Override
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.Screen5);
			}
		});
		pacman.setBackground(Color.black);
		pacman.setForeground(Color.black);
		viewObjects.add(pacman);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
