package AliceDanPacman;
import guiTeacher.components.AnimatedComponent;
public class DanielPacDot extends DanielPickup implements AliceGhostInterface {
		public DanielPacDot(int x, int y, int w, int h) {
			super(x, y, w, h);
		}

		@Override
		public void ateDot() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void wentOverPowerUp() {
			// TODO Auto-generated method stub
			
		}

	}

/**
 * They are supposed to appear on the map in an order that is
 * representative of the pacmans motion. The dots are all same in
 * size, color, and can only be ate once. If you use a map
 * '1' would represent the lit dot while '0' would represent an
 * ate dot. 
 * 
 * 
 * 
 * 
 * 
