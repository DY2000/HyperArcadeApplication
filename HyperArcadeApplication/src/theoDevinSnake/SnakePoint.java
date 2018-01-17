package theoDevinSnake;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class SnakePoint extends Component {
	private int x; 
	private int y;
	private int w;
	private int h;
	

	public SnakePoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawRect(x,y,w,h);
		g.fillRect(x, y,w,h);

	}

}
