package aban;

import java.io.Serializable;

class Per implements Serializable
{
	public static final long serialVersionUID = 42L;
	private String name;
	transient int age;
	static String country="kr";
	Per(String name,int age,String country)
	{
		this.name=name;
		this.age=age;
		this.country=country;
	}
	public String toString()
	{
		return name+":"+age+":"+country;
	}
}
public class ObjectStreamDemo1 {
	public static void main(String[] args) throws Exception 
	{
		
	}

}
