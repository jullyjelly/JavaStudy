package test;

class MainDemo {
	public static void main(String[] args)
	{
		String[] arr = {"jian","yui","his","yours","mian"};
		MainTest.main(arr);
	}

}
class MainTest
{
	public static void main(String[] args)
	{
		for(int x=0;x<args.length;x++)
			System.out.println(args[x]);
	}
}

