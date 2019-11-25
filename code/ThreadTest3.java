package practice;


class DeadLock implements Runnable
{
	private int t=20;
	boolean flag=true;
	Object obja=new Object();
	Object objb=new Object();
	public void run()
	{
		while(t>0)
		{
			if(flag)
			{
				synchronized(obja)
				{
					System.out.println("ifa");
					synchronized(objb)
					{
						System.out.println("ifb");
					}
				}
			}
			else
			{
				synchronized(objb)
				{
					System.out.println("elseb");
					synchronized(obja)
					{
						System.out.println("elsea");
					}
				}
			}
			flag=!flag;
			t--;
		}
	}
}
public class ThreadTest3 {
	public static void main(String[] args)
	{
		DeadLock d=new DeadLock();
		new Thread(d).start();
//		try {Thread.sleep(1);}catch(Exception e) {}
//		d.flag=false;
		new Thread(d).start();
	}
}
