package markGalaga;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class MarkAlphaPurple extends AnimatedComponent{

	public MarkAlphaPurple(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.addSequence("resources/Galaga_spriteSheet.png", 800, 161, 127, 15, 16, 2);
		Thread t = new Thread(this);
		update();
		t.start();
	}
	
	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}
}