package test;

abstract class absDemo
{
	abstract void show();
}

class Outer
{
	int x=3;
	
	class Inter extends absDemo//1.�̳�һ����
	{
		int num=7;
		void show()//2.��д
		{
			System.out.println("show"+x);
			System.out.println("num"+num);
		}
		void abs()
		{
			System.out.println("abs"+x);
		}
	}
	
	
	public void function()
	{
		//new Inter().show();//3.��������4.����
		absDemo a =new Inter();
		a.show();
		//Inter c = (Inter) a;
		//c.abs();
		
		absDemo d=new absDemo()//absDemo���������
		{
			int num=9;
			void show()
			{
				System.out.println("show"+x);
				System.out.println("num"+num);
			}
			void abs()
			{
				System.out.println("abs"+x);
			}
		};
		d.show();
		
		
		
		new absDemo()//absDemo���������
		{
			void show()
			{
				System.out.println("haha"+x);
			}
			void abs()
			{
				System.out.println("abs"+x);
			}
		}.show();
		
	}
	
}

public class InterDemo 
{
	public static void main(String[] args)
	{
		new Outer().function();
	}
}
