package FN;


class Out
{
	int x=3;
	void method(final int a)
	{
		final int y=4;
		class Int
		{
			void function()
			{
				System.out.println(x);
				System.out.println(y);
				System.out.println(a);
			}
		}
		new Int().function();
	}
}
public class InterDemo2 
{
	public static void main(String[] args)
	{
		//new Out().method(7);
		//new Out().method(8);
		Out out = new Out();
		out.method(5);
		out.method(6);
	}
}
