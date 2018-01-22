package markGalaga;

import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import willTetris.Collidable;

public class MarkMob extends AnimatedComponent implements Collidable{
	
	private int count;
	private ArrayList<MarkProjectile> mobShots;
	
	public MarkMob(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		count = 0;
		mobShots = new ArrayList<MarkProjectile>();
		for(int i = 0; i < 3; i++) {
			mobShots.add(i, new MarkProjectile(1030,300/2,9,16,"mob"));
		}
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public synchronized void checkBehaviors() {
		if(count/3 > 1) {
			count--;
			setX(getX()-1);
		}else if(count/3 < -1){
			count++;
			setX(getX()+1);
		}else {
			if(count - 1 < 0) {
				count = 120;
			}else {
				count = -120;
			}
		}
		if(Math.random() < .0005) {
			System.out.println("Pew");
			attack(mobShots,(getX()+getWidth()/2)-(mobShots.get(0).getWidth()/2),getY());
			
		}
	}

	private void attack(ArrayList<MarkProjectile> arl, int x, int y) {
		for(int i = 0; i < mobShots.size(); i++) {
			if(mobShots.get(i).getVy() != 0 && i > 1 && i < mobShots.size()-1) {
				arl.get(i-1).setX(x);
				arl.get(i-1).setY(y);
				arl.get(i-1).setVy(8);
				arl.get(i-1).setVx(-(int)(Math.random()*2)+1);				
				arl.get(i).setX(x);
				arl.get(i).setY(y);
				arl.get(i).setVy(8);
				arl.get(i+1).setX(x);
				arl.get(i+1).setY(y);
				arl.get(i+1).setVy(8);
				arl.get(i+1).setVx((int)(Math.random()*2)+1);
				break;
			}
		}
		flyingAttack(getX(),getY());
	}

	private void flyingAttack(int x, int y) {
		;
	}
	
	public ArrayList<MarkProjectile> getShots(){
		return mobShots;
	}
}
