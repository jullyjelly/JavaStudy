package aban;

import java.io.*;

public class FileCopy {
	public static void main(String[] args) throws IOException
	{
		FileWriter fw=null;
		FileReader fr=null;
		try
		{
			fw=new FileWriter("FileReaderCopy.txt");
			fr=new FileReader("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\TDemo.java");
			copy_2(fw,fr);
		}
		catch(IOException e)
		{
			throw new RuntimeException("¶ÁÐ´Ê§°Ü");
		}
		finally
		{

			try
			{
				if(fr!=null)
					fr.close();
			}
			catch(IOException e)
			{
				
			}
			try
			{
				if(fw!=null)
					fw.close();
			}
			catch(IOException e)
			{
				
			}
		}
	}
	public static void copy_1(FileWriter fw,FileReader fr) throws IOException
	{
		int ch=0;
		while((ch=fr.read())!=-1)
		{
			fw.write(ch);
		}
	}
	public static void copy_2(FileWriter fw,FileReader fr) throws IOException
	{
		int len=0;
		char[] buf=new char[1024];
		while((len=fr.read(buf))!=-1)
		{
			fw.write(buf,0,len);
		}
	}
}
