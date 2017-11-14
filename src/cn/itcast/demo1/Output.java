package cn.itcast.demo1;

public class Output implements Runnable {
	private Resource r ;
	public Output(Resource r){
		this.r = r;
	}
	public void run() {
		while(true){
			synchronized (r) {
				//标记是false,等待
				if(!r.flag){
					try{r.wait();} catch(Exception ex){}
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " --> " + r.name + ".." + r.sex);
				//将对方线程唤醒，标记改为false
				r.flag = false;
				r.notify();
			}
		}
	}

}
