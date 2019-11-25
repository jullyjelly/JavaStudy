package test;

abstract class Stu
{
	public abstract void study();
	public void sleep()
	{
		System.out.println("tangzhe");
	}

}

class BaseStudent extends Stu
{
	public void study()
	{
		System.out.println("BaseStudy");
	}
	public void sleep()
	{
		System.out.println("zuozhe");
	}
}


class AdvStudent extends Stu
{
	public void study()
	{
		System.out.println("AdvStudy");
	}
}

class DoStudent
{
	public static void dosome(Stu s)
	//DoStudent(Stu s)
	{
		s.sleep();
		s.study();
	}
}


public class DuoTaiDemo {
	public static void main (String[] args)
	{
		Stu a = new AdvStudent();
		//a.study();
		//a.sleep();
		DoStudent d =new DoStudent();
		d.dosome(a);
		DoStudent.dosome(a);
		DoStudent.dosome(new AdvStudent());
		DoStudent.dosome(new BaseStudent());
		//new DoStudent(a);
	}
}
