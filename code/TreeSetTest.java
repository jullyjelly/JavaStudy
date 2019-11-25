package practice;

import java.util.*;

public class TreeSetTest {
	public static void main(String[] args)
	{
		TreeSet ts=new TreeSet(new RankByLen());
//		TreeSet ts=new TreeSet(new Comparator()
//		{
//			public int compare(Object o1,Object o2)
//			{
//				Integer s1=new Integer(((String) o1).length());
//				Integer s2=new Integer(((String) o2).length());
//				int num=s1.compareTo(s2);
//				if(num==0)
//				{
//					return ((String) o1).compareTo((String) o2);
//				}
//				else
//					return num;
//			}
//		});
		ts.add("abcde");
		ts.add("dfgiop");
		ts.add("yui");
		ts.add("qwes");
		ts.add("as");
		ts.add("six");
		Iterator it=ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}
	
}
class RankByLen implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Integer s1=new Integer(((String) o1).length());
		Integer s2=new Integer(((String) o2).length());
		int num=s1.compareTo(s2);
		if(num==0)
		{
			return ((String) o1).compareTo((String) o2);
		}
		else
			return num;
	}
}
