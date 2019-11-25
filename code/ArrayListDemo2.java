package test;

import  java.util.*;
public class ArrayListDemo2 {
	public static void main(String[] arg)
	{
		ArrayList a=new ArrayList();
		a.add(1);
		a.add(4);
		a.add(6);
		a.add(7);
		a.add(3);
		a.add(6);
		a.add(7);
		a.add(3);
		a.add(4);
		System.out.println(a);
		Integer s=(Integer) a.get(3);
		Integer s2=s+3;
		System.out.println(s2);
		singleElement(a);
	}
	public static void singleElement(ArrayList a)
	{
		ArrayList b=new ArrayList();
		Iterator i=a.iterator();
		while(i.hasNext())
		{
			Object o=i.next();
			if(!(b.contains(o)))
			{
				b.add(o);
			}
		}
		System.out.println(b);

	}
}
