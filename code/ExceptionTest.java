package FN;

class LanpingException extends Exception
{
	LanpingException(String msg)
	{
		super(msg);
	}
}

class MaoyanException extends Exception
{
	MaoyanException(String msg)
	{
		super(msg);
	}
}

class Computer
{
	int state=3;
	public void run() throws LanpingException,MaoyanException
	{
		if(state==2)
			throw new LanpingException("������");
		if(state==3)
			throw new MaoyanException("ð����");
		System.out.println("��������");
	}
	public void reset()
	{
		state=1;
		System.out.println("��������");
	}
}
class Teacher
{
	private String name;
	public Computer cmpt;
	Teacher(String name)
	{
		this.name=name;
		cmpt=new Computer();
	}
	public void teach() throws NoPlaneException
	{
		try
		{
			cmpt.run();
		}
		catch(LanpingException e)
		{
			cmpt.reset();
		}
		catch(MaoyanException e)
		{
			lianxi();
			throw new NoPlaneException("��ʱ�޷�������Ϊ"+e.getMessage());
		}
		System.out.println("����");
	}
	public static void lianxi()
	{
		System.out.println("��ϰ");
	}
}
class NoPlaneException extends Exception
{
	NoPlaneException(String msg)
	{
		super(msg);
	}
}


public class ExceptionTest 
{
	public static void main(String[] args)
	{
		Teacher t=new Teacher("��ʦ");
		try
		{
			t.teach();
		}
		catch(NoPlaneException e)
		{
			System.out.println("����ʦ");
			System.out.println(e.toString());
		}
		System.out.println(t.cmpt.state);
		
		
	}
	
}
