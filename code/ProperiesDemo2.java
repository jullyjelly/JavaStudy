package aban;
import java.io.*;
import java.util.*;
public class ProperiesDemo2 {
	public static void main(String[] args) throws IOException 
	{
		Properties prop =new Properties();
		FileInputStream fis=new FileInputStream("FileReaderCopy.txt");
		prop.load(fis);
		
		//System.out.println(prop);
		prop.setProperty("java.runtime.name", "bbbbbbb");
		prop.list(System.out);
		FileOutputStream fos=new FileOutputStream("FileReaderCopy.txt");
		prop.store(fos, "new");
		fis.close();
		fos.close();
	}
}
