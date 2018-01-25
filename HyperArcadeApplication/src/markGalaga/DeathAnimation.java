package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class DeathAnimation extends AnimatedComponent{

	public DeathAnimation(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.addSequence("resources/Galaga_spriteSheet.png", 100, 200, 192, 32, 32, 5);
		update();
		Thread t = new Thread(this);
		t.start();
	}

}
