package AliceDanPacman;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.Ticket;

public class PacmanScreen extends FullFunctionScreen implements Ticket {
	static Thread counter = new Thread();


	public PacmanScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PacmanBackground Image = new PacmanBackground(0,0,getWidth(),getHeight());
		viewObjects.add(Image);
		
		
	}
	
	public void whenBlue() {
		
		Thread timer = new Thread(new Runnable() {
			
			public void run() {
				
				while(isBlue()) {
					
					try {
						
						Thread.sleep(1000);
					}
					
					catch(Throwable e) {
						e.printStackTrace();
						
					}
				}
				
			}

			private boolean isBlue() {
				
				return DanielPacman.ateBlue();
				
			}
			
		});
		
	}
	

}
