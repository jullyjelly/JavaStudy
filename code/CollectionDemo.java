package test;
import java.util.*;

public class CollectionDemo {
	public static void main(String[] arg)
	{
		ArrayList a1 =new ArrayList();
		ArrayList a2 =new ArrayList();
//		int[] i1= {1,3,4,5,6};
//		int[] i2= {1,3,4,5,6};
		
		a1.add("he");
		a1.add("h2");
		a1.add("ha");
		a1.add("hf");
		a2.add("h1");
		a2.add("h2");
		a2.add("h5");
		a2.add("h6");
//		a1.removeAll(a2);
//		sop(a1);
		Iterator it =a1.iterator();
		while(it.hasNext())
		{
			sop(it.next());
		}
		a1.addAll(a2);
		String[] x= {"sd","sdf","io"};
		Object[] b =a1.toArray(new String[0]);
		
		System.out.println(b.length);
//		sop(b.length);
		for(int u=0;u<b.length;u++)
		{
			System.out.println(b[u]);
		}
		sop("------");
		sop(a1.toArray(new String[0]));
		sop(a1.subList(3,6));
		List sa=new ArrayList();
	
//		ListIterator l=a1.listIterator(4);
//		sop(l);
		for (ListIterator l=a1.listIterator(4);l.hasNext();)
		{
			sop(l.next());
		}
		Iterator t=a1.listIterator(4);
		
		ListIterator ls=a1.listIterator();
		System.out.println(ls.hasPrevious());
		System.out.println(ls.hasNext());
		while(ls.hasNext())
		{
			Object obj=ls.next();
			if(obj.equals("h2"))
				ls.add("sdfsdg");
			
		}
		sop(a1);
		System.out.println(ls.hasPrevious());
		System.out.println(ls.hasNext());
		
//		while(a1.listIterator(4).hasNext())
//			sop(a1.listIterator(4).next());
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
