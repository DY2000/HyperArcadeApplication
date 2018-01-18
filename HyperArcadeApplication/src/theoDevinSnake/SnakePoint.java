package theoDevinSnake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;
import guiTeacher.components.Graphic;

public class SnakePoint extends Component {
	private int x; 
	private int y;
	private int w;
	private int h;
	private BufferedImage point;
	

	public SnakePoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		point=new Graphic(0,0,50,50,"resources/snakePoint.png").getImage();
		update();
	}


	@Override
	public void update(Graphics2D g) {
//		if(point!=null) {
			g.drawImage(point,0,0,null);
//		}
		
	}



}
