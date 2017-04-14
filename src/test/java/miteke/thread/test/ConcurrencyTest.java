package miteke.thread.test;

import miteke.angular.singleton.OrderProcess;

public class ConcurrencyTest {
	public static void main(String args[]) throws InterruptedException {
		
		for(int i=0;i<5;i++){
			
			new Thread(() -> {
				Integer value = OrderProcess.instance.order();
				System.out.println("Value:\t\t" + value);
			}).start();

			new Thread(() -> {
				String teststr = OrderProcess.instance.lockTest();
				System.out.println(teststr);
			}).start();
			
		}

	}
}