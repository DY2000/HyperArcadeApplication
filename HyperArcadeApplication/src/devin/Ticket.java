package devin;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;
import hyperArcade.ArcadeGUI;

public class Ticket extends Component {

	private int score;
	private int ticketcount; 
	private boolean ticketreceived;
	private ArcadeGUI program;
	
	public Ticket(int x, int y, int w, int h, ArcadeGUI program) {
		super(x, y, w, h);
		
	}
	
	public void getScore(int getscore) {
		this.score = getscore;
	}
	public void getTicket(int ticket) {
		
		this.ticketcount = ticket;	
		ticketreceived = true;
					
	}
	public void displayTickets() {
		
		update();
		
	}


	//public void displayTickets(int toTicket) {
		// public void draw(Graphics2D g, boolean highlight) {
	//	if (ticketreceived) {
		// ticketreceived = false;
		// place where ticket displayed is will be updated.
		// basically, if ticket display is 90, it'll add the number received from toTicket to ticket displayed.
		// EX: 90 + 70 = 160
		// ticket display will show 160 for all games now.
	//	this.ticketcount = toTicket;
	//	update();
		//makeshift?
	//}




	public void update(Graphics2D g) {
		g.getFontMetrics();	
		if(ticketreceived) {
			g.fillRect(0, 0, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Ticket: " + ticketcount , 10, 30);
			ticketreceived = false;
			//makeshift.
	}
}

}
