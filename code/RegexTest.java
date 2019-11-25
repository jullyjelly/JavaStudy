package aban;

import java.util.*;

public class RegexTest {
	public static void main(String[] args)
	{
		test3();
	}
	public static void test3()
	{
		String email="abc123@sina.com.cnpp";
		System.out.println(email.matches("[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}"));
		System.out.println(email.matches("\\w+@\\w+(\\.\\w+)+"));//��Ϊģ����ƥ��
	}
	/*����ip��ַ��������Ȼ˳���������*/
	public static void test2()
	{
		String str="192.168.1.1 102.149.3.6 2.2.2.2 3.6.142.8";
		str=str.replaceAll("(\\d+)", "00$1");
		str=str.replaceAll("0*(\\d{3})", "$1");
		System.out.println(str);
		String[] arr=str.split(" ");
		TreeSet<String> ts=new TreeSet<>();
		for(String s:arr)
		{
			ts.add(s);
//			System.out.println(s);
		}
		for(String s:ts)
		{
			System.out.println(s.replaceAll("0*(\\d+)", "$1"));
		}
			
	}
	public static void test1()
	{
		String str="������......����ҪҪ...Ҫ ѧѧ...ѧ..ϰϰϰ....ϰϰϰ..�����...�̳̳̳�";
		String reg1="\\.+";
		String reg2="(.)\\1+";
		str=str.replaceAll(reg1, "");
		str=str.replaceAll(reg2, "$1");
		System.out.println(str);
	}
}
