package FN;

class Outer
{
	private static int x=3;
	static class Inter
	{
		static void function()
		{
			System.out.println("inter"+x);
		}	
		static void show()
		{
			System.out.println("jian");
		}
	}
	static class Inter2
	{
		void show()
		{
			System.out.println("Inter show"+2);
		}
	}
	public static void method()
	{
		//Inter.function();
		new Inter2().show();;	
	}
}

public class InterDemo 
{
	public static void main(String[] args)
	{
		Outer.method();
		//new Outer.Inter().function();
		Outer.Inter.function();
		//Outer.Inter in=new Outer().new Inter();
		//in.function();
		
	}
}
