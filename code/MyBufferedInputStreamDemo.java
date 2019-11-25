package aban;

import java.io.*;

public class MyBufferedInputStreamDemo {
	public static void main(String[] args) throws IOException
	{
		long start=System.currentTimeMillis();
		MyBufferedInputStream mbi=new MyBufferedInputStream(new FileInputStream("C:\\Users\\Jian\\Music\\Yiruma - River Flows in You.mp3"));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("FileReaderCopy.mp3"));
		//mbi.myRead();
		
		int len=0;
		//System.out.println("第一个字节"+mbi.myRead());
		while((len=mbi.myRead())!=-1)
		{
			 bos.write(len);
		}
		mbi.myClose();
		bos.close();
		long end=System.currentTimeMillis();;
		System.out.println(end-start);
	}
}
class MyBufferedInputStream
{
	private InputStream in;
	private byte[] buf=new byte[1024];
	private int pos=0,count=0;
	MyBufferedInputStream(InputStream in)
	{
		this.in=in;
	}
	public int myRead() throws IOException
	{
		if(count==0)
		{
			count=in.read(buf);
			if(count<0)
				return -1;
			pos=0;
			byte b=buf[pos];
			count--;
			pos++;
			return b&255;
			//System.out.println(count);
		}
		else if(count>0)	
		{
			byte b=buf[pos];
			count--;
			pos++;
			return b&255;
		}
		return -1;
		
	}
	public void myClose() throws IOException
	{
		in.close();
	}
}