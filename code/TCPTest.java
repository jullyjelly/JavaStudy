package aban;

import java.net.*;
import java.io.*;

/*
 * ���󣺽���һ���ı�ת��������
 * �ͻ��˸�����˷����ı������񵥻Ὣ�ı�ת�ɴ�д�ٷ����ͻ���
 * ���ҿͻ��˿��Բ��ϵĽ����ı����������ͻ�������overʱ��ת������*/

/*
 * �ͻ��ˣ���Ȼ�ǲ����豸�ϵ����ݣ���ô�Ϳ���ʹ��io������������io����������˼��
 * Դ������¼��
 * Ŀ�ģ����������
 * ���������ı����ݣ�����ʹ���ַ���
 * 
 * 1.��������
 * 2.��ȡ����¼��
 * 3.�����ݷ��������
 * 4.����˷�������
 * 5.�ر���Դ*/

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
