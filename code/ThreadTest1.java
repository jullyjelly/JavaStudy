package practice;

class Demo extends Thread
{
	private String name;
	Demo(String name)
	{
		//this.name=name;
		super(name);
	}
	public void run()
	{
		for(int x=0;x<40;x++)
		{
			//System.out.println(this.getName()+"......"+x);
			System.out.println(Thread.currentThread().getName()+"......"+x);
		}
	}

}
public class ThreadTest1 
{
	public static void main(String[] args)
	{
		new Demo("aaa").start();
		new Demo("bbb").start();
	}
}
