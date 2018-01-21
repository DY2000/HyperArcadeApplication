package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class GalagaBackground extends AnimatedComponent{
	
	private int loops;
	
	public GalagaBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		loops = 0;
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public synchronized void checkBehaviors() {
		if(this.getY() > 764) {
			setY(-760);
		}else {
			setY(this.getY()+1);
			setY(this.getY()+1);
			setY(this.getY()+1);
		}		
	}
}
