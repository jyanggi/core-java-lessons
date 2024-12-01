package lessons.v8.ocp.chapter2.singleton;

public class CounterSingleton {

	private static volatile CounterSingleton INSTANCE; //thread safe
	private int count;

//	static{
	 // if you do not want to lazy load it
//		INSTANCE = new CounterSingleton();
//	}

	private CounterSingleton() {
		// to override implicit public Constructor
	}

	public static CounterSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (CounterSingleton.class) {
				if (INSTANCE == null)
					INSTANCE = new CounterSingleton();
			}
		}
		return INSTANCE;
	}

	public synchronized void increment() {
		count++;
	}

	public synchronized boolean decrement() {
		if (count == 0)
			return false;
		count--;
		return true;
	}

	public synchronized int getCount() {
		return count;
	}
}
