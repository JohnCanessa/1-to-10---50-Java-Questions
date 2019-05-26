package questions.canessa.com;

import java.util.concurrent.TimeUnit;

/*
 * 
 */
public class MyThread extends Thread {

	// **** flag used to stop this thread ****
	private volatile boolean stop = false;
	
	// **** ****
	public void run() {
		
		// **** counter ****
		int count = 0;
		
		// **** loop until told to stop ****
		while (!stop) {
			System.out.println("run <<< count: " + count);
			count++;
			try {
				TimeUnit.MILLISECONDS.sleep(789);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// **** flag to kill this thread ****
	public void die() {
		stop = true;
	}
	
}
