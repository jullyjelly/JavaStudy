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
	 * ��QQ�������У��
	 * Ҫ�󳤶�5~15֮�䣬0���Ŀ�ͷֻ��������*/
	public static void get()
	{
		String str="this is a new test,my alala hsw edsf we";
		String regex="\\b[a-z]{3}\\b";
		//�������װ�ɶ���
		Pattern p=Pattern.compile(regex);
		//����������Ҫ���õ��ַ������������ȡƥ��������
		Matcher m=p.matcher(str);
		
//		System.out.println(m.matches());
//		//String���е�matches�����õľ���Pattern��Matcher��������ɵģ�ֻ������String�����װ�����������Ҽ򵥹���ȴ��һ
		
		//m.find();//���������õ��ַ����ϣ������з��Ϲ�����Ӵ�����
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
					System.out.println("���ַǷ��ַ�");
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
//					System.out.println("���ַǷ��ַ�");
//				}
			}
			else
			{
				System.out.println("������0��ͷ");
			}
		}
		else
		{
			System.out.println("���ȴ���");
		}
	}
}
