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
��ȡ�� URL���ļ�����  
String getHost() 
��ȡ�� URL���������������ã���  
String getPath() 
��ȡ�� URL��·�����֡�  
int getPort() 
��ȡ�� URL�Ķ˿ںš�  
String getProtocol() 
��ȡ�� URL��Э�����ơ�  
String getQuery() 
��ȡ�� URL�Ĳ�ѯ���֡�  
 */