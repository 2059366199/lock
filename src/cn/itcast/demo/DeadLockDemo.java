package cn.itcast.demo;

public class DeadLockDemo{
	public static void main(String[] args) {
		DeadLock dead = new DeadLock();
		new Thread(dead).start();
		new Thread(dead).start();
	}
}