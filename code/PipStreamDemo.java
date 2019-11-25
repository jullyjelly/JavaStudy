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
				System.out.println(x+"��δ��ȡ����");
				int ch=in.read(buf);
				System.out.println(x+"�Ѿ���ȡ����"+Thread.currentThread().getName());
				String s=new String(buf,0,ch);
				System.out.println(x+s);
			}
			in.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("�ܵ�����ȡʧ��");
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
				System.out.println(x+"����д�룬�ȴ�2�롣������");
				Thread.sleep(800);
				out.write("pip is here".getBytes());
				System.out.println(x+"д�����"+Thread.currentThread().getName());
			}

			out.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("�ܵ���д��ʧ��");
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
