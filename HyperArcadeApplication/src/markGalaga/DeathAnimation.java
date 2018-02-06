package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class DeathAnimation extends AnimatedComponent{

	public DeathAnimation(int x, int y, int w, int h, String m, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		if(m == "mob")
			this.addSequence("resources/Galaga_spriteSheet.png", 50, 200, 192, 32, 32, 5);
		else
			this.addSequence("resources/Galaga_spriteSheet.png", 100, 233, 48, 32, 32, 4);
		update();
		Thread t = new Thread(this);
		t.start();
	}

}
