package aban;

import java.net.*;
import java.io.*;
/*�����ϴ�ͼƬ*/
/*�ͻ��ˣ�
 * 1.��������˵�
 * 2.��ȡ�ͻ����е�ͼƬ����
 * 3.ͨ��Socket�������ͼƬ���������
 * 4.��ȡ����˷�����Ϣ
 * 5.�ر�*/
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
		out.write("ͼƬ����ɹ�");
		out.flush();
//		OutputStream out=s.getOutputStream();
//		out.write("ͼƬ����ɹ�".getBytes());
		s.close();
		ss.close();
		fos.close();
	}
}
public class TCPPciture {

}
