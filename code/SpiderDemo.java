package aban;

import java.io.*;
import java.net.*;
import java.util.regex.*;
public class SpiderDemo {
	public static void main(String[] args) throws IOException
	{
//		sp2();
		mysp();
	}
	public static void mysp() throws IOException
	{
		URL u=new URL("https://deerchao.cn/tutorials/regex/regex.htm");
		URLConnection con=u.openConnection();
		BufferedReader bfr=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			System.out.println(line);
		}
	}
	public static void sp2() throws IOException
	{
		URL u=new URL("http://10.108.65.218:8080/myweb/demo.html");
		URLConnection con=u.openConnection();
		BufferedReader bfr=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line=null;
		String mreg="\\w+@\\w+(\\.\\w+)+";
		Pattern p=Pattern.compile(mreg);
		
		while((line=bfr.readLine())!=null)
		{
			Matcher m=p.matcher(line);
			while(m.find())
			{
				System.out.println(m.group());
			}
			
		}
	}
	public static void sp1() throws IOException
	{
		BufferedReader bfr=new BufferedReader(new FileReader("mail.txt"));
		String line=null;
		String mreg="\\w+@\\w+(\\.\\w+)+";
		Pattern p=Pattern.compile(mreg);
		
		while((line=bfr.readLine())!=null)
		{
			Matcher m=p.matcher(line);
			while(m.find())
			{
				System.out.println(m.group());
			}
			
		}
	}
}
