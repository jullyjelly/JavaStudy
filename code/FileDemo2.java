package aban;

import java.io.*;
public class FileDemo2 {
	public static void main(String[] args)
	{
		File dir=new File("C:\\Users\\Jian\\Documents\\improtant\\Jull\\java");
		showDir(dir,0);
	}
	public static void showDir(File dir,int level)
	{
		System.out.println(getLevel(level)+dir);
		level++;
		File[] files=dir.listFiles();
		for(File f:files)
		{
			
			if(f.isFile())
				System.out.println(getLevel(level)+f);
			else
				showDir(f,level);	
		}
	}
	public static String getLevel(int level)
	{
		StringBuilder sb=new StringBuilder();
		if(level!=0)
			sb.append("|--");
		for(int x=0;x<level-1;x++)
		{
			//sb.append("    ");
			sb.insert(0,"    ");
		}
//		if(level!=0)
//			sb.append("|--");
		return sb.toString();
	}
}
