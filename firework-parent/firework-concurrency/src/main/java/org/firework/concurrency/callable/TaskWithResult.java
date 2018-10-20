package org.firework.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskWithResult implements Callable<String> {
	private int id;
	public TaskWithResult(int id){
		this.id=id;
	}
	public String call() throws Exception {
		String result="result of task:"+id;
		return result;
	}
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		TaskWithResult task = new TaskWithResult(1);
        Future<String> future = executorService.submit(task);
        executorService.shutdown();
        
        
        System.out.println("主线程在执行任务...");
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
         
        try {
            System.out.println("task运行结果:"+future.get());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }  
        System.out.println("所有任务执行完毕");
	}
}
