package aban;
import java.util.*;
class Students implements Comparable
{
	private String name;
	private int age;
	Students(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int compareTo(Object obj)
	{
		if(!(obj instanceof Students))
		{
			throw new RuntimeException("不是学生对象"); 
		}
		Students s=(Students) obj;
		if(this.getAge()==s.getAge()&&this.getName().equals(s.getName()))
			return 0;
//		System.out.println(this.name+"...ct...."+s.name);
//		if(this.getAge()>s.getAge())
//			return -1;
//		else if(this.getAge()==s.getAge())
//		{
//			return ~(this.getName().compareTo(s.getName()));
//		}
//		else
		return 1;
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
public class TreeSetDemo {
	public static void main(String[] args)
	{
		TreeSet ts=new TreeSet(new MyCompare());
		ts.add(new Students("j1",24));
		ts.add(new Students("j2",23));
		ts.add(new Students("j3",25));
		ts.add(new Students("j4",18));
		ts.add(new Students("j4",17));
		Iterator it=ts.iterator();
		while(it.hasNext())
		{
			Students s=(Students) it.next();
			System.out.println(s.getName()+"......"+s.getAge());
		}
	}
                                                        
}

class MyCompare implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Students s1=(Students) o1;
		Students s2=(Students) o2;
		int num= new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		if(num==0)
			return s1.getName().compareTo(s2.getName());
		else
			return num;
//		int num=s1.getName().compareTo(s2.getName());
//		if (num==0)
//		{
//			if(s1.getAge()>s2.getAge())
//				return 1;
//			else if(s1.getAge()<s2.getAge())
//				return -1;
//			else
//				return 0;
//		}
//		else
//			return num;
	}
}
