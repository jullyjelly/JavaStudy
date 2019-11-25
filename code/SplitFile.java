package aban;

import java.io.*;
import java.util.*;
public class SplitFile {
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("FileReaderCopy.jpg");
		fileSlip(fis);
		merge();
	}
	public static void merge() throws IOException
	{
		ArrayList<FileInputStream> a=new ArrayList<FileInputStream>();
		for(int x=1;x<=3;x++)
		{
			a.add(new FileInputStream("FileCopy"+x+".part"));
		}
		Iterator<FileInputStream> it=a.iterator();
		Enumeration<FileInputStream> en=new Enumeration<FileInputStream>()
		{
			public boolean hasMoreElements() 
			{
				return it.hasNext();
			}
			public FileInputStream nextElement()
			{
				return it.next();
			}
		};
		
		SequenceInputStream se=new SequenceInputStream(en) ;
		
		FileOutputStream fos=new FileOutputStream("FileCopy.jpg");
		byte[] buf =new byte[1024];
		int ch=0;
		while((ch=se.read(buf))!=-1)
		{
			fos.write(buf,0,ch);
		}
		se.close();
		fos.close();
	}
	public static void fileSlip(FileInputStream fis) throws IOException 
	{
		FileOutputStream fos=null;
		byte[] buf=new byte[102*102*20];
		int len=0;
		int count=0;
		while((len=fis.read(buf))!=-1)
		{
			count++;
			fos=new FileOutputStream("FileCopy"+count+".part");
			fos.write(buf,0,len);
			fos.close();
		}
		fis.close();
	}
}
