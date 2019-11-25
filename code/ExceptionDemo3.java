package aban;

class AException extends Exception
{
	
}
class BException extends AException
{
	
}
class CException extends Exception
{
	
}

class Fu
{
	void show() throws AException
	{
		throw new AException();
	}
}

class Zi extends Fu
{
	void show() 
	{
		try
		{
			throw new CException();
		}
		catch(CException e)
		{
			System.out.println("jiejuec");
		}
	}
}


class Test1
{
	public void function(Fu f)
	{
		try
		{
			f.show();
		}
		catch(AException e)
		{
			System.out.println("JIEJUEWENTI");
		}
		
	}
}

public class ExceptionDemo3 
{
	public static void main(String[] args)
	{
		Test1 t=new Test1();
		Fu f =new Fu();
		t.function(f);
		t.function(new Zi());
	}
}
