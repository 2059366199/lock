package cn.itcast.demo1;

public class Output implements Runnable {
	private Resource r ;
	public Output(Resource r){
		this.r = r;
	}
	public void run() {
		while(true){
			synchronized (r) {
				//�����false,�ȴ�
				if(!r.flag){
					try{r.wait();} catch(Exception ex){}
				}
				System.out.println("�̣߳�" + Thread.currentThread().getName() + " --> " + r.name + ".." + r.sex);
				//���Է��̻߳��ѣ���Ǹ�Ϊfalse
				r.flag = false;
				r.notify();
			}
		}
	}

}
