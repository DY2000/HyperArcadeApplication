package devin;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.Component;
import guiTeacher.components.Graphic;

public class DevinItem extends Component{

	private BufferedImage img;
	private String itemName;
	private ArrayList itemlist1;
	private ArrayList itemlist2;
	
	
	public DevinItem(int x, int y, int w, int h, String itemName, int price) {
		super(x, y, w, h);
		this.itemName = itemName;
	}

	@Override
	public void update(Graphics2D g) {
		
	}

	public void drawImage(Graphics2D g) {
		ArrayList<DevinItem> itemlist1 = new ArrayList<DevinItem>();
		ArrayList<DevinItem> itemlist2 = new ArrayList<DevinItem>();
		itemlist1.add(itemName);
		itemName = "resources/reward1.png"; 
		//ticketprice();
		Graphic arr1 = new Graphic(0, 0, 10, 100, itemName);
			
		}
			//skins for games could work, but that would be too much work. 
			//pikachu doll,
			
	}
//	public void buyItems(){
//		int items = 5;
//		for(int i = 0; i < items; i++) {
//			if(displayTicket < price) {
//				
//			}
//			else {
//				//ticket will decrease based on price of item
//				itemName = "";//item that will be be bought will be empty
//			}
//		}
//	}


//}
