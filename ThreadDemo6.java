import  java.util.concurrent.locks.*;
class Resourse
{
	private String name;
	private int count =1;
	private boolean flag=false;
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	public void set(String name) throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
				condition.await();
			this.name=name+"-----"+count++;
			System.out.println(Thread.currentThread().getName()+".....生产者...."+this.name);
			flag=true;
			condition.signalAll();
		}
		finally
		{
			lock.unlock();//将同步语句变成了两个方法
		}
	}
	public void out() throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
				condition.await();
			System.out.println(Thread.currentThread().getName()+".....消费者......"+this.name);
			flag=false;
			condition.signalAll();
		}
		finally
		{
			lock.unlock();//将同步语句变成了两个方法
		}
	}
}

class Producer implements Runnable
{
	private Resourse res;
	Producer(Resourse res)
	{
		this.res=res;
	}
	public void run()
	{
		while(true)
		{
			
			try{
				res.set("商品");
			}
			catch(InterruptedException e){}
		}
	}
}
class Consumer implements Runnable
{
	private Resourse res;
	Consumer(Resourse res)
	{
		this.res=res;
	}
	public void run()
	{
		while(true)
		{
			
			try{
				res.out();
			}
			catch(InterruptedException e){}
		}
	}
}
public class ThreadDemo6
{
	public static void main(String[] args)
	{
		Resourse s=new Resourse();
		new Thread(new Producer(s)).start();
		new Thread(new Consumer(s)).start();
		new Thread(new Producer(s)).start();
		new Thread(new Consumer(s)).start();
	}
}