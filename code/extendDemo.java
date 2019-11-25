package test;

class p
{
	String name;
	int age;
}
class Student extends p
{
	void study()
	{
		System.out.println(name+" good study");
	}
}
class worker extends p
{
	 void work()
	 {
		 System.out.println(name+" good work");
	 }
}

public class extendDemo {
	public static void main(String[] args)
	{
		Student s = new Student();
		s.name = "jian";
		s.age = 23;
		s.study();
	}
}
