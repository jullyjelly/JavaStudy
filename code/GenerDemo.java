package practice;

import java.util.*;

public class GenerDemo {
	public static void main(String[] args)
	{
		TreeSet<String> ts=new TreeSet<>(new RankString());
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

class RankString implements Comparator<String>
{
	public int compare(String o1,String o2)
	{
		int num= new Integer(o1.length()).compareTo(new Integer(o2.length()));
		if(num==0)
			return o1.compareTo(o2);
		else
			return num;
	}
}