package aban;

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
	private int state;
	public void setState(int state)
	{
		this.state=state;
	}
	void run() throws LanpingException,MaoyanException
	{
		if(state==2)
		{
			throw new LanpingException("电脑蓝屏");
			//System.out.println("电脑蓝屏");
			//reset();
		}
		else if(state==3)
			throw new MaoyanException("电脑冒烟");
			//System.out.println("电脑冒烟");
		else
			System.out.println("电脑运行");
	}
	void reset()
	{
		state=1;
		System.out.println("电脑重启");
	}
}

class Teacher
{	
	private String name;
	private Computer cmpt;
	public void setComputer(int state)
	{
		cmpt.setState(state);
	}
	Teacher(String name)
	{
		this.name=name;
		cmpt=new Computer();
	}
	public void teach() throws NOplanException
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
			test();
			throw new NOplanException("无法按计划完成课时因为"+e.getMessage());
		}
		
		System.out.println("讲课");
	}
	public void test()
	{
		System.out.println("练习");
	}
}
class NOplanException extends Exception
{
	NOplanException(String msg)
	{
		super(msg);
	}
}

public class ExceptionDemo 
{
	public static void main(String[] args)
	{
		Teacher t=new Teacher("jianlaoshi");
		t.setComputer(3);
		try
		{
			t.teach();
		}
		catch(NOplanException e)
		{
			//t.test();
			System.out.println("换老师");
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
		
	}
}
