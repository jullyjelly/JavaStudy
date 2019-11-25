package aban;


class LockTest implements Runnable
{
	private boolean flag;
	LockTest(boolean flag)
	{
		this.flag=flag;
	}
	public void run()
	{
		if(flag)
		{
			synchronized(Lock.obja)
			{
				System.out.println("ifa");
				synchronized(Lock.objb)
				{
					System.out.println("ifb");
					
				}
			}
				
		}
		else
		{
			synchronized(Lock.objb)
			{
				System.out.println("elseb");
				synchronized(Lock.obja)
				{
					System.out.println("elsea");
					
				}
			}
		}
	}
	
}

class Lock
{
	static Object obja=new Object();
	static Object objb=new Object();
}
public class DeadLockDemo {
	public static void main(String[] args)
	{
		
		Thread t1=new Thread(new LockTest(true));
		Thread t2=new Thread(new LockTest(false));
		t1.start();
		t2.start();
	}
}
