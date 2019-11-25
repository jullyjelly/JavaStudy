package aban;


/*
 * TCP���䣺
 * tcp�ֿͻ��˺ͷ����
 * �ͻ��˶�Ӧ�Ķ�����Socket
 * ����˶�Ӧ�Ķ������SeverSocket
 * */
import java.net.*;
import java.io.*;
/*
 * Socket�ڸö�����ʱ�Կ�������ָ��������
 * TCP���������ӵģ������ڽ�������ʱ��Ҫ�з���˴��ڲ����ӳɹ����γ�ͨ·���ڸ�ͨ���������ݴ���
 * 
 * 
 * 
 * ���裺
 * 1.����Socket����ָ��Ҫ���ӵ������Ͷ˿�
 * */
class TCPClient 
{
	public static void main(String[] args)  throws Exception
	{
		//�����ͻ��˵�Socket����ָ��Ŀ�������ʹ���
		Socket s=new Socket("10.108.37.190",10003);
		//�������ݣ���ȡsocket���е������
		OutputStream out=s.getOutputStream();
		out.write("this is a tcp data".getBytes());
		
		s.close();
	}
}


/*
 * ���󣺶���˵�������ݲ���ӡ�ڿ���̨��
 * 
 * 1.��������˵�Socket����SeverSocket,������һ���˿�
 * 2.��ȡ���ӹ����Ŀͻ��˶���ͨ��Socket��accept������ɣ�û�����Ӿͻ�ȴ������������������ʽ��
 * 3.�ͻ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󣬲���ȡ���ÿͻ��˶���Ķ�ȡ������ȡ�����������ݲ���ӡ�ڿ���̨
 * 4.�رշ���ˣ���ѡ��*/
class TCPSever 
{
	public static void main(String[] args)  throws Exception
	{
		//����������Soclet���񲢼���һ���˿�
		ServerSocket ss=new ServerSocket(10003);
		//ͨ��accept������ȡ���ӹ����Ŀͻ��˶���
		Socket s=ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");
		//��ȡ�ͻ��˷��͹��������ݣ�ʹ�ÿͻ��˶���Ķ�ȡ��
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		System.out.println(new String(buf,0,len));
		//�رտͻ���
		s.close();
		ss.close();//�رշ����
	}
}

public class SocketDemo {

}
