package aban;

class Ticket implements Runnable//extends Thread
{
	private static int tick=100;
	Object obj =new Object();
	boolean flag=true;
	public void run()
	{
		if(flag)
		{
			
			while(tick>0)
			{
				synchronized(obj)
				{
					if(tick>0) {
						try{Thread.sleep(10);}catch(Exception e) {}
						System.out.println(Thread.currentThread().getName()+"sale"+tick--);
					}
				}
			}
		}
		else
		{
			while(tick>0)
			{
				show();
			}	
		}
	}
	public static synchronized void show()//this
	{
		if(tick>0)
		{
			try{Thread.sleep(10);}catch(Exception e) {}
			System.out.println(Thread.currentThread().getName()+"......show......"+tick--);
		}
	}
}


public class ThreadDemo2 {
	public static void main(String[] args)
	{
		Ticket t=new Ticket();
		new Thread(t).start();
		try {Thread.sleep(10);}catch(Exception e) {}
		t.flag=false;
		new Thread(t).start();
		//new Thread(t).start();
		//new Thread(t).start();
	}
}
