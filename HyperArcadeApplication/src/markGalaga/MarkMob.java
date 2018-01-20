package markGalaga;

import guiTeacher.components.AnimatedComponent;
import willTetris.Collidable;

public class MarkMob extends AnimatedComponent implements Collidable{
	
	public MarkMob(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
	}

	
	
}
