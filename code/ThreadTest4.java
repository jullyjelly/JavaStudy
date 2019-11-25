package FN;

class Rec
{
	String name;
	String sex;
	boolean b=false;
}
class Input implements Runnable
{
	private Rec r;
	Input(Rec r)
	{
		this.r=r;
	}
	boolean flag=false;
	public void run()
	{
		
		while(true)
		{
			synchronized(r)
			{
				while(r.b)
					try {r.wait();}catch(Exception e) {}
				if(flag)
				{
					r.name="ming";
					r.sex="man";
				}
				else
				{
					r.name="李";
					r.sex="女女女";
				}
				flag=!flag;
				r.b=true;
				System.out.println(r.name+"......."+r.sex);
				r.notifyAll();
			}
			
		}
		
	}
}
class Output implements Runnable
{
	private Rec r;
	Output(Rec r)
	{
		this.r=r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				while(!r.b)
					try {r.wait();}catch(Exception e) {}
				System.out.println(Thread.currentThread().getName()+"......."+r.name+"......."+r.sex);
				r.b=false;
				r.notifyAll();
			}
		}	
	}
}

public class ThreadTest4 {
	public static void main(String[] args)
	{
		Rec r=new Rec();
		new Thread(new Input(r)).start();
		//try {Thread.sleep(10);}catch(Exception e) {}
		new Thread(new Output(r)).start();
		new Thread(new Input(r)).start();
		new Thread(new Output(r)).start();
	}
}
