package org.firework.concurrency.runnable;

public class MainThread {
	public static void main(String[] args) {
		new MainThread().run2();
	}
	
	public  void run1(){
		LiftOff lo=new LiftOff();
		Thread t=new Thread(lo);
		t.start();
		System.out.println("waiting for liftoff");
	}
	
	public  void run2(){
		for(int i=0;i<10;i++){
			LiftOff lo=new LiftOff();
			Thread t=new Thread(lo);
			t.start();
		}
		System.out.println("waiting for liftoff");
	}
}
