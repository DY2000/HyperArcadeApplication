package AliceDanPacman;

import java.util.List;

import guiPlayer.Sampler.SampleScreen;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.Ticket;

public class PacmanGUI extends FullFunctionScreen implements Ticket {

	public PacmanGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PacScreen s = new PacScreen(getWidth(), getHeight());
		setScreen(s);
		
	}

}
