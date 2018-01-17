package markGalaga;

import java.awt.event.KeyListener;

import willTetris.Collidable;

public interface MarkPlayerMovement extends Collidable{

	public void moveRight();
	
	public void moveLeft();
	
	public void moveStop();
}
