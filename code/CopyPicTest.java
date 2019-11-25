package aban;

import java.io.*;

public class CopyPicTest {
	public static void main(String[] args) 
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try
		{
			fis=new FileInputStream("C:\\Users\\Jian\\Documents\\improtant\\Jull\\village.jpg");
			fos=new FileOutputStream("FileReaderCopy.jpg");
			byte[] buf=new byte[1024];
			int len=0;
			while((len=fis.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}
		}
		catch(IOException e)
		{
			System.out.println("复制文件失败");
		}
		finally
		{
			try
			{
				if(fis!=null)
					fis.close();
			}
			catch(IOException e)
			{
				System.out.println("读取关闭失败");
			}
			try
			{
				if(fos!=null)
					fos.close();
			}
			catch(IOException e)
			{
				System.out.println("写入关闭失败");
			}
		}
	}
}
