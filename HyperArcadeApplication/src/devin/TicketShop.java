package devin;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.ArcadeGUI;

public class TicketShop extends FullFunctionScreen {
	
	private DevinItem[] items;
	private Button back;

	public TicketShop(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
//		//viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/Ticket_Shop.jpeg"));
//		for(ItemInterface a: items) {
//			viewObjects.add(a);
		//}
		//viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/Ticket_Shop.png"));
		back = new Button (0,50,200,100,"GO Back",new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.homeScreen);
			}
		});
		viewObjects.add(back);
		
	}
//	private void addItems() {
//		int numitems = 4;
//		items = new ItemInterface[numitems];
//		for(int i = 0; i < numitems; i++) {
//			//custom image?
//		}
//	}
//	public void buy(Item item) {
//		String name = item.getName();
//		ArrayList<item> itemlist = items.get(name);
//		if(itemlist == null) {
//			itemlist = new ArrayList<item>();
//			items.put(name,itemlist);
//		}
//		itemlist.add(item);
//	}
		
}


