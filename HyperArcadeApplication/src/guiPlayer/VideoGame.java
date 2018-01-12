package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class VideoGame extends Component {

	private String name;
	private String company;
	private String date;
	
	public VideoGame(String name, String company, String date) {
		super(100, 100, 250, 250);
//		addSequence("resources/sonicSpriteSheet.png", 125, 0, 47, 42, 40, 8);
//		Thread animation = new Thread(this);
//		animation.start();
		this.name = name;
		this.company = company;
		this.date = date;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
//		super.update(g);
	}
	
	public String toString() {
		return name+","+company+","+date;
	}
	
}