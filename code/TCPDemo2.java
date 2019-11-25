package aban;

/*
 * 客户端和服务端的互访*/
import java.net.*;
import java.io.*;

/*
 *1.建立socket服务，指定要连接的主机和端口
 *2.获取Socket流中的输出流，将数据写到该流中，通过网络发送给服务端
 *3.获取socket流中的输入流，将服务反馈的数据获取到并打印
 *4.关闭客户端资源 */
class TCPClient2
{
	public static void main(String[] args)  throws Exception
	{
		Socket s=new Socket("10.108.37.190",10003);
		OutputStream out=s.getOutputStream();
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		InputStream in=s.getInputStream();
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			if(line.equals("q"))
				break;
			out.write((line).getBytes());
			out.flush();
			
			byte[] buf=new byte[1024];
			int len=in.read(buf);
			System.out.println(new String(buf,0,len));
		}
		bfr.close();
		s.close();
		
//		Socket s=new Socket("10.108.37.190",10003);
//		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bfOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
//		InputStream in=s.getInputStream();
//		String line=null;
//		while((line=bfr.readLine())!=null)
//		{
//			if(line.equals("q"))
//				break;
//			bfOut.write(line);
//			bfOut.newLine();
//			bfOut.flush();
//
//			System.out.println(bfIn.readLine());
//		}
//		bfr.close();
//		s.close();
	}
}

class TCPServer2
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10003);
		Socket s=ss.accept();
		OutputStream out=s.getOutputStream();
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=in.read(buf))!=-1) {
//			String ip=s.getInetAddress().getHostAddress();
//			System.out.println(ip+" connected");
			System.out.println(new String(buf,0,len));
			
			out.write("receive".getBytes());
			out.flush();
		}
		ss.close();
		s.close();
		
		
//		ServerSocket ss=new ServerSocket(10003);
//		Socket s=ss.accept();
//		
//		BufferedWriter bfOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
//		String line=null;
//		while((line=bfIn.readLine())!=null) {
////			String ip=s.getInetAddress().getHostAddress();
////			System.out.println(ip+" connected");
//			System.out.println(line);
//			
//			bfOut.write("receive");
//			bfOut.newLine();
//			bfOut.flush();
//		}
//		ss.close();
//		s.close();
	}
}
public class TCPDemo2 
{
	
}
