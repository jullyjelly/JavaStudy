package test;

public class hello 
{
	public static void main(String[] args)
	{
		//tob(20);
		toh(-60);
		 t_searchtb(-60);
		 b_searchtb(-80);
		 trans(-6,1,1);
		 tobin(0);
		 tobin(69);
		 tohex(30);
		 toba(46);
	}
	
	public static void tob(int num)
	{
		StringBuffer b=new StringBuffer();
		while(num!=0)
		{
			//System.out.println(num%2);
			b.append(num%2);
			num = num>>1;
		}
		System.out.println(b.reverse());
	}
	public static void toh(int num)
	{
		StringBuffer h=new StringBuffer();
		while(num!=0)
		{
			int temp=num&15;
			if(temp>9)
			{
				h.append((char)(temp-10+'a'));
			}
			else
				h.append(temp);
			num = num>>>4;
		}
		System.out.println(h.reverse());
	}
	public static void t_searchtb(int num)
	{
		StringBuffer h=new StringBuffer();
		char[] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(num!=0)
		{
			int temp=num&15;
			h.append(ch[temp]);
			num = num>>>4;
		}
		System.out.println(h.reverse());
	}
	//十进制转二进制的复杂方法（十六进制同）
	public static void b_searchtb(int num)
	{
		
		char[] ch = {'0','1'};
		char[] arr = new char[32];
		int pos=arr.length;
		while(num!=0)
		{
			int temp = num&1;
			arr[--pos] = ch[temp];
			num = num>>>1;
		}
		for(int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println();
		
	}
	public static void tobin(int num)
	{
		trans(num,1,1);
	}
	public static void tohex(int num)
	{
		trans(num,15,4);
	}
	public static void toba(int num)
	{
		trans(num,7,3);
	}
	//提取十进制转十六进制和二进制的共性
	public static void  trans(int num,int base,int offset)
	{
		if(num==0)
		{
			System.out.println(0);
			return;
		}
		char[] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] arr=new char[32];
		int pos = arr.length;
		while(num!=0)
		{
			int temp = num&base;
			arr[--pos]=ch[temp];
			num = num>>>offset;
		}
		for(int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println();
	}
}
