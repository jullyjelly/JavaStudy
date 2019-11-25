package aban;

import java.io.*;

public class DirList {
	public static void main(String[] args) throws IOException
	{
		File dir=new File("C:\\Users\\Jian\\eclipse-workspace\\test");
		BufferedWriter bfw=new BufferedWriter(new FileWriter("FileReaderCopy.txt"));
		writeDir(dir,bfw,0);
		bfw.close();
	}
	public static void writeDir(File dir,BufferedWriter bfw,int level) throws IOException
	{
		File[] files=dir.listFiles();
		bfw.write(getLevel(level)+dir.toString()+"======");
		bfw.newLine();
		bfw.flush();
		level++;
		for(File f:files)
		{
			if(f.isDirectory())
				writeDir(f,bfw,level);
		}
		String[] lists=dir.list(new FilenameFilter()
		{
			public boolean accept(File dir,String name)
			{
				return name.endsWith(".java");
			}
		});
		for(String s:lists)
		{
			bfw.write(getLevel(level)+s);
			bfw.newLine();
			bfw.flush();
		}
		
	}
	public static String getLevel(int level)
	{
		StringBuilder sb=new StringBuilder();
		for(int x=0;x<level;x++)
		{
			sb.append("    ");
		}
		return sb.toString();
	}
}
