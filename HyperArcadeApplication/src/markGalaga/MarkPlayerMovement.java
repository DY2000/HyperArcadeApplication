package markGalaga;

import guiTeacher.components.AnimatedComponent;

public abstract class MarkPlayerMovement extends AnimatedComponent {

	public MarkPlayerMovement(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void moveLeft();
	public abstract void moveRight();
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveStop();
}
