package aban;

import java.io.*;

public class CopyMusicTest {
	public static void main(String[] args) throws IOException
	{
		long start=System.currentTimeMillis();
		FileInputStream fis=new FileInputStream("C:\\Users\\Jian\\Music\\Yiruma - River Flows in You.mp3");
		FileOutputStream fos=new FileOutputStream("FileReaderCopy.mp3");
		
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		byte[] buf=new byte[1024];
		int len=0;
		while((len=bis.read(buf))!=-1)
		{
			 bos.write(buf,0,len);
		}
		bis.close();
		bos.close();
		long end=System.currentTimeMillis();;
		System.out.println(end-start);
	}
}
