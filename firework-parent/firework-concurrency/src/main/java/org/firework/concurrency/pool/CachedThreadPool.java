package org.firework.concurrency.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.firework.concurrency.runnable.LiftOff;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.submit(new LiftOff());
		}
		exec.shutdown();
	}
}
