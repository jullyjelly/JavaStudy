class que
{
	public static void main(String[] args)
	{
		for(int x=1;x<=9;x++)
		{
			for(int y=1;y<=x;y++)
			{
				System.out.print(y+"*"+x+"="+(x*y)+"\t");	
			}
			System.out.println();
		}
		
		for(int x=1;x<=5;x++)
		{
			for(int y=1;y<=5-x;y++)
			{
				System.out.print('-');
			}
			for(int y=1;y<=x;y++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		int x= GetResult(4);
		System.out.println(x);
		GetResult1(5);
		System.out.println(max(2,3));
		draw(4,5);
		//int[] arr =new int[5];
		int[] arr ={2,3,4,5,6};
		System.out.println(arr);
		System.out.println(arr[2]);
		
	}
	public static int GetResult(int num)
	{
		return num*3+5;
	}
	public static void GetResult1(int num)
	{
		System.out.println(num*3+5);
	}
	public static int max(int a,int b)
	{
		
		return (a>=b)?  a:b;
	}
	public static void draw(int a,int b)
	{
		for(int x=1;x<=a;x++)
		{
			for(int y=1;y<=b;y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}