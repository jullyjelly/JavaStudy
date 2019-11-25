package aban;

class Quanxian
{
	private void func()
	{
		System.out.println("fu");
	}
}
class Quanxianzi extends Quanxian
{
	public void func()
	{
		System.out.println("zi");
	}
}
public class TDemo extends test.PD
{
	public void func()
	{
		new Inner();
	}
	class Inner{}
	public static void main(String[] args)
	{
		TDemo t=new TDemo();
		t.new Inner();
		t.method();
		test.CD c = new test.CD();
		c.func();
		new Quanxianzi().func();
	}
}
