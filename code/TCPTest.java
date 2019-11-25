package aban;

import java.net.*;
import java.io.*;

/*
 * 需求：建立一个文本转换服务器
 * 客户端给服务端发送文本，服务单会将文本转成大写再发给客户端
 * 而且客户端可以不断的进行文本交换，当客户端输入over时，转换结束*/

/*
 * 客户端：既然是操作设备上的数据，那么就可以使用io技术，并按照io操作规律来思考
 * 源：键盘录入
 * 目的：网络输出流
 * 操作的是文本数据，可以使用字符流
 * 
 * 1.建立服务
 * 2.获取键盘录入
 * 3.将数据发给服务端
 * 4.服务端返回数据
 * 5.关闭资源*/

class TransClient
{
	public static void main(String[] args)  throws Exception
	{
		Socket s=new Socket("10.108.37.190",10003);
		//OutputStream out=s.getOutputStream();
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bfOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter bfOut=new PrintWriter(s.getOutputStream(),true);
		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			if(line.equals("q"))
				break;
			bfOut.println(line);
//			bfOut.write(line);
//			bfOut.newLine();
//			bfOut.flush();
			String str=bfIn.readLine();
			System.out.println(str);
		}
		
		bfr.close();
		s.close();
	}
}

class TransSever
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10003);
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");
		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
//		BufferedWriter bfOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter bfOut=new PrintWriter(s.getOutputStream(),true);
		String data=null;
		while((data=bfIn.readLine())!=null)
		{
			bfOut.println(data.toUpperCase());
//			bfOut.write(data.toUpperCase());
//			bfOut.newLine();
//			bfOut.flush();
			System.out.println(data);
		}
		s.close();
		ss.close();
	}
}
public class TCPTest {

}
