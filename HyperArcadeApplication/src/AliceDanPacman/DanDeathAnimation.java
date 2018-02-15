package AliceDanPacman;

import guiTeacher.components.AnimatedComponent;
import markGalaga.MarkGalaga;

public class DanDeathAnimation extends AnimatedComponent {

	public DanDeathAnimation(int x, int y, int w, int h, PacmanScreen game) {
		super(x, y, w, h);
		this.addSequence("resources/Pacman_spriteSheet.png", 250, 35, 0, 15, 15, 12);
		update();
		Thread t = new Thread(this);
		t.start();
	}

}
