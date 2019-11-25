package aban;

import java.net.*;
import java.io.*;
/*需求：上传图片*/
/*客户端：
 * 1.建立服务端点
 * 2.获取客户已有的图片数据
 * 3.通过Socket输出流将图片发给服务端
 * 4.读取服务端反馈信息
 * 5.关闭*/
class PictClient
{
	public static void main(String[] args)  throws Exception
	{
		Socket s=new Socket("10.108.50.213",10005);
		FileInputStream fis=new FileInputStream("C:\\Users\\Jian\\Documents\\improtant\\Jull\\leap.jpg");
		OutputStream ops=s.getOutputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=fis.read(buf))!=-1)
		{
			ops.write(buf,0,len);
			ops.flush(); 
		}
		s.shutdownOutput();
		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String rec=bfIn.readLine();
		System.out.println(rec);
//		InputStream is=s.getInputStream();
//		byte[] rec=new byte[1024];
//		int l=is.read(rec);
//		System.out.print(new String(rec,0,l));
		s.close();
		fis.close();
	}
	
	
}
class PictServer
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10005);
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");
		InputStream in=s.getInputStream();
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Jian\\eclipse-workspace\\test\\FileReaderCopy.jpg");
		byte[] buf=new byte[1024];
		int len=0;
		while((len=in.read(buf))!=-1)
		{
			fos.write(buf,0,len);
			fos.flush();
		}
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		out.write("图片传输成功");
		out.flush();
//		OutputStream out=s.getOutputStream();
//		out.write("图片传输成功".getBytes());
		s.close();
		ss.close();
		fos.close();
	}
}
public class TCPPciture {

}
