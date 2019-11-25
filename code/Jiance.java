package FN;

class F
{
	int show(int a,int b)
	{
		return 0;
	}
	void func()
	{
		System.out.println("funcf");
	}
}
class Z extends F
{
	double show(int a,long b)
	{
		return 1;
	}
	void set()
	{
		System.out.println("funcf");
	}
	
}

interface A
{
	void show();
}
interface B
{
	void add(int a,int b);
}
class C implements A,B
{
	private int sum;
	public void add(int a,int b)
	{
		//System.out.println(a+b);
		sum=a+b;
	}
	public void show()
	{
		System.out.println(sum);
	}
}


public class Jiance 
{
	public static void main(String[] args)
	{
		C c=new C();
		c.add(3,4);
		c.show();
		System.out.println("----------");
		F f= new Z();
		f.func();
		//f.set();
		Z z =(Z) f;
		System.out.println(z.show(3, (long)(5)));
	}
}
