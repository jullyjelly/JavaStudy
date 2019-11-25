package aban;
import java.io.*;
import java.util.*;
public class DirList2 {
	public static void main(String[] args) throws IOException
	{
		File dir=new File("C:\\Users\\Jian\\eclipse-workspace\\test");
		List<File> list=new ArrayList<File>();
		fileToList(dir,list);
		
		System.out.println(list.size());
		
		File f2=new File("FileReaderCopy.txt");
		writeToFile(list,f2);
	}
	public static void fileToList(File dir,List<File> list)
	{
		File[] files=dir.listFiles();
		for(File f:files)
		{
			if(f.isDirectory())
				fileToList(f,list);
			else
			{
				if(f.getName().endsWith(".java"))
				{
					list.add(f);
				}
			}
		}
	}
	public static void writeToFile(List<File> list,File file) throws IOException
	{
		BufferedWriter bfw=new BufferedWriter(new FileWriter(file));
		for(File f:list)
		{
			bfw.write(f.getAbsolutePath());
			bfw.newLine();
			bfw.flush();
		}
		bfw.close();
	}
}
