package aban;

import java.net.*;
import java.io.*;

class PicClient
{
	public static void main(String[] args)  throws Exception
	{
		if(args.length!=1)
		{
			System.out.println("请选择一个jpg格式的文件");
			return;
		}
		File file=new File(args[0]);
		if(!(file.exists() && file.isFile()))
		{
			System.out.println("文件不存在");
			return;
		}
		if(!(file.getName().endsWith(".jpg")))
		{
			System.out.println("文件不是.jpg格式");
			return;
		}
		if(file.length()>1024*1024*5)
		{
			System.out.println("图片过大，可能不是图片文件");
			return;
		}
		Socket s=new Socket("10.108.50.213",10005);
		FileInputStream fis=new FileInputStream(file);
		OutputStream ops=s.getOutputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=fis.read(buf))!=-1)
		{
			ops.write(buf,0,len);
			ops.flush(); 
		}
		s.shutdownOutput();
		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String rec=bfIn.readLine();
		System.out.println(rec);
//		InputStream is=s.getInputStream();
//		byte[] rec=new byte[1024];
//		int l=is.read(rec);
//		System.out.print(new String(rec,0,l));
		s.close();
		fis.close();
	}
	
	
}
class PicThread implements Runnable
{
	private Socket s;
	PicThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		int count=0;
		try
		{
			FileOutputStream fos=null;
			String ip=s.getInetAddress().getHostAddress();
			System.out.println(ip+" connected");
			InputStream in=s.getInputStream();
			File f=new File("C:\\Users\\Jian\\eclipse-workspace\\test\\FileReaderCopy.jpg");
			while(f.exists())
				f=new File("C:\\Users\\Jian\\eclipse-workspace\\test\\FileReaderCopy("+(++count)+").jpg");
			fos=new FileOutputStream(f);
			byte[] buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))!=-1)
			{
				fos.write(buf,0,len);
				fos.flush();
			}
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);
			out.println("图片传输成功");
			s.close();
			fos.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("图片传输失败");
		}
	}
}

class PicServer
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10005);
		while(true)
		{
			Socket s=ss.accept();
			new Thread(new PicThread(s)).start();
		}
	}
}
public class TCPThread {

}
