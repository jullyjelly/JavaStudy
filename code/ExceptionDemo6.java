package test;



class ExpDemo
{
	int div(int a,int b) throws ArithmeticException
	{
		if(b==0)
			throw new ArithmeticException("�����");
			return a/b;
	}
}

public class ExceptionDemo3 
{
	public static void main(String[] args)
	{
		ExpDemo d = new ExpDemo();
		//int x=d.div(4, 0);
		//System.out.println(x);
		Per p =new Per();
		p.checkName(null);
	}
}
class Per
{
	public void checkName(String name)
	{
		if(name==null)
			throw new NullPointerException("�����ֵΪ��");
		else
		{
			if(name.equals("lisi"))
			//if("lisi".equals(name))
				{
				System.out.println("yes");
				}
			else
			{
				System.out.println("no");
			}
		}
	}
}
