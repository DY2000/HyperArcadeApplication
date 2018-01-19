package AliceDanPacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import markGalaga.MarkPlayerMovement;

public class DanielPacman extends AnimatedComponent implements MarkPlayerMovemen, AliceMethods t{

	public DanielPacman(int x, int y, int w, int h) {
		super(x, y, w, h);
		 
	}
	public void drawImage(Graphics2D g) {
		 g.setColor(Color.yellow);
		  g.fillArc(0,0,100,100,20,270);
	}
	@Override
	public void ateBlue() {
		// TODO Auto-generated method stub
		
	}

}
