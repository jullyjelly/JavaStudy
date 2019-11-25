package aban;

/*
 * 需求：将一台机器上的数据传输到另一台机器并保存到文件中*/
import java.net.*;
import java.io.*;
class TCPClient3
{
	public static void main(String[] args)  throws Exception
	{
		Socket s=new Socket("10.108.12.151",10005);
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		
		
		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		FileWriter f=new FileWriter("C:\\Users\\Jian\\eclipse-workspace\\test\\client.txt");
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			if(line.equals("q"))
				break;
			out.println(line);
			
			String data=bfIn.readLine();
			f.write(data+"\r\n");
			f.flush();
			System.out.println(data);
		}
		f.close();
		bfr.close();
		s.close();
	}
}
class TCPServer3
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10005);
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");
		BufferedReader bfIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		FileWriter f=new FileWriter("C:\\Users\\Jian\\eclipse-workspace\\test\\server.txt");
		String data=null;
		
		while((data=bfIn.readLine())!=null)
		{
			f.write(data+"\r\n");
			f.flush();
			out.println(data.toUpperCase());
			System.out.println(data);
		}
		f.close();
		s.close();
		ss.close();
	}
}
public class TCPText {

}
