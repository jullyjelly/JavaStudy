package practice;

class Ticket implements Runnable
{
	private  int ticket=100;
	 boolean flag=true;
	//public synchronized void run()
	 Object obj=new Object();
	 public void run()
	{
		if(flag)
		{
			while(ticket>0)
			{
				synchronized(this)
				{
					if(ticket>0) 
					{
						//try {Thread.sleep(10);}catch(Exception e) {}
						System.out.println(Thread.currentThread().getName()+"......"+ticket--);
					}
				}
			}
		}
		else
		{
			while(ticket>0)
				show();
		}
		
	}
	public synchronized void show()
	{
		if(ticket>0)
		{
			//try {Thread.sleep(10);}catch(Exception e) {}
			System.out.println(Thread.currentThread().getName()+"....show...."+ticket--);
		}
		
	}
}

public class ThreadTest2 {
	public static void main(String[] args)
	{
		Ticket t1=new Ticket();
		Ticket t2=new Ticket();
		new Thread(t1).start();
		
		try {Thread.sleep(10);}catch(Exception e) {}
		t2.flag=false;
		new Thread(t2).start();
		//new Thread(t).start();
		//new Thread(t).start();
	}
}
