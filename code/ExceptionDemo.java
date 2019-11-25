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
			throw new LanpingException("��������");
			//System.out.println("��������");
			//reset();
		}
		else if(state==3)
			throw new MaoyanException("����ð��");
			//System.out.println("����ð��");
		else
			System.out.println("��������");
	}
	void reset()
	{
		state=1;
		System.out.println("��������");
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
			throw new NOplanException("�޷����ƻ���ɿ�ʱ��Ϊ"+e.getMessage());
		}
		
		System.out.println("����");
	}
	public void test()
	{
		System.out.println("��ϰ");
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
			System.out.println("����ʦ");
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
		
	}
}
