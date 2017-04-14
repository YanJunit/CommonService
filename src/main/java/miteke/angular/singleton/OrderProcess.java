package miteke.angular.singleton;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public enum OrderProcess {
	instance;

	public static Logger logger = Logger.getLogger(OrderProcess.class.getName());
	public static AtomicInteger counter = new AtomicInteger();

	public Integer order() {
		synchronized (this) {
			counter.incrementAndGet();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter.decrementAndGet();
			System.out.println("Counter : " + counter);
			return counter.intValue();
		}
	}

	public String lockTest() {
		return "lock test..";
	}
}
