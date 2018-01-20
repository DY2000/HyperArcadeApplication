package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class GalagaBackground extends AnimatedComponent{
	
	public GalagaBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		setVy(5);
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public void checkBehaviors() {
		if(this.getY() > getHeight()) {
			setY(0-getHeight());
		}
	}
}
