package aban;


import java.io.*;
import java.util.*;
public class ProperiesDemo {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader bfr=new BufferedReader(new FileReader("FileReaderCopy.txt"));
		Properties prop =new Properties();
//		prop.setProperty("j1", "43") ;
//		prop.setProperty("j2", "16") ;
//		prop.setProperty("j4", "13") ;
//		prop.setProperty("j3", "17") ;
//		
//		prop.setProperty("j1", "18");
//		Set<String> names=prop.stringPropertyNames();
//		for(String s:names)
//		{
//			System.out.println(s+":"+prop.getProperty(s));
//		}
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			String[] s=line.split("::");
			if(s.length==2)
			{
				prop.setProperty(s[0], s[1]);
			}
		}
		bfr.close();
		System.out.println(prop.getProperty("sun.boot.library.path"));
	}
}
