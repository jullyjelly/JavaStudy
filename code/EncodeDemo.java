package aban;

import java.io.*;
import java.util.Arrays;

public class EncodeDemo {
	public static void main(String[] args) throws IOException 
	{
//		DataOutputStream dos=new DataOutputStream(new FileOutputStream("data.txt"));
//		OutputStreamWriter osr=new OutputStreamWriter(new FileOutputStream("FileReaderCopy.txt"));
//		osr.write("ÄãºÃ");
//		osr.flush();
//		osr.close();
		
		InputStreamReader isr=new InputStreamReader(new FileInputStream("FileReaderCopy.txt"),"GBK");
		char[] ch=new char[2];
		int len=isr.read(ch);
		System.out.println(new String(ch,0,len));
		isr.close();
		
		OutputStreamWriter osr=new OutputStreamWriter(new FileOutputStream("t.txt"),"UTF-8");
		osr.write("ÄãºÃ");
		osr.flush();
		osr.close();
		
		
		String s="ÄãºÃ";
		byte[] b1=s.getBytes("GBK");
		byte[] b2=s.getBytes("UTF-8");
		System.out.println(Arrays.toString(b1));
		System.out.println(Arrays.toString(b2));
		
		
		String s1=new String(b1,"UTF-8");
		System.out.println(s1);
		String s2=new String(b2);
		System.out.println(s2);
		
		
		byte[] b11=s1.getBytes("UTF-8");
		System.out.println(Arrays.toString(b11));
		System.out.println(new String(b11));
		
		byte[] b21=s2.getBytes("GBK");
		System.out.println(Arrays.toString(b21));
		System.out.println(new String(b21,"UTF-8"));
	}
}
