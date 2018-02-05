package devin;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;

public class DevinItem extends Component{

	private BufferedImage img;
	private String itemName;
	
	
	public DevinItem(int x, int y, int w, int h, String itemName, int price) {
		super(x, y, w, h);
		this.itemName = itemName;
	}

	@Override
	public void update(Graphics2D g) {
		
	}

	public void drawImage(Graphics2D g) {
		if(itemName = "" )
			//skins for games could work, but that would be too much work. 
			//pikachu doll,
	}
	
}
