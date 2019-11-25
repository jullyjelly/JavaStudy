package aban;

import java.io.*;
import java.util.*;
import java.text.*;

public class ExceptionInfo {
	public static void main(String[] args) throws IOException
	{
		PrintStream ps=null;
		try
		{
			int[] arr=new int[2];
			System.out.println(arr[3]);
		}
		catch(Exception e)
		{
			try
			{
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s=sdf.format(d);
				
				ps=new PrintStream("FileReaderCopy.txt");
				ps.println(s);
				System.setOut(ps);
			}
			catch(Exception ex)
			{
				
			}
			e.printStackTrace(System.out);
			ps.close();
		}
	}
}
