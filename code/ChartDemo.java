package aban;


/*
 * 编写一个程序，可以同时收发数据，需要用到多线程技术
 * 收和发是两个不同的动作，所以要定义两个run方法，而且这两个方法要封装到不同的类中
 * */
import java.net.*;
import java.io.*;

class Send implements Runnable
{
	private DatagramSocket ds;
	Send(DatagramSocket ds)
	{
		this.ds=ds;
	}
	public void run()
	{
		try
		{
			BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			while((line=bfr.readLine())!=null)
			{
				if(line.equals("q"))
					break;
				byte[] data=line.getBytes();
				DatagramPacket dp=new DatagramPacket(data,data.length,InetAddress.getByName("10.108.37.190"),10002);
				ds.send(dp);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("发送端失败");
		}
	}
}

class Receive implements Runnable
{
	private DatagramSocket ds;
	Receive(DatagramSocket ds)
	{
		this.ds=ds;
	}
	public void run()
	{
		try
		{
			while(true)
			{
				byte[] buf=new byte[1024];
				DatagramPacket dp=new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				
				String ip=dp.getAddress().getHostAddress();
				String data=new String(dp.getData(),0,dp.getLength());
				System.out.println("dp.getLength:"+dp.getLength());
				int port=dp.getPort();
				System.out.println(ip+"::"+data+"::"+port);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("接收端失败");
		}
	}
}
public class ChartDemo {
	public static void main(String[] args)  throws Exception
	{
		DatagramSocket sendsocket=new DatagramSocket(50001);
		DatagramSocket receivesocket=new DatagramSocket(10002);
		new Thread(new Send(sendsocket)).start();
		new Thread(new Receive(receivesocket)).start();
	}
}
