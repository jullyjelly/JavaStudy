package aban;

import java.io.*;
//子那个定义一个类中包含和readLine一致的方法
public class BufferedReaderDemo {
	public static void main(String[] args) 
	{
		
		MyBufferedReader mbfr=null;
		try
		{	
			FileReader fr=new FileReader("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\InterDemo.java");
			mbfr=new MyBufferedReader(fr);
			String s=null;
			while((s=mbfr.myReadLine())!=null)
			{
				System.out.println(s);
			}
		}
		catch(IOException e)
		{
			System.out.println("读取失败");
		}
		finally
		{
			try
			{
				if(mbfr!=null)
					mbfr.myClose();
			}
			catch(IOException e)
			{
				System.out.println("读取关闭失败");
			}
		}
	}
}
class MyBufferedReader
{
	private FileReader r;
	MyBufferedReader(FileReader r)
	{
		this.r=r;
	}
	public String myReadLine() throws IOException
	{
		//定义一个临时容器StringBuilder
		StringBuilder sb=new StringBuilder();
		int  ch=0;
		while((ch=r.read())!=-1)
		{
			if(ch=='\r')
				continue;
			else if(ch=='\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}
	public void myClose() throws IOException
	{
		r.close();
	}
}