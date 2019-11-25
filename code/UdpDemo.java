package aban;


/*
 * ����ͨ��upd���䷽ʽ��һ���������ݷ��ͳ�ȥ
 * ˼·��
 * 1.����updsocket����
 * 2.�ṩ���ݲ������ݷ�װ�����ݰ���
 * 3.ͨ��socket�����͹��ܣ������ݰ����ͳ�ȥ
 * 4.�ر���Դ
 * */

import java.net.*;
import java.io.*;
class UdpSend
{
	public static void main(String[] args)  throws Exception
	{
		//����udp����ͨ��DatagramSocket����
		DatagramSocket ds=new  DatagramSocket(50000);
		//ȷ�����ݣ�����װ�����ݰ�
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			if(line.equals("q"))
				break;
			byte[] data=line.getBytes();
			DatagramPacket dp=new DatagramPacket(data,data.length,InetAddress.getByName("10.108.37.190"),10000);
			//ͨ��socket�������е����ݰ����ͳ�ȥ��ͨ��send����
			ds.send(dp);
		}
		//�ر���Դ
		ds.close();

	}
}

/*
 * ���󣺶���һ��Ӧ�ó������ڽ���udpЭ�鴫������ݲ�����
 * 
 * ����udp�Ľ��ն�
 * ˼·��
 * 1.����updsocket����ͨ�������һ���˿ڣ�Ҳ���Ǹ������������Ӧ�ó��������ֱ�ʶ���������壬ϵͳ��������䣩
 * 		������ȷ��Щ���ݹ�����Ӧ�ó�����Դ���
 * 2.����һ�����ݰ��洢���յ����ֽ�����,��Ϊʫ����������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ
 * 3.ͨ��socket�����receive�������յ������ݴ����Ѷ���õ����ݰ���
 * 4.ͨ�����ݰ��������еĹ��ܣ�����Щ��ͬ������ȡ��
 * 5.�ر���Դ
 * */

class UdpRecive 
{
	public static void main(String[] args)  throws Exception
	{
		//����udp socket�������˵�
		DatagramSocket ds=new  DatagramSocket(10000);
		while(true)
		{
			//�������ݰ�
			byte[] buf=new byte[1024];
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
//			dp.setPort(10000);
			//ͨ�������receive�������յ������ݴ������ݰ���
			ds.receive(dp);
			//ͨ�����ݰ��ķ�����ȡ���е�����
			String ip=dp.getAddress().getHostAddress();
			String data=new String(dp.getData(),0,dp.getLength());
			int port=dp.getPort();
			System.out.println(ip+"::"+data+"::"+port);
		}
		
//		//�ر���Դ
//		ds.close();
	}
}

public class UdpDemo {
	public static void main(String[] args)  throws Exception
	{
		
		
	}
}