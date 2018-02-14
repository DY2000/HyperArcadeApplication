package AliceDanPacman;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class AliceOrangeLeft extends AnimatedComponent{

	public AliceOrangeLeft(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.addSequence("resources/Pacman_spriteSheet.png", 200, 32, 113, 14, 13, 2);
		Thread t = new Thread(this);
		t.start();
	}

	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}

}
