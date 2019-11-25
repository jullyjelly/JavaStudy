package aban;
import  java.util.*;

class Person
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int hashCode()
	{
		System.out.println(this.name+"...hashcode");
		return name.hashCode()+age;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
		{
			return false;
		}
		Person p=(Person) obj;
		System.out.println(this.name+"....equals....."+p.name);
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

public class HashSetDemo 
{
	public static void main(String[] args)
	{
		HashSet hs=new HashSet();
		hs.add(new Person("j1",13));
		hs.add(new Person("j2",15));
		hs.add(new Person("j3",6));
		hs.add(new Person("j1",13));
		hs.add(new Person("j3",6));
		Iterator it=hs.iterator();
		while(it.hasNext())
		{
			Person p=(Person) it.next();
			System.out.println(p.getName()+"....."+p.getAge());
		}
		//System.out.println(hs);
	}
}
