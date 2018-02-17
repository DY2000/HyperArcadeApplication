package willTetris;

public interface WillGameStart {
	public void startGame();
	//new thread(new runnable()
	//have text tell them to press enter & text area for 2s for unified appearance

	public void gameOver();
	//set running or w/e to false
	
	public boolean isRunning();
	//use to check that game is over (boolean field)
	//show stats (optional), make back button visible

}
