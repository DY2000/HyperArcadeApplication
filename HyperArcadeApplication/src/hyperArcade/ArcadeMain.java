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
import devin.Inventory;
import devin.TicketShop;

public class ArcadeMain extends FullFunctionScreen {
	private Button back;
	private TextArea ticketCount;
	private int tickets;

	public ArcadeMain(int width, int height) {
		super(width, height);

	}

	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(), getHeight(), "resources/homescreen.png"));
		
		CustomImageButton tetris = new CustomImageButton(110, 400, 120, 75, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {

			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.tetrisScreen);
			}
		});
		tetris.setBackground(Color.black);
		tetris.setForeground(Color.black);
		viewObjects.add(tetris);

		CustomImageButton snake = new CustomImageButton(320, 400, 100, 70, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {

			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.snakeScreen);
			}
		});
		snake.setBackground(Color.black);
		snake.setForeground(Color.black);
		viewObjects.add(snake);

		CustomImageButton galaga = new CustomImageButton(545, 400, 100, 70, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.galagaScreen);
			}
		});
		galaga.setBackground(Color.black);
		galaga.setForeground(Color.black);
		viewObjects.add(galaga);

		CustomImageButton pacman = new CustomImageButton(760, 400, 100, 70, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.pacmanScreen);
			}
		});
		pacman.setBackground(Color.black);
		pacman.setForeground(Color.black);
		viewObjects.add(pacman);
		
		CustomImageButton ticket = new CustomImageButton(100, 100, 100, 100, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.green);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.ticketScreen);
			}
		});
		ticket.setBackground(Color.white);
		ticket.setForeground(Color.white);
		viewObjects.add(ticket);
		
		CustomImageButton inventory = new CustomImageButton(750, 100, 100, 100, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.red);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.inventoryScreen);
			}
		});
		inventory.setBackground(Color.white);
		inventory.setForeground(Color.white);
		viewObjects.add(inventory);

		tickets = 0;

		ticketCount.setTextColor(Color.YELLOW);
		ticketCount = new TextArea(20,20,100,100,"TICKETS "+tickets);
		ticketCount.setVisible(true);
		ticketCount.setSize(30);
		viewObjects.add(ticketCount);
		
	}

	public void updateTickets(int n) {
		tickets += n;
		ticketCount.setText("TICKETS "+tickets);
		update();
	}

	public TextArea getTicketCount() {
		return ticketCount;
	}
	
}
