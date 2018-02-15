package AliceDanPacman;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import guiTeacher.components.AnimatedComponent;
public class DanielPacDot extends AnimatedComponent{
	
	private BufferedImage img;
	private String pos;
	private PacmanScreen game;
	private String type;
	
	public DanielPacDot(int x, int y, int w, int h, String type, String pos, PacmanScreen game) {
		super(x, y, w, h);
		this.pos = pos;
		this.game = game;
		this.type = type;
		try {
			BufferedImage temp = ImageIO.read(new File("resources/Pacman_spriteSheet.png"));
			if(type == "power") {
				img = temp.getSubimage(153, 21, 8, 8);
			}else {
				img = temp.getSubimage(164, 21, 8, 8);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t = new Thread(this);
		t.start();
	}

	public void drawImage(Graphics2D g) {
		if(img != null) {
			g.drawImage(img, 0, 0, null);
		}
	}
	
	public void checkBehaviors(){
		String pacPos = game.getPacman().getGridX()+"_"+game.getPacman().getGridY();
		if(pos.equals(pacPos)) {
			game.updateScore(type);
			if(type == "power")
				game.getPacman().atePowerup();
			game.getGrid().grid()[game.getPacman().getGridX()][game.getPacman().getGridY()] = 0;
			game.remove(this);
			setRunning(false);
		}
	}
	
	public String getPos() {
		return pos;
	}

}
