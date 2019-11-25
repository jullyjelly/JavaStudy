package test;

class Demo
{
	private int num;
	Demo(int num)
	{
		this.num=num;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Demo))
			return false;
		Demo d = (Demo)obj;
		return this.num==d.num;
	}
}

public class DuoTaoDemo4 
{
	public static void main(String[] args)
	{
		Demo d1=new Demo(3);
		Demo d2=new Demo(5);
		Demo d3 = d1;
		Class c= d1.getClass();
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));
		int an=3;
		int[] au= {3,2,5,6,8,6};
		System.out.println(d1.toString());
		System.out.println(au.toString());
		System.out.println(d1.hashCode());
		System.out.println(Integer.toHexString(d1.hashCode()));
		System.out.println(Integer.toHexString(au.hashCode()));
		System.out.println(d1.getClass().getName());
		System.out.println(c.getName());
		
	}
}
