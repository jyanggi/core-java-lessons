package lessons.v8.ocp.chapter2.singleton;

import static java.lang.System.out;

import java.util.concurrent.CompletableFuture;

public class CounterSingeltonSample {

	public static void main(String[] args) {
		CounterSingleton singletonInstance = CounterSingleton.getInstance();
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
			singletonInstance.increment();
			out.printf("future1 done count is now:%d\n", singletonInstance.getCount());
			return singletonInstance.getCount();
		});
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			singletonInstance.decrement();
			out.printf("future2 done count is now:%d\n", singletonInstance.getCount());
			return singletonInstance.getCount();
		});
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {

			singletonInstance.increment();
			singletonInstance.increment();
			out.printf("future3 done count is now:%d\n", singletonInstance.getCount());
			return singletonInstance.getCount();
		});
		CompletableFuture.allOf(future1, future2, future3).join();
	}
}
