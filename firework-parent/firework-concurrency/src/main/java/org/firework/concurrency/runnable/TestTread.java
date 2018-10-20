package org.firework.concurrency.runnable;

public class TestTread extends Thread {
	private int countDown=10;
	private static int taskCount=0;
	private final int id=taskCount++;
	
	public String status(){
		return "#" +id +"("+(countDown>0?countDown:"LiftOff!")+")";
	}
	public void run() {
		while(countDown-->0){
			System.out.println(status());
			Thread.yield();
		}
	}
	
	public static void main(String[] args){
		System.out.println("waiting for liftoff");
		for(int i=0;i<10;i++){
			TestTread t=new TestTread();
			t.start();
		}
		
	}
}
