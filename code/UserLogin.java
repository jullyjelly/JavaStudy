package aban;

import java.net.*;
import java.io.*;
/*
 * 只能登录三次*/
class LoginUser
{
	public static void main(String[] args)  throws Exception
	{
		Socket s=new Socket("10.108.50.213",10006);
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		for(int x=0;x<3;x++)
		{
			String data=bfr.readLine();
			if(data==null)
				break;
			
			out.println(data);
			String info=in.readLine();
			System.out.println(info);
			if(info.contains("欢迎"))
				break;
		}
		bfr.close();
		s.close();
	}
}
class ThreadLogin implements Runnable
{
	private Socket s;
	ThreadLogin(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+" is conncted");
		try
		{
			w:for(int x=0;x<3;x++)
			{
				BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				String name=in.readLine();
				if(name==null)
					break;
				BufferedReader bfr=new BufferedReader(
						new FileReader(new File("C:\\Users\\Jian\\eclipse-workspace\\test\\user.txt")));
				PrintWriter out=new PrintWriter(s.getOutputStream(),true);
				String line=null;
				boolean flag=false;
				while((line=bfr.readLine())!=null)
				{
					if(line.equals(name))
					{
						flag=true;
						break;
					}	
				}
				if(flag) 
				{
					System.out.println(name+",已登录");
					out.println(name+",欢迎光临");
					break w;
				}
				else
				{
					System.out.println(name+",尝试登录");
					out.println(name+",用户名不存在");
				}
			}
			s.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException(ip+" 校验失败");
		}
	}
}
class LoginServer
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket ss=new ServerSocket(10006);
		
		while(true)
		{
			Socket s=ss.accept();
			new Thread(new ThreadLogin(s)).start();
		}
	}
}
public class UserLogin {
	
}
