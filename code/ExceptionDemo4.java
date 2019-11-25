package aban;

class FushuException extends RuntimeException//Exception
{
	FushuException(String msg)
	{
		super(msg);
	}
}

interface Shape
{
	public abstract void getArea();
}

class Rec implements Shape
{
	private int len,wid;
	Rec(int len,int wid) //throws FushuException
	{
		if(len <= 0 || wid <= 0)
			throw new FushuException("传入的值为负数");
		this.len=len;
		this.wid=wid;
	}
	
	
	public void getArea()
	{
		System.out.println("area:"+len*wid);
	}
}

class Circle implements Shape
{
	public static final double PI=3.14;
	private int r;
	Circle(int r)
	{
		if(r<=0)
			throw new FushuException("传入的半径为负数");
		this.r=r;
	}
	public void getArea()
	{
		System.out.println("area:"+(PI*r*r));
	}
}
public class ExceptionDemo4 
{
	public static void main(String[] args)
	{
		Rec rec = new Rec(3,0);
		rec.getArea();
		/*try
		{
			Rec rec = new Rec(3,5);
			rec.getArea();
		}
		catch(FushuException e)
		{
			System.out.println("停止运算");
			System.out.println(e.toString());
		}
		*/
		
		new Circle(2).getArea();
	}
}
