package test;

class Fu
{
	int num=4;
	void method1()
	{
		System.out.println("fm1");
	}
	void method2()
	{
		System.out.println("fm2");
	}
}
class Zi extends Fu
{
	int num=5;
	void show()
	{
		System.out.println(super.num);
	}
	void method1()
	{
		System.out.println("zm1");
	}
	void method3()
	{
		System.out.println("zm3");
	}
}
public class ExtendsDemo2 {
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		Zi z=new Zi();
		z.show();
		long end=System.currentTimeMillis();
		System.out.println(start);
		System.out.println(end);
		System.out.println(end-start);
		Fu z1 = new Zi();
		z1.method1();
		z1.method2();
		//z1.method3();
	}
}
