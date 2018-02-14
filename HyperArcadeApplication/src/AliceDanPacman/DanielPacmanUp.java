package AliceDanPacman;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class DanielPacmanUp extends AnimatedComponent{

	private PacmanScreen game;
	
	public DanielPacmanUp(int x, int y, int w, int h, PacmanScreen game) {
		super(x, y, w, h);
		this.game = game;
		this.addSequence("resources/Pacman_spriteSheet.png", 200, 4, 33, 13, 13, 2);
		Thread t = new Thread(this);
		t.start();
	}
	
	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}
}
