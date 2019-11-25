package aban;

import java.net.*;
import java.io.*;
class MyIE
{
	public static void main(String[] args)  throws Exception
	{
		Socket s=new Socket("10.108.53.126",8080);
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		out.println("GET /myweb/demo.html HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 10.108.50.213:10008");
		out.println("Connection: Keep-Alive");
		out.println();
		out.println();
		
		BufferedReader bfr=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			System.out.println(line);
		}
		s.close();
	}
}
public class IEDemo {
	

}
