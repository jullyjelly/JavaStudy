package aban;

import java.io.*;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException
	{
		//����һ��FileWriter���󣬸ö���һ��ʼ����Ҫ��ȷ���������ļ�
		//�����ļ��ᱻ������ָ��Ŀ¼�£������Ŀ¼������ͬ���ļ���������
		//��һ����Ϊ����ȷ����Ҫ��ŵ�Ŀ�ĵ�
		FileWriter fw=new FileWriter("Demo.txt");
		//����write�������ַ���д������
		fw.write("abc");
		//ˢ���������еĻ����е�����
		//������ˢ��Ŀ�ĵ���
		//fw.flush();
		//Ҳ����close���ر�����Դ���ر�ǰ��ˢ��һ���ڲ������е����ݣ�������ˢ��Ŀ�ĵ���
		//��flush������flushˢ�º󻹿��Լ���ʹ�ã�closeˢ�º�Ὣ���ر�
		fw.close();
		
	}
}
