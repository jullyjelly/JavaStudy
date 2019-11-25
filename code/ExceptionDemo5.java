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
			throw new MinusException("�����˳����Ǹ��������/by Minus",b);//�ֶ�ͨ��throw�ؼ����׳��Զ����쳣����
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
			System.out.println("���ָ���");
			System.out.println(e.toString());//�쳣���ƣ��쳣��Ϣ
			System.out.println(e.getValue());
			e.printStackTrace();//�쳣��Ϣ���쳣���ƣ��쳣λ��
			//java��Ĭ���쳣������ƾ��ǵ���printStackTrace()��������ӡ�쳣�ڶ�ջ�еĸ�����Ϣ
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
