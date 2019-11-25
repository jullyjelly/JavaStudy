package test;

class statiscode
{
	int age=20;
	static String country = "CN";
	{
		System.out.println(age);
	}
	static
	{
		System.out.println("a");
	}
	static void show()
	{
		System.out.println(country);
	}
}

public class statiscodedemo {
	static
	{
		System.out.println("b");
	}
	public static void main(String[] args)
	{
		new statiscode();
		new statiscode();
		System.out.println("over");
		statiscode.show();
	}
	static
	{
		System.out.println("c");
	}
	
	
}
