package AliceDanPacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import markGalaga.MarkPlayerMovement;
import willTetris.Collidable;

public class DanielPacman extends MarkPlayerMovement implements Collidable{

	public DanielPacman(int x, int y, int w, int h) {
		super(x, y, w, h);
		 
	}
	public void drawImage(Graphics2D g) {
		 g.setColor(Color.yellow);
		  g.fillArc(0,0,100,100,20,270);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setFocus(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void checkBehaviors() {
		// TODO Auto-generated method stub
		
	}
}
