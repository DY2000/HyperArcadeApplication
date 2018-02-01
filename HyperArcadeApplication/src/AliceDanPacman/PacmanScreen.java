package AliceDanPacman;

import java.util.List;

import devin.Ticket;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.DevTicket;

public class PacmanScreen extends FullFunctionScreen implements DevTicket {

	public PacmanScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PacmanBackground Image = new PacmanBackground(0,0,getWidth(),getHeight());
		viewObjects.add(Image);
	}

	@Override
	public void getScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTickets() {
		// TODO Auto-generated method stub
		
	}

}
