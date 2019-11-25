package aban;

class Bank
{
	private int sum;
//	Object obj =new Object();
	public synchronized void add(int n)
	{
//		synchronized(obj)
//		{
			sum=sum+n;
			try{Thread.sleep(10);}catch(Exception e) {}
			System.out.println("sum="+sum);
//		}
		
	}
}

class Cus implements Runnable
{
	Bank b=new Bank();
	public void run()
	{
		for(int x=0;x<3;x++)
		{
			b.add(100);
		}
	}
}
public class ThreadDemo3 {
	public static void main(String[] args)
	{
		Cus c=new Cus();
		new Thread(c).start();
		new Thread(c).start();
	}
}
