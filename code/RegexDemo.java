package aban;

import java.util.regex.*;

public class RegexDemo {
	public static void main(String[] args)
	{
//		checkQQ1();
//		checkQQ2();
//		rep();
		get();
	}
	
	/*
	 * 对QQ号码进行校验
	 * 要求长度5~15之间，0不蹦开头只能是数字*/
	public static void get()
	{
		String str="this is a new test,my alala hsw edsf we";
		String regex="\\b[a-z]{3}\\b";
		//将规则封装成对象
		Pattern p=Pattern.compile(regex);
		//让正则对象和要作用的字符串相关联，获取匹配器对象
		Matcher m=p.matcher(str);
		
//		System.out.println(m.matches());
//		//String类中的matches方法用的就是Pattern和Matcher翠香来完成的，只不过被String对象封装后用起来叫我简单功能却单一
		
		//m.find();//将规则作用到字符串上，并进行符合规则的子串查找
		while(m.find())
		{
			System.out.println(m.group());
			System.out.println(m.start()+"....."+m.end());
		}
	}
	public static void rep()
	{
		String str="asdf234253463dfg2354566765sxc23322535";
		String reg="\\d{5,}";
		str=str.replaceAll(reg, "#");
		System.out.println(str);
		String str1="dksjfkjjwqewaoookjdfdfnnnncsdssdf";
		String reg1="(.)\\1+";
		str1=str1.replaceAll(reg1, "$1");
		System.out.println(str1);
	}
	public static void checkQQ2()
	{
		String qq="12345a";
//		String regex="[1-9][0-9]{4,14}";
		String regex="[1-9]\\d{4,14}";
		boolean flag=qq.matches(regex);
		if(flag)
			System.out.println(qq);
		else
			System.out.println("wrong");
	}
	public static void checkQQ1()
	{
		String qq="3453465745a";
		int len=qq.length();
		if(len>=5 && len<=15)
		{
			if(!qq.startsWith("0"))
			{
				try
				{
					long l=Long.parseLong(qq);
					System.out.println("qq:"+qq);
				}
				catch(NumberFormatException e)
				{
					System.out.println("出现非法字符");
				}
//				char[] arr=qq.toCharArray();
//				boolean flag=true;
//				for(char ch:arr)
//				{
//					if(!(ch>='0'&&ch<='9'))
//					{
//						flag=false;
//						break;
//					}
//				}
//				if(flag)
//				{
//					System.out.println(qq);
//				}
//				else
//				{
//					System.out.println("出现非法字符");
//				}
			}
			else
			{
				System.out.println("不可以0开头");
			}
		}
		else
		{
			System.out.println("长度错误");
		}
	}
}
