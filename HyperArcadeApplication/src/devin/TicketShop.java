package devin;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TicketShop extends FullFunctionScreen {
	
	private DevinItem[] items;
	

	public TicketShop(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/Ticket_Shop.jpeg"));
		for(ItemInterface a: items) {
			viewObjects.add(a);
		}
		
	}
	private void addItems() {
		int numitems = 4;
		items = new ItemInterface[numitems];
		for(int i = 0; i < numitems; i++) {
			//custom image?
		}
	}


}
