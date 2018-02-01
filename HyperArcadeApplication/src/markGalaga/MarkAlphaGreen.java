package markGalaga;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class MarkAlphaGreen extends AnimatedComponent{

	public MarkAlphaGreen(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.addSequence("resources/Galaga_spriteSheet.png", 800, 161, 103, 15, 16, 2);
		Thread t = new Thread(this);
		update();
		t.start();
	}

	public BufferedImage getImage() {
		System.out.println("returned img");
		return null;
	}
	
}
