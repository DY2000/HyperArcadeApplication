package AliceDanPacman;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class DanielPacmanLeft extends AnimatedComponent{

	PacmanScreen game;
	
	public DanielPacmanLeft(int x, int y, int w, int h, PacmanScreen game) {
		super(x, y, w, h);
		this.game = game;
		this.addSequence("resources/Pacman_spriteSheet.png", 200, 4, 17, 13, 13, 2);
		Thread t = new Thread(this);
		t.start();
	}

	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}
	
}
