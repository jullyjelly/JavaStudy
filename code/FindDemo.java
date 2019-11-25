package practice;

public class FindDemo 
{
	public static void main(String[] args)
	{
		get("ksajdhkjasfggfhjsj","fgfhjsd");
		StringBuilder sb=new StringBuilder("ksdiwurks");
		System.out.println(sb);
		char[] c=new char[9];
		sb.getChars(2, 5, c, 3);
		for(int x=0;x<c.length;x++)
			System.out.println("["+c[x]+"]");
		Integer i=new Integer(32);
		System.out.println(i.intValue());
	}
	public static void get(String s1,String s2)
	{
		//int len=s2.length();
		w:for(int x=s2.length();x>0;x--)
		{
			for(int y=0;y<s2.length()-x;y++)
			{
				if(s1.contains(s2.substring(y,y+x)))
				{
					System.out.println(s2.substring(y,y+x));
					break w;
				}	
			}
		}
		
	}
}
