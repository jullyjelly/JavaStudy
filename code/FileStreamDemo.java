package aban;

import java.io.*;

public class FileStreamDemo {
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fos=new FileOutputStream("FileReaderCopy.txt");
		fos.write("sdfgssdfghlklpoqw\r\nezxcbnbm".getBytes());//不需要flush就能存入
		fos.close();
		
		FileInputStream fis=new FileInputStream("FileReaderCopy.txt");
////		int ch=0;
////		while((ch=fis.read())!=-1)
////		{
////			System.out.println((char) ch);
////		}

		byte[] buf=new byte[8];
		int ch=0;
		while((ch=fis.read(buf))!=-1)
		{
			System.out.print(new String(buf,0,ch));
		}
//		byte[] buf=new byte[fis.available()];//定义一个刚刚好的缓冲区，不需要再循环
//		fis.read(buf);
//		System.out.println(new String(buf));
		
		fis.close();
	}
}
