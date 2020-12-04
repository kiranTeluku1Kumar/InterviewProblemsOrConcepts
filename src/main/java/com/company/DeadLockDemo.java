package com.company;

public class DeadLockDemo {
	public static Object LOCK_ONE = new Object();
	public static Object LOCK_TWO = new Object();

	public static void main(String[] args) {
		
		Thread t1 = new Thread( () -> {
								synchronized (LOCK_ONE) {
									System.out.println("LOCK_ONE t1 lock::"+Thread.currentThread().getName());
									System.out.println("Thread one Synchronized before sleep..");
									
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									synchronized (LOCK_TWO) {
										
										System.out.println("Thread one Synchronized after sleep..");
									}
								}
						}); 
		Thread t2 = new Thread( () -> {
						synchronized (LOCK_TWO) {
							System.out.println("LOCK_TWO t2 lock::"+Thread.currentThread().getName());
							System.out.println("Thread two Synchronized before sleep..");
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							synchronized (LOCK_ONE) {
								
								System.out.println("Thread two Synchronized after sleep..");
							}
						}
				}); 
		t1.run();
		t2.run();
		t1.start();
		t2.start();
	}
	


}
