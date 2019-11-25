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
			throw new LanpingException("蓝屏了");
		if(state==3)
			throw new MaoyanException("冒烟了");
		System.out.println("电脑运行");
	}
	public void reset()
	{
		state=1;
		System.out.println("电脑重启");
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
			throw new NoPlaneException("课时无法继续因为"+e.getMessage());
		}
		System.out.println("讲课");
	}
	public static void lianxi()
	{
		System.out.println("练习");
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
		Teacher t=new Teacher("老师");
		try
		{
			t.teach();
		}
		catch(NoPlaneException e)
		{
			System.out.println("换老师");
			System.out.println(e.toString());
		}
		System.out.println(t.cmpt.state);
		
		
	}
	
}
