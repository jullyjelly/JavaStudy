package aban;

import java.io.*;

public class FileWriterDemo2 {
	public static void main(String[] args)
	{
		FileWriter fw=null;
		try
		{
			fw=new FileWriter("Demo.txt");
			fw.write("abc");
			
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			//if(fw!=null)Ҳ���Է�tryǰ��
			try
			{
				if(fw!=null)
					fw.close();
				
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}
}
