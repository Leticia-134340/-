package Ch23;

public class c03Worker2 implements Runnable {

	c03GUI gui;
	
	c03Worker2(c03GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void run() {

		while(true) {
			try {
			gui.area2.append("WORKER02...\n");
			Thread.sleep(500);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER02 INTERRUPTED...");
		
		
	}

	

}
