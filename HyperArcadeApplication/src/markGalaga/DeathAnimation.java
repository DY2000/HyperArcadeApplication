package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class DeathAnimation extends AnimatedComponent{

	public DeathAnimation(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.addSequence("resources/Galaga_spriteSheet.png", 50, 200, 192, 32, 32, 5);
		update();
		Thread t = new Thread(this);
		t.start();
	}
	
	public void sleep(int n)
	{
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
