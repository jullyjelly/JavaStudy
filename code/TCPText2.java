package aban;

/*
 * ���󣺽�һ̨�����ϵ����ݴ��䵽��һ̨���������浽�ļ���*/
import java.net.*;
import java.io.*;

class TCPClient4
{
	public static void main(String[] args)  throws Exception
	{
		Socket s=new Socket("10.108.12.151",10005);
		BufferedReader bfr=
				new BufferedReader(new FileReader("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\IPDemo.java"));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		System.out.println("IPDemo.java");
		
		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			out.println(line);
		}
//		out.println("q");
		s.shutdownOutput();
		
		String data=bfIn.readLine();
		System.out.println(data);
		s.close();
		bfr.close();
	}
}

class TCPServer4
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10005);
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");

		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter bfOut=new BufferedWriter(new FileWriter("C:\\Users\\Jian\\eclipse-workspace\\test\\server.txt"));
		
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		String data=null;
		while((data=bfIn.readLine())!=null)
		{
//			if(data.equals("q"))
//				break;
			bfOut.write(data);
			bfOut.newLine();
			bfOut.flush();
		}
		out.println("���ݴ���ɹ�");
		s.close();
		ss.close();
	}
}
public class TCPText2 {

}
