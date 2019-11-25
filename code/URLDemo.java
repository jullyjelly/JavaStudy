package aban;

import java.net.*;

public class URLDemo {
	public static void main(String[] args)  throws Exception
	{
		URL url=new URL("http://10.108.53.126:8080/myweb/demo.html?name=hh&age=30");
		System.out.println(url.getFile());///myweb/demo.html?name=hh&age=30
		System.out.println(url.getHost() );//10.108.53.126
		System.out.println(url.getPath());///myweb/demo.html
		System.out.println(url.getPort());//8080
		System.out.println(url.getProtocol());//http
		System.out.println(url.getQuery() );//name=hh&age=30
	}
}
/**
 * String getFile() 
获取此 URL的文件名。  
String getHost() 
获取此 URL的主机名（如适用）。  
String getPath() 
获取此 URL的路径部分。  
int getPort() 
获取此 URL的端口号。  
String getProtocol() 
获取此 URL的协议名称。  
String getQuery() 
获取此 URL的查询部分。  
 */