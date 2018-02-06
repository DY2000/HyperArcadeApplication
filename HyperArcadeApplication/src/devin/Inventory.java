package devin;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.ArcadeGUI;


public class Inventory extends FullFunctionScreen {
	private Button back;
	private ArrayList<DevinItem> Shopitemlist;
	public Inventory(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Shopitemlist = new ArrayList<DevinItem>();
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/inventory.png"));
		back = new Button (0,50,200,100,"GO Back",new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.homeScreen);
			}
		});
		viewObjects.add(back);
	}
	}


