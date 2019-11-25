package practice;
import java.util.*;
class Student1 implements Comparable<Student1>
{
	private String name;
	private int age;
	Student1(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public String getNmae()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	} 
	public int hashCode()
	{
		return name.hashCode()+age*34;
	}
	public String toString()
	{
		return name+":"+age;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Student1))
		{
			throw new ClassCastException("¿‡–Õ≤ª∆•≈‰");
		}
		Student1 s=(Student1) obj;
		return this.name.equals(s.name) && this.age==s.age;
	}
	public int compareTo(Student1 s)
	{
		int num=new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		else
			return num;
//		int num=this.name.compareTo(s.name);
//		if(num==0)
//			return new Integer(this.age).compareTo(new Integer(s.age));
//		else
//			return num;
	}
}
public class MapTest {
	public static void main(String[] args)
	{
		HashMap<Student1,String> hm=new HashMap<Student1,String>();
		hm.put(new Student1("ji",12), "beijing");
		hm.put(new Student1("ji",12), "guangdong");
		hm.put(new Student1("j2",14), "guangdong");
		hm.put(new Student1("j3",10), "hubei");
		hm.put(new Student1("j4",16), "zhejiang");
		
		//keyset()
		Set<Student1> s=hm.keySet();
		Iterator<Student1> is=s.iterator();
		while(is.hasNext())
		{
			Student1 key= is.next();
			String addr =hm.get(key);
			System.out.println(key+":"+addr);
		}
		System.out.println("======");
		//entrySet()
		Set<Map.Entry<Student1, String>> ss=hm.entrySet();
		Iterator<Map.Entry<Student1, String>> im=ss.iterator();
		while(im.hasNext())
		{
			Map.Entry<Student1, String> ms=im.next();
			Student1 key=ms.getKey();
			String value =ms.getValue();
			System.out.println(key+":"+value);
		}
		
		TreeMap<Student1,String> tm=new TreeMap<Student1,String>(new StuComp());
		tm.put(new Student1("ji",12), "beijing");
		tm.put(new Student1("ji",12), "guangdong");
		tm.put(new Student1("j2",14), "guangdong");
		tm.put(new Student1("j3",10), "hubei");
		tm.put(new Student1("j4",16), "zhejiang");
		Set<Map.Entry<Student1, String>> sm=tm.entrySet();
		Iterator<Map.Entry<Student1, String>> it=sm.iterator();
		while(it.hasNext())
		{
			Map.Entry<Student1, String> ms=it.next();
			Student1 key=ms.getKey();
			String value=ms.getValue();
			System.out.println(key+"......."+value);
		}
	}

}
class StuComp implements Comparator<Student1>
{
	public int compare(Student1 s1,Student1 s2)
	{
		int num=s1.getNmae().compareTo(s2.getNmae());
		if(num==0)
		{
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		else 
			return num;
	}
}
