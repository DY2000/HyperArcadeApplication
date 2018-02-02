package markGalaga;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class MarkAlphaPurple extends AnimatedComponent{

	MarkGalaga game;
	
	public MarkAlphaPurple(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.game = game;
		this.addSequence("resources/Galaga_spriteSheet.png", 800, 161, 127, 15, 16, 2);
		Thread t = new Thread(this);
		update();
		t.start();
	}
	
	public synchronized void checkBehaviors() {
		if(this.getCurrentFrame() != game.getAlphaGreen().getCurrentFrame())
			this.setCurrentFrame(game.getAlphaGreen().getCurrentFrame());
	}
	
	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}
}