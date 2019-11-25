package practice;

import java.util.*;
import java.lang.*;
class Demo1
{
	public <T>void show(T t)
	{
		System.out.println("show"+"..."+t);
	}
	public <Q>void printp(Q t)
	{
		System.out.println("print"+"..."+t);
	}
}
public class GenericDemo3 {
	public static void main(String[] args)
	{
		Demo1 d=new Demo1();
		d.show("wer");
		d.show(4);
		d.printp(new Integer(7));

	}
}

