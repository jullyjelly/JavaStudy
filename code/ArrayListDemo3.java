package test;
import  java.util.*;
class Person1
{
	private String name;
	private int age;
	Person1(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person1))
		{
			return false;
		}
		Person1 p=(Person1) obj;
		return this.name.equals(p.name)&& this.age==p.age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}
public class ArrayListDemo3 {
	public static void main(String[] arg)
	{
		ArrayList a=new ArrayList();
		a.add(new Person1("j1",56));
		a.add(new Person1("j2",3));
		a.add(new Person1("j3",34));
		a.add(new Person1("j4",38));
		a.add(new Person1("j1",56));
		a.add(new Person1("j2",34));
		a.add(new Person1("j3",3));
		a.add(new Person1("j4",56));
		a.add(new Person1("j1",6));
		a.add(new Person1("j2",3));
		printPerson(a);
		printPerson(singlePerson(a));
		printPerson(singleElement(a));
		System.out.println(Math.max(2,4));
		System.out.println(new Person1("j1",56));
		
	}
	public static ArrayList singlePerson(ArrayList a)
	{
		ListIterator i=a.listIterator();
		ArrayList b=new ArrayList();
		
		while(i.hasNext())
		{
			Object o=i.next();
			Person1 p=(Person1) o;
			
			if(!b.isEmpty())
			{
				b.add(p);
			
				int sb=b.size();
				w:for(int x=0;x<sb-1;x++)
				{
					Person1 pb=(Person1) b.get(x);
					if((p.getName()).equals(pb.getName()) && p.getAge()==pb.getAge())
					{
						b.remove(p);
						break w;
					}
				}
				
			}
			else
			{
				b.add(p);
			}
		}
		return b;
	}
	
	
	public static ArrayList singleElement(ArrayList a)
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
		return b;

	}
	public static void printPerson(ArrayList a)
	{
		ListIterator it=a.listIterator();
		while(it.hasNext())
		{
			Person1 p=(Person1) it.next();
			System.out.print(p.getName()+".."+p.getAge()+"\t");
		}
		System.out.println();
	}
}
