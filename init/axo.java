public class axo
{
	public static void main(String[] args)
	{
		System.out.println("hello java");
		int s=0;
		for(int x=1;x<11;x++)
		{
			s =s+x;
		}
		System.out.println(s);
		int num=0;
		for(int x=1;x<101;x++)
		{
			if(x%7==0)
			{
				System.out.println(x);
				num++;	
			}
		}
		System.out.println("di_7_num="+num);
		for(int x=1;x<=5;x++)
		{
			int y=1;
			while(y<=6-x)
			{
				System.out.print('*');
				y++;	
			}
			System.out.println();
		}
		for(int x=1;x<=5;x++)
		{
			for(int y=1;y<=6-x;y++)
			{
				System.out.print('*');
			}
			System.out.println();
		}
		for(int x=1;x<=5;x++)
		{
			int y=1;
			while(y<=x)
			{
				System.out.print('*');
				y++;	
			}
			System.out.println();
		}
	}
}

//²âÊÔÌí¼Ó
