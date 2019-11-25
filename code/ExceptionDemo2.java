package aban;


class Demo
{
	public void method()
	{
		try
		{
			throw new Exception();
		}
		catch(Exception e)
		{
			try
			{
				throw e;
			}
			catch(Exception a)
			{
				System.out.println("jiejuewenti");
			}
		}
	}
}
public class ExceptionDemo2 
{
	public static void main(String[] args)
	{
		Demo d=new Demo();
		d.method();
	}
}
