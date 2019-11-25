package aban;

import java.io.*;
import java.util.*;
public class SequenceDemo {
	public static void main(String[] args) throws IOException 
	{
		Vector<FileInputStream> v=new Vector<FileInputStream>();
		v.add(new FileInputStream("1.txt"));
		v.add(new FileInputStream("2.txt"));
		v.add(new FileInputStream("3.txt"));
		Enumeration<FileInputStream> en=v.elements();
		SequenceInputStream se=new SequenceInputStream(en) ;
		
		FileOutputStream fos=new FileOutputStream("FileReaderCopy.txt");
		byte[] buf=new byte[1024];
		int ch=0;
		while((ch=se.read(buf))!=-1)
		{
			fos.write(buf,0,ch);
			fos.flush();
		}
		se.close();
		fos.close();
	}
}
