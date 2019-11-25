package aban;

import java.io.*;

public class BufferedCopy {
	public static void main(String[] args)
	{
		BufferedReader bfr=null;
		BufferedWriter bfw=null;
		try 
		{
			bfr=new BufferedReader(new FileReader("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\InterDemo.java"));
			bfw=new BufferedWriter(new FileWriter("FileReaderCopy.txt"));
			String line=null;
			while((line=bfr.readLine())!=null)
			{
				bfw.write(line);//��������ֹ��
				bfw.newLine();
				bfw.flush();
			}
		}
		catch(IOException e)
		{
			System.out.println("��дʧ��");
		}
		finally
		{
			try
			{
				if(bfr!=null)
					bfr.close();
			}
			catch(IOException e)
			{
				System.out.println("��ȡ�ر�ʧ��");
			}
			try
			{
				if(bfw!=null)
					bfw.close();
			}
			catch(IOException e)
			{
				System.out.println("д��ر�ʧ��");
			}
		}
	}
}
