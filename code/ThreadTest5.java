package practice;

class Rec
{
	String name;
	String sex;
	boolean b=false;
	public synchronized void set(String name,String sex)
	{
		if(b)
			try {this.wait();}catch(Exception e) {}
		this.name=name;
		this.sex=sex;
		b=true;
		this.notify();
	}
	public synchronized void out()
	{
		if(!b)
			try {this.wait();}catch(Exception e) {}
		System.out.println(name+"......."+sex);
		b=false;
		this.notify();
	}
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
			if(flag)
			{
				r.set("ming", "man");
			}
			else
			{
				r.set("李", "女女女");
			}
			flag=!flag;
			
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
			r.out();
		}	
	}
}

public class ThreadTest5 {
	public static void main(String[] args)
	{
		Rec r=new Rec();
		new Thread(new Input(r)).start();
		//try {Thread.sleep(10);}catch(Exception e) {}
		new Thread(new Output(r)).start();
		//new Thread(new Input(r)).start();
		//new Thread(new Output(r)).start();
	}
}
