package aban;

import java.io.*;
public class RemoveDir {
	public static void main(String[] args)
	{
		File dir=new File("C:\\Users\\Jian\\Documents\\improtant\\asdf");
		removeDir(dir);
	}
	public static void removeDir(File dir)
	{
		File[] files=dir.listFiles();
		for(File f:files)
		{
			if(f.isDirectory())
				removeDir(f);
			else
				System.out.println(f.toString()+":"+f.delete());
		}
		dir.delete();
	}
}
