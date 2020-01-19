class Demo implements Runnable
{
	public void run()
	{
		for(int x=0;x<70;x++)
		{
			System.out.println(Thread.currentThread().toString()+"...run"+x);
		}
	}
}

public class JoinDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		Demo d=new Demo();
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY );
		t2.start();
		//t1.join();
		for(int x=0;x<70;x++)
		{
			System.out.println(Thread.currentThread().getName()+".........main"+x);
		}
	}
}