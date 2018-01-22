package markGalaga;

import guiTeacher.components.AnimatedComponent;

public abstract class MarkPlayerMovement extends AnimatedComponent {

	public MarkPlayerMovement(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public abstract void checkBehaviors();

}
