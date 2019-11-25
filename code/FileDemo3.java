package aban;

public class FileDemo3 {
	public static void main(String[] args)
	{
		toBin(8);
		System.out.println(getSum(10));
	}
	public static void toBin(int num)
	{
		if(num>0)
		{
			toBin(num/2);
			System.out.println(num%2);
		}
//		while(num>0)
//		{
//			System.out.println(num%2);
//			num=num/2;
//		}
	}
	public static int getSum(int n)
	{
		if(n==1)
			return 1;
		return n+getSum(n-1);
	}
}
