package AliceDanPacman;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class PacmanUp extends AnimatedComponent{

	private PacmanScreen game;
	
	public PacmanUp(int x, int y, int w, int h, PacmanScreen game) {
		super(x, y, w, h);
		this.game = game;
		this.addSequence("resources/Pacman_spriteSheet.png", 500, 3, 32, 16, 16, 2);
		Thread t = new Thread(this);
		t.start();
	}
	
	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}
}
