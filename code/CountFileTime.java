package aban;

import java.io.*;
import  java.util.*;
public class CountFileTime {
	public static void main(String[] args) throws IOException 
	{
		Properties prop=new Properties();
		
		File file=new File("count.ini");
		if(!file.exists())
		{
			file.createNewFile();
//			prop.setProperty("count", "0");
		}
		
		FileInputStream fis=new FileInputStream(file);
		prop.load(fis);
		String value=prop.getProperty("count");
		int time=0;
		if(value!=null)
		{
			time=Integer.parseInt(value);
			if(time>=5)
				{
					System.out.println("使用次数已到");
					return;
				}
		}
		
//		if(time>=5)
//		{
//			System.out.println("使用次数已到");
//			return;
//		}
			
		time++;
		prop.setProperty("count", time+"");
		FileOutputStream fos=new FileOutputStream(file);
		prop.store(fos, "new");
	}
}
