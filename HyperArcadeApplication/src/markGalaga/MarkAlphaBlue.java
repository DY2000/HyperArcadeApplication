package markGalaga;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class MarkAlphaBlue extends AnimatedComponent{

	private MarkGalaga game;
	
	public MarkAlphaBlue(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.game = game;
		this.addSequence("resources/Galaga_spriteSheet.png", 800, 162, 178, 13, 10, 2);
		Thread t = new Thread(this);
		update();
		t.start();
	}
	
	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}
}