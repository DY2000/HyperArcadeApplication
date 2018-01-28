package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class GalagaBackground extends AnimatedComponent{
	
	public GalagaBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		addSequence("resources/Galaga_bg.png", 350, 0, 0, w, h, 3);
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public synchronized void checkBehaviors() {
		if(this.getY() > -1) {
			setY(-764);
		}else {
			setY(this.getY()+1);
			setY(this.getY()+1);
			setY(this.getY()+1);
			setY(this.getY()+1);
		}
	}
}
