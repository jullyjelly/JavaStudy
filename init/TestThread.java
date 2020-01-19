


public class TestThread
{
	public static void main(String[] args)
	{
		new Thread()
		{
			public void run()
			{
				for(int x=0;x<50;x++)
				{
					System.out.println(Thread.currentThread().getName()+".....a...."+x);
				}
			}
		}.start();
		new Thread(new Runnable()
		{
			public void run()
			{
				for(int x=0;x<50;x++)
				{
					System.out.println(Thread.currentThread().getName()+".....c...."+x);
				}
			}
		}).start();
		for(int x=0;x<50;x++)
		{
			System.out.println(Thread.currentThread().toString()+"....b....."+x);
		}
	}
}