package test;
class MinusException extends Exception
{
	private int num;
	private String msg;
	MinusException()
	{
		super();
	}
	MinusException(String msg)
	{
		super(msg);
	}
	
	MinusException(String msg,int num)
	{
		this.msg=msg;
		this.num =num;
	}
	public String getMessage()
	{
		return msg+"  num:"+num;
	}
	public int getValue()
	{
		return num;
	}
}

class ExDemo
{
	int div(int a,int b) throws MinusException
	{
		if(b<0)
			throw new MinusException("出现了除数是负数的情况/by Minus",b);//手动通过throw关键字抛出自定义异常对象
		return a/b;
	}
}
public class ExceptionDemo2 
{
	public static void main(String[] args)
	{
		ExDemo d = new ExDemo();
		try 
		{
			int x = d.div(4, -1);
			System.out.println(x);
		}
//		catch(Exception e)
//		{
//			
//		}
		catch(MinusException e)
		{
			System.out.println("出现负数");
			System.out.println(e.toString());//异常名称，异常信息
			System.out.println(e.getValue());
			e.printStackTrace();//异常信息，异常名称，异常位置
			//java的默认异常处理机制就是调用printStackTrace()方法，打印异常在堆栈中的跟踪信息
		}
		System.out.println("over");
	}
}
/*
class Throwable
{
	private String message;
	Throwable(String msg)
	{
		this.message=msg;
	}
	public String getMessage()
	{
		return message;
	}
}
*/
