package markGalaga;

import guiTeacher.components.AnimatedComponent;

public class GalagaBackground extends AnimatedComponent{

	private boolean enabled;
	
	public GalagaBackground(int x, int y, int w, int h, boolean enb) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.enabled = enb;
		addSequence("resources/Galaga_bg.png", 275, 0, 0, w, h, 3);
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public synchronized void checkBehaviors() {
		if(this.getY() > -1) {
			setY(-764);
		}else if(enabled){
			setY(this.getY()+1);
			setY(this.getY()+1);
			setY(this.getY()+1);
		}
	}

	public void setEnabled(boolean b) {
		this.enabled = b;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void clear() {

	}
}
