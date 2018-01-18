package AliceDanPacman;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.Ticket;

public class PacmanScreen extends FullFunctionScreen implements Ticket {

	public PacmanScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PacmanBackground Image = new PacmanBackground(0,0,getWidth(),getHeight());
		viewObjects.add(Image);
	}

}
