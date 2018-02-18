package devin;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.ArcadeGUI;

public class TicketShop extends FullFunctionScreen {
	
	private DevinItem[] items;
	private Button back;
	private Action buy;
	private TextArea ticketCount;
	private ArrayList<DevinItem> Shopitemlist;
	private String[] itemName;

	public TicketShop(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/Ticket_Shop.png"));
		ticketCount = ArcadeGUI.homeScreen.getTicketCount();
		viewObjects.add(ticketCount);
		
		Shopitemlist = new ArrayList<DevinItem>();
		itemName = new String[] {"reward1","reward2","reward3","reward4","reward5","reward6"}; 
		for (int i = 0; i < itemName.length; i++) {
			int n = i;
			Shopitemlist.add(new DevinItem(125 + 50 * i, 555 , 40 , 40 , new Action() {
				
				@Override
				public void act() {
					System.out.println("");
					ArcadeGUI.inventoryScreen.addObject(Shopitemlist.get(n));
					ArcadeGUI.ticketScreen.remove(Shopitemlist.get(n));
					
				}
			}, itemName[i],0));
		}
		for(int i = 0; i < Shopitemlist.size(); i++) {
			viewObjects.add(Shopitemlist.get(i));
		}
		
		back = new Button (0,50,200,100,"GO Back",Color.WHITE,new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.homeScreen);
			}
		});
		viewObjects.add(back);
		
	}
	
}


