package cn.itcast.demo;

public class DeadLock implements Runnable{
	@Override
	public void run() {
		int i = 0 ;
		while(true){
			if(i % 2 == 0){
				synchronized (LockA.locka) {
					System.out.println("�߳�" + Thread.currentThread().getName() + " = ȡ��if...locka��");
					synchronized (LockB.lockb) {
						System.out.println("�߳�" + Thread.currentThread().getName() + " = ȡ��if...lockb��");
					}
				}
			} else {
				synchronized (LockB.lockb) {
					System.out.println("�߳�" + Thread.currentThread().getName() + " = ȡ��else...lockb��");
					synchronized (LockA.locka) {
						System.out.println("�߳�" + Thread.currentThread().getName() + " = ȡ��else...locka��");
					}
				}
			}
			i ++;
		}
	}
	
}