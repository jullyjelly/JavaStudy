package aban;

import java.io.*;
public class FileDemo {
	public static void main(String[] args)
	{
		File f1=new File("C:\\Users\\Jian\\Documents\\improtant\\Jull\\a.txt");
		File f2=new File("FileReaderCopy.txt");
		File d=new File("C:\\Users\\Jian\\Documents\\improtant\\Jull");
		File f3=new File(d,"b.txt");
		File f4=new File("C:"+File.separator+"Users"+File.separator+"Jian"+
				File.separator+"Documents"+File.separator+"improtant"+File.separator+"Jull"+File.separator+"a.txt");
	}
}
