package practice;

class Stu
{
	
}
class Work
{
	
}
class Tools
{
	private Object  w;
	public void setWork(Object w)
	{
		this.w= w;
	}
	public Object getWork()
	{
		return w;
	}
}
class Utils<E>
{
	private  E e;
	public void setObject(E e)
	{
		this.e=e;
	}
	public E getE()
	{
		return e;
	}
}


public class GenericDemo2 
{
	public static void main(String[] args)
	{
//		Tools t=new Tools();
//		t.setWork(new Work());
//		Work w=(Work) t.getWork();
		Utils<Work> u=new Utils<Work>();
		u.setObject(new Work());
		System.out.println(u.getE());
		
	}
}
