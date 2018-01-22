package markGalaga;

import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import willTetris.Collidable;

public class MarkMob extends AnimatedComponent implements Collidable{
	
	MarkMob mob;
	private int hp;
	private int count;
	private MarkGalaga game;
	private ArrayList<MarkProjectile> mobShots;
	
	public MarkMob(int x, int y, int w, int h, String mobType,ArrayList<MarkProjectile> arl, MarkGalaga game) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		setShots(arl);
		if(mobType == "abductor")
			hp = 2;
		else hp = 1;
		this.game = game;
		count = 0;
		update();
		Thread t = new Thread(this);
		mob = this;
		t.start();
	}

	private void setShots(ArrayList<MarkProjectile> arl) {
		this.mobShots = arl;
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
		if(Math.random() < .00075) {
			attack(this.getShots(),(getX()+getWidth()/2)-(mobShots.get(0).getWidth()/2),getY());
		}
		if(hp == 0) {
			this.addSequence("resources/Galaga_spriteSheet.png", 100, 200, 192, 32, 32, 5);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mob.setX(1030);
			mob.setY(25);
			mob.setRunning(false);
		}
	}

	private void attack(ArrayList<MarkProjectile> arl, int x, int y) {
		for(int i = 1; i < arl.size(); i = i+3)
			if(arl.get(i).getVy() == 0) {
				arl.get(i-1).setX(x);
				arl.get(i-1).setY(y);
				arl.get(i-1).setVy(8);
				arl.get(i-1).setVx(-((int)(Math.random()*2)+1));				
				arl.get(i).setX(x);
				arl.get(i).setY(y);
				arl.get(i).setVy(8);
				arl.get(i).setX(x);
				arl.get(i+1).setY(y);
				arl.get(i+1).setVy(8);
				arl.get(i+1).setVx((int)(Math.random()*2)+1);
		}
		flyingAttack(getX(),getY());
	}

	public boolean detectCollision(MarkProjectile shot) {
		if((shot.getX() < getX() + getWidth() && shot.getX() + shot.getWidth() > getX() &&
			shot.getY() < getY() + getHeight() && shot.getHeight() + shot.getY() > getY())){
			hp--;
			return true; 
		}
		else{
			return false; 
		}
	}
	
	private void flyingAttack(int x, int y) {
		;
	}
	
	public ArrayList<MarkProjectile> getShots(){
		return mobShots;
	}
}
