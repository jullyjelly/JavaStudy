package test;
import  java.util.*;
class DuiLie
{
	private LinkedList link;
	DuiLie()
	{
		link=new LinkedList();
	}
	public  void  myAdd(Object obj)
	{
		link.add(obj);
	}
	public Object myGet()
	{
		return link.removeFirst();
	}
	public boolean isNull()
	{
		return link.isEmpty();
	}
}

public class LinkedListDemo {
	public static void main(String[] arg)
	{
		DuiLie d=new DuiLie();
		d.myAdd("j1");
		d.myAdd("j2");
		d.myAdd("j3");
		d.myAdd("j4");
		while(!d.isNull())
		{
			System.out.println(d.myGet());
			
		}
	}
	
}
