package aban;

import java.io.*;
class Read implements Runnable
{
	private PipedInputStream in;
	Read(PipedInputStream in)
	{
		this.in=in;
	}
	public void run()
	{
		try {
			for(int x=0;x<7;x++) 
			{
				byte[] buf=new byte[1024];
				System.out.println(x+"暂未获取数据");
				int ch=in.read(buf);
				System.out.println(x+"已经获取数据"+Thread.currentThread().getName());
				String s=new String(buf,0,ch);
				System.out.println(x+s);
			}
			in.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("管道流读取失败");
		}
	}
}
class Write implements Runnable
{
	private PipedOutputStream out;
	Write(PipedOutputStream out)
	{
		this.out=out;
	}
	public void run()
	{
		try
		{
//			InputStreamReader isr=new InputStreamReader(System.in);
//			int ch=0;
//			while((ch=isr.read())!=-1)
//				out.write(ch);
			for(int x=0;x<7;x++) 
			{
				System.out.println(x+"正在写入，等待2秒。。。。");
				Thread.sleep(800);
				out.write("pip is here".getBytes());
				System.out.println(x+"写入完成"+Thread.currentThread().getName());
			}

			out.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("管道流写入失败");
		}
	}
	
}
public class PipStreamDemo {
	public static void main(String[] args) throws Exception 
	{
		PipedInputStream in=new PipedInputStream();
		PipedOutputStream out=new PipedOutputStream();
		in.connect(out);
		Read r=new Read(in);
		Write w=new Write(out);
		
		new Thread(r).start();
		new Thread(w).start();
	}
}
