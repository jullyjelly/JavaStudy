package test;

class getTime
{
	getTime()
	{
		long start = System.currentTimeMillis();
		runcode();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	public void runcode(){};	
}
class subTime extends getTime
{
	public void runcode()
	{	
		for(int x=0;x<4000;x++)
		{
			System.out.println(x);
		}
	}
}

public class getTimeDemo 
{
	public static void main(String[] args)
	{
		subTime gt = new subTime();
		//gt.getTime();
		CD c=new CD();
		c.func();
	}
}
