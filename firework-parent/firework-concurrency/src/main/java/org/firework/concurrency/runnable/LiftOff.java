package org.firework.concurrency.runnable;

public class LiftOff implements Runnable {
	
	private int countDown=10;
	private static int taskCount=0;
	private final int id=taskCount++;
	
	public LiftOff(){
	}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	
	public String status(){
		return "#" +id +"("+(countDown>0?countDown:"LiftOff!")+")";
	}
	public void run() {
		while(countDown-->0){
			System.out.println(status());
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		
	}
}