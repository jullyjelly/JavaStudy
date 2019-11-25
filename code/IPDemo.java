package aban;


import java.net.*;

public class IPDemo {
	public static void main(String[] args) throws UnknownHostException
	{
		InetAddress i=InetAddress.getLocalHost();
		System.out.println(i.toString());
		System.out.println(i.getHostAddress());
		System.out.println(i.getHostName());
		
		InetAddress ia=InetAddress.getByName("www.baidu.com") ;
		System.out.println(ia.toString());
	}
}
