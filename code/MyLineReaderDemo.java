package aban;

import java.io.*;
class MyLineReader
{
	private Reader r;
	private int line;
	MyLineReader(Reader r)
	{
		this.r=r;
	}
	public void mySetLine(int num)
	{
		line=num;
	}
	public int myGetLine()
	{
		return line;
	}
	public String myReaderLine() throws IOException
	{
		line++;
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
public class MyLineReaderDemo {
	public static void main(String[] args) throws IOException
	{
		MyLineReader mlr=new MyLineReader(new FileReader("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\InterDemo.java"));
		String s=null;
		mlr.mySetLine(50);
		while((s=mlr.myReaderLine())!=null)
		{
			System.out.println(mlr.myGetLine()+"::"+s);
		}
		mlr.myClose();
	}
}
