package test;


class EDemo
{
	int div(int a,int b) throws ArithmeticException,ArrayIndexOutOfBoundsException//功能上通过throw关键字生命该功能有可能会出现问题
	{
		int[] arr = new int[a];
		System.out.println(arr[4]);
		return a/b;
	}
}

public class EceptionDemo 
{
	public static void main(String[] args)
	{
		EDemo d = new EDemo();
		try 
		{
			int x = d.div(4, 1);
			System.out.println(x);
		}
		catch(ArithmeticException e)
		{
			System.out.println("输入错误");
			System.out.println(e.getMessage());//异常信息
			System.out.println(e.toString());//异常名称，异常信息
			e.printStackTrace();//异常信息，异常名称，异常位置
			//java的默认异常处理机制就是调用printStackTrace()方法，打印异常在堆栈中的跟踪信息
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.toString());
			System.out.println("参数索引越界");
		}
		System.out.println("over");
	}
}
