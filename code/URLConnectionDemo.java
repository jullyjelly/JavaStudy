package aban;

import java.io.*;
import java.net.*;
public class URLConnectionDemo {
	public static void main(String[] args)  throws Exception
	{
		URL url=new URL("http://10.108.53.126:8080/myweb/demo.html");
		URLConnection uc=url.openConnection();
		System.out.println(uc);
		InputStream id=uc.getInputStream();
		byte[] buf=new byte[1024];
		int len=id.read(buf);
		System.out.println(new String(buf,0,len));
	}
}
