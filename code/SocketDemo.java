package aban;


/*
 * TCP传输：
 * tcp分客户端和服务端
 * 客户端对应的对象是Socket
 * 服务端对应的额对象是SeverSocket
 * */
import java.net.*;
import java.io.*;
/*
 * Socket在该对象建立时皆可以连接指定的主机
 * TCP是面向连接的，所以在建立服务时就要有服务端存在并连接成功，形成通路后在该通道进行数据传输
 * 
 * 
 * 
 * 步骤：
 * 1.创建Socket服务并指定要连接的主机和端口
 * */
class TCPClient 
{
	public static void main(String[] args)  throws Exception
	{
		//创建客户端的Socket服务，指定目的主机和窗口
		Socket s=new Socket("10.108.37.190",10003);
		//发送数据，获取socket流中的输出流
		OutputStream out=s.getOutputStream();
		out.write("this is a tcp data".getBytes());
		
		s.close();
	}
}


/*
 * 需求：定义端点接收数据并打印在控制台上
 * 
 * 1.建立服务端的Socket服务，SeverSocket,并监听一个端口
 * 2.获取连接过来的客户端对象，通过Socket的accept方法完成，没有连接就会等待所以这个方法是阻塞式的
 * 3.客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据并打印在控制台
 * 4.关闭服务端（可选）*/
class TCPSever 
{
	public static void main(String[] args)  throws Exception
	{
		//建立服务器Soclet服务并监听一个端口
		ServerSocket ss=new ServerSocket(10003);
		//通过accept方法获取连接过来的客户端对象
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");
		//获取客户端发送过来的数据，使用客户端对象的读取流
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		System.out.println(new String(buf,0,len));
		//关闭客户端
		s.close();
		ss.close();//关闭服务端
	}
}

public class SocketDemo {

}
