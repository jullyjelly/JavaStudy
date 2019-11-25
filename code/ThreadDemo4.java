package aban;

class Reca
{
	private String name;
	private String sex;
	private boolean flag=false;
	public synchronized void set(String name,String sex)
	{
		if(flag)
			try{this.wait();}catch(Exception e){}
		this.name=name;
		this.sex=sex;
		flag=true;
		this.notify();
	}
	public synchronized void out()
	{
		if(flag)
			try{this.wait();}catch(Exception e){}
		System.out.println(name+"--------"+sex);
		flag=false;
		this.notify();
	}
}

class Input implements Runnable
{
	private Reca r;
	Input(Reca r)
	{
		this.r=r;
	}
	public void run()
	{
		int a=0;
		while(true)
		{
			if(a==0)
				r.set("mike","man");
			else
				r.set("·¼·¼","Å®Å®Å®");
			a=(a+1)%2;
		}
	}
}

class Output implements Runnable
{
	private Reca r;
	Output(Reca r)
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

public class ThreadDemo4 {
	public static void main(String[] args)
	{
		Reca r =new Reca();
		new Thread(new Input(r)).start();
		new Thread(new Input(r)).start();
	}
}
