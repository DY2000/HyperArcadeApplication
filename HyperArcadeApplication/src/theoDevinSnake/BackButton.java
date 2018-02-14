package theoDevinSnake;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import hyperArcade.ArcadeGUI;

public class BackButton extends Button {

	public BackButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		this.setText("Back");
		this.setCurve(5, 5);
		this.setAction(new Action() {
			
			@Override
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.homeScreen);
				
			}
		});
	}

	public BackButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		this.setText("Back");
		this.setCurve(5, 5);
		this.setAction(new Action() {
			
			@Override
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.homeScreen);
				
			}
		});
	}

}
