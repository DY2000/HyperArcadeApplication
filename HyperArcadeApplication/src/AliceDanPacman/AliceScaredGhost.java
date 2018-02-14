package AliceDanPacman;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class AliceScaredGhost extends AnimatedComponent{

	public AliceScaredGhost(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.addSequence("resources/Pacman_spriteSheet.png", 250, 132, 65, 14, 13, 4);
		Thread t = new Thread(this);
		t.start();
	}

	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}


}
