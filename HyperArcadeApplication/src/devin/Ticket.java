package devin;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Ticket extends Component  implements DevTicket {
	public Ticket(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	private int score;
	private int ticketcount; 
	private boolean ticketreceived;
	
	public void getScore() {
		
			//Only one score will be saved here.
			//needs to indicate what game the score is from.
			
				
		
		
	}

	//public int toTicket() {
	//	getScore();
		
			// method to convert score to ticket
	//	ticketreceived = true;
	//	return ticketcount;
			// make a boolean true
			// returns tickets earned
			
		
	//}
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

	@Override
	public void toTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTickets() {
		// TODO Auto-generated method stub
		
	}
	public void update(Graphics2D g) {
		g.getFontMetrics();	
		if(ticketreceived) {
			g.fillRect(0, 0, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Ticket: " + ticketcount , 10, 30);
			//makeshift.
	}
}

}
