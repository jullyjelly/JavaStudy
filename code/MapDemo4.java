package aban;


import java.util.*;

class Student implements Comparable<Student>
{
	private String name;
	private int age;
	Student(String name,int age)
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
		if (!(obj instanceof Student))
		{
			throw new ClassCastException("类型不匹配");
		}
		Student s=(Student) obj;
		return this.name.equals(s.name) && this.age==s.age;
	}
	public int compareTo(Student s)
	{
		int num=new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		else
			return num;
	}
}

public class MapDemo4 {
	public static void main(String[] args)
	{
		HashMap<String,List> school=new HashMap<String,List>();
		List<Student> class1=new ArrayList<Student>();
		class1.add(new Student("Aj1",13));
		class1.add(new Student("A1j2",23));
		class1.add(new Student("Aj2341",13));
		class1.add(new Student("Aj43",15));
		//Collections.sort()
		Collections.sort(class1,new NewComp());
		System.out.println(class1);
		//Collections.binarySearch()
		System.out.println(Collections.binarySearch(class1,new Student("Aj1",13),new NewComp()));
		//自定义的Collections.binarySearch(）
		System.out.println(halfSearch(class1,new Student("Cj541",13),new NewComp()));
		//Collections.max()
		System.out.println(Collections.max(class1,new NewComp()));
		//Collections.replaceAll()
		//Collections.fill()
		//Collections.reverse()
		Collections.reverse(class1);
		System.out.println("reverse:"+class1);
		
		List<Student> class2=new ArrayList<Student>();
		class2.add(new Student("Bj1",14));
		class2.add(new Student("Bj2",16));
		class2.add(new Student("Bj1",14));
		class2.add(new Student("Bj3",15));
		school.put("class1",class1);
		school.put("class2",class2);
		Set<String> ss=school.keySet();
		Iterator<String> is=ss.iterator();
		while(is.hasNext())
		{
			String classname=is.next();
			List stus=school.get(classname);
			System.out.println(classname); 
			getInfo(stus);
		}
	} 
	
	public static void getInfo(List<Student> s)
	{
		Iterator<Student> it=s.iterator();
		while(it.hasNext())
		{
			//Student stu=(Student) it.next();
			Student stu=it.next();
			System.out.println(stu.getNmae()+"..."+stu.getAge());
		}
	}
	//自定义查找方法
	public static int halfSearch(List<Student> list, Student stu,Comparator<Student> cmp)
	{
		int min,max,mid;
		max=list.size()-1;
		min=0;
		while(min<max)
		{
			mid=(min+max)>>1;
			Student s=list.get(mid);
			int num=cmp.compare(s,stu);
//			int num=s.compareTo(stu);
			if(num>0)
				max=mid-1;
			else if(num<0)
				min=mid+1;
			else
				return mid;
			
		}
		return -min-1;
	}
}
//自定义比较器
class NewComp implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		if(s1.getNmae().length()>s2.getNmae().length())
			return 1;
		else if(s1.getNmae().length()<s2.getNmae().length())
			return -1;
		else
			return s1.getNmae().compareTo(s2.getNmae());
		
	}
}
