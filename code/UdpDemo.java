package aban;


/*
 * 需求：通过upd传输方式将一段文字数据发送出去
 * 思路：
 * 1.建立updsocket服务
 * 2.提供数据并将数据封装到数据包中
 * 3.通过socket服务发送功能，将数据包发送出去
 * 4.关闭资源
 * */

import java.net.*;
import java.io.*;
class UdpSend
{
	public static void main(String[] args)  throws Exception
	{
		//创建udp服务，通过DatagramSocket对象
		DatagramSocket ds=new  DatagramSocket(50000);
		//确定数据，并封装成数据包
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			if(line.equals("q"))
				break;
			byte[] data=line.getBytes();
			DatagramPacket dp=new DatagramPacket(data,data.length,InetAddress.getByName("10.108.37.190"),10000);
			//通过socket服务将已有的数据包发送出去，通过send方法
			ds.send(dp);
		}
		//关闭资源
		ds.close();

	}
}

/*
 * 需求：定义一个应用程序用于接收udp协议传输的数据并处理
 * 
 * 定义udp的接收端
 * 思路：
 * 1.定义updsocket服务，通常会监听一个端口，也就是给这个接收网络应用程序定义数字标识（若不定义，系统会随机分配）
 * 		方便明确哪些数据过来该应用程序可以处理
 * 2.定义一个数据包存储接收到的字节数据,因为诗句包对象中有更多功能可以提取字节数据中的不同数据信息
 * 3.通过socket服务的receive方法将收到的数据存入已定义好的数据包中
 * 4.通过数据包对象特有的功能，将这些不同的数据取出
 * 5.关闭资源
 * */

class UdpRecive 
{
	public static void main(String[] args)  throws Exception
	{
		//创立udp socket，建立端点
		DatagramSocket ds=new  DatagramSocket(10000);
		while(true)
		{
			//定义数据包
			byte[] buf=new byte[1024];
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
//			dp.setPort(10000);
			//通过服务的receive方法将收到的数据存入数据包中
			ds.receive(dp);
			//通过数据包的方法获取其中的数据
			String ip=dp.getAddress().getHostAddress();
			String data=new String(dp.getData(),0,dp.getLength());
			int port=dp.getPort();
			System.out.println(ip+"::"+data+"::"+port);
		}
		
//		//关闭资源
//		ds.close();
	}
}

public class UdpDemo {
	public static void main(String[] args)  throws Exception
	{
		
		
	}
}