package aban;

interface Inter
{
	void method();
}

class Test
{
	static class Inner implements Inter
	{
		public void method()
		{
			System.out.println("method run");
		}
	}
	static Inter function()
	{
		//return new Inner();
		return new Inter()
		{
			public void method()
			{
				System.out.println("method run");
			}
		};
	}
	public static void show(Inter in)
	{
		in.method();
	}

}
public class InterDemo {
	/*
	static class Inner
	{
		void function()
		{
			System.out.println("function run");
		}
	}
	*/
	public static void main(String[] args)
	{
		Test.function().method();
		Test.show(new Inter()
				{
					public void method()
					{
						System.out.println("mathod show run");
					}
				});
		//new Inner().function();
		new Object()
		{
			void function()
			{
				System.out.println("function run");
			}
		}.function();
	}
	
}