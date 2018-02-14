package AliceDanPacman;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class AliceCyanUp extends AnimatedComponent{

	public AliceCyanUp(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.addSequence("resources/Pacman_spriteSheet.png", 200, 60, 97, 14, 13, 2);
		Thread t = new Thread(this);
		t.start();
	}

	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}

}
