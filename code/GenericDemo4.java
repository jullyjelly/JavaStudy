package aban;

import java.util.*;
class Personss
{
	private String name;
	Personss(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
class Studentss extends Personss implements Comparable<Personss>
{
	Studentss(String name)
	{
		super(name);
	}
	public int compareTo(Personss ss)
	{
		return this.getName().compareTo(ss.getName());
	}
}


class Comp implements Comparator<Personss>
{
	public int compare(Personss s1,Personss s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}


public class GenericDemo4 {
	public static void main(String[] args)
	{
		ArrayList<Personss> a1=new ArrayList<>();
		a1.add(new Personss("aaa"));
		a1.add(new Personss("bbb"));
		a1.add(new Personss("ccc"));
		printlist(a1);
		ArrayList<Studentss> a2=new ArrayList<>();
		a2.add(new Studentss("aa---a"));
		a2.add(new Studentss("bb---b"));
		a2.add(new Studentss("cc---c"));
		printlist(a2);
		
		TreeSet<Studentss> ts=new TreeSet<>(new Comp());
		ts.add(new Studentss("sda"));
		ts.add(new Studentss("fab"));
		ts.add(new Studentss("rfs"));
		ts.add(new Studentss("iuy"));
		
		
	}
	public static void printlist(ArrayList<? extends Personss> a)
	{
		ListIterator<? extends Personss> li=a.listIterator();
		while(li.hasNext())
		{
			
			System.out.println(li.next().getName());
		}
	}

}
