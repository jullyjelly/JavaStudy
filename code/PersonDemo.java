package test;

class Person
{
	private String name="jian";
	private int age;
	static String country ="CN";
	
	{
		System.out.println(name);
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getNmae()
	{
		return name;
	}
	Person()
	{
		System.out.println(name+","+age);
		cry();
	}
	Person(String n)
	{
		name = n;
		System.out.println(name+","+age);
		cry();
	}
	Person(int a)
	{
		age = a;
		System.out.println(name+","+age);
		cry();
	}
	Person(String n,int a)
	{
		this(n);
		age = a;
		System.out.println(name+","+age);
		cry();
	}
	public void cry()
	{
		System.out.println("cry");
	}
	public void speak()
	{
		System.out.println(name+","+age);
	}
	public void compare(Person p)
	{
		System.out.println(this.age==p.age);
	}
}
class PersonDemo
{
	public static void main(String[] args)
	{
		System.out.println(args);
		Person p1 = new Person("jian",23);
		p1.setName("new");
		p1.cry();
		System.out.println(p1.getNmae());
		p1.speak();
		Person p2 = new Person("user",10);
		p1.compare(p2);
		System.out.println(Person.country);
		System.out.println(p1.country);
	}
}

/*
class Person
{
	private int age;
	public void setAge(int a)
	{
		if(a>0 && a<130)
		{
			age = a;
			speak();
		}
		else
			System.out.println("wrong!");
	}
	public int getAge()
	{
		return age;
	}
	void speak()
	{
		System.out.println(age);
	}
}

class dimend2
{
	public static void main(String[] args)
	{
		Person p =new Person();
		p.setAge(20);
		System.out.println(p.getAge());
		p.speak();
	}
}
*/