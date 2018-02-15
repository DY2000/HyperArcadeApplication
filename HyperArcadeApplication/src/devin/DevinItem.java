package devin;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;

public class DevinItem extends Button{

	private BufferedImage img;
	private String itemName;
	private int price;
	
	public DevinItem(int x, int y, int w, int h, Action action, String itemName, int price) {
		super(x, y, w, h, itemName, action);
		this.itemName = itemName;
		img = new Graphic(0, 0, 10, 100, "resources/"+itemName+".png").getImage();
		this.price = price;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}

	public void drawImage(Graphics2D g) {
		ArrayList<String> itemlist1 = new ArrayList<String>();
		//ArrayList<String> itemlist2 = new ArrayList<String>();
		itemlist1.add(itemName);
		itemName = "resources/reward1.png"; 
		//ticketprice();
		//Graphic arr1 = new Graphic(0, 0, 10, 100, itemName);
			
		}

			
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
