package aban;

class Thrtest extends Thread
{
	private String name;
	Thrtest(String name)
	{
		this.name=name;
		//super(name);
	}
	public void run()
	{
		System.out.println("thread run");
		for(int x=0;x<60;x++)
			System.out.println(Thread.currentThread().getName()+"test run"+x);
	}
}

class Zhixing{
	public void show() {
		System.out.println("show");
		for(int x=0;x<60;x++)
			System.out.println("show run"+x);
	}
}
public class threadDemo {
	public static void main(String[] args) {
		Thrtest t=new Thrtest("aaa");
		t.start();
		new Thrtest("bbb").start();
//		Zhixing z =new Zhixing();
//		z.show();
		for(int x=0;x<60;x++)
			System.out.println("hello"+x);
	}
}
