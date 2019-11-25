import java.io.*;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException
	{
		FileReader fr=new FileReader("que.java");
		char[] buf =new char[1024];
		int num=0;
		while((num=fr.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,num));
		}
		fr.close();
	}
}