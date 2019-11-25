package aban;

import java.net.*;
import java.io.*;
/*
 * 客户端：浏览器
 * 服务端：自定义*/

/*
 * 客户端：浏览器
 * 服务端：Tomcat服务器*/
class ServerDemo
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10007);
		Socket s=ss.accept();
		System.out.println(s.getInetAddress().getHostAddress());
		
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		System.out.println(new String (buf,0,len));
				
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		out.println("<font color='green' size='7'>hello Server</font>");
		s.close();
		ss.close();
	}
}
public class BrowserDemo {
//http:10.108.50.213:10007/
}
