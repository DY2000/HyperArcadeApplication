package markGalaga;
import java.awt.event.KeyEvent;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.KeyedComponent;

public abstract class MarkPlayerMovement extends AnimatedComponent implements KeyedComponent{

	public MarkPlayerMovement(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void keyPressed(KeyEvent arg0);

	@Override
	public abstract void checkBehaviors();
	
	@Override
	public abstract void keyReleased(KeyEvent e);

	@Override
	public abstract void keyTyped(KeyEvent e);

	@Override
	public abstract boolean isHovered(int x, int y);

	@Override
	public abstract void setFocus(boolean b);
}
