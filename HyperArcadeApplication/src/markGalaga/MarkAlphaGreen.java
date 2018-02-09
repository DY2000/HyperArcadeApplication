package markGalaga;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class MarkAlphaGreen extends AnimatedComponent{

	private MarkGalaga game;
	private int countA;
	private int countB;
	
	public MarkAlphaGreen(int x, int y, int w, int h, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		countA = -135;
		countB = 0;
		this.game = game;
		this.addSequence("resources/Galaga_spriteSheet.png", 800, 161, 103, 15, 16, 2);
		Thread t = new Thread(this);
		update();
		t.start();
	}
	
	public synchronized void checkBehaviors() {
		if(countA/2 > 1) 
			countA--;
		else if(countA/3 < -1)
			countA++;
		else if(countA - 1 < 0) 
			countA = 300;
		else
			countA = -300;
		if(countA == -135 && !game.isSpawning())
			if(countB/2 > 1) 
				countB--;
			else if(countB/3 < 1) 
				countB++;
			else if(countB - 1 < 0)
				countB = 300;
			else
				countB = -300;
	}
	
	
	public BufferedImage getImage() {
		return this.getFrame().get(this.getCurrentFrame());
	}

	public int getCountA() {
		return countA;
	}
	
	public int getCountB() {
		return countB;
	}
}
