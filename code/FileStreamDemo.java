package aban;

import java.io.*;

public class FileStreamDemo {
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fos=new FileOutputStream("FileReaderCopy.txt");
		fos.write("sdfgssdfghlklpoqw\r\nezxcbnbm".getBytes());//����Ҫflush���ܴ���
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
//		byte[] buf=new byte[fis.available()];//����һ���ոպõĻ�����������Ҫ��ѭ��
//		fis.read(buf);
//		System.out.println(new String(buf));
		
		fis.close();
	}
}
