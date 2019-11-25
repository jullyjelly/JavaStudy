package FN;

interface Test
{
	void func();
}

public class NimingDemo 
{
	public static void main(String[] args)
	{
		NimingDemo n= new NimingDemo();
		n.show(new Test()
		{
			public void func()
			{
				System.out.print("a");
			}
		});
	}
	void show(Test t)
	{
		t.func();
	}
}
