package cn.itcast.demo;

public class DeadLock implements Runnable{
	@Override
	public void run() {
		int i = 0 ;
		while(true){
			if(i % 2 == 0){
				synchronized (LockA.locka) {
					System.out.println("线程" + Thread.currentThread().getName() + " = 取得if...locka锁");
					synchronized (LockB.lockb) {
						System.out.println("线程" + Thread.currentThread().getName() + " = 取得if...lockb锁");
					}
				}
			} else {
				synchronized (LockB.lockb) {
					System.out.println("线程" + Thread.currentThread().getName() + " = 取得else...lockb锁");
					synchronized (LockA.locka) {
						System.out.println("线程" + Thread.currentThread().getName() + " = 取得else...locka锁");
					}
				}
			}
			i ++;
		}
	}
	
}