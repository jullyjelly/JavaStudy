package aban;

import java.io.*;

public class BuffereWriterDemo {
	public static void main(String[] args) throws IOException
	{
		//����һ���ַ�д��������
		FileWriter fw=new FileWriter("FileReaderCopy.txt");
		//Ϊ���ϱ��д����Ч�ʣ����뻺�弼��
		//ֻҪ����Ҫ�����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯������
		BufferedWriter bfw=new BufferedWriter(fw);
		for(int x=1;x<6;x++)
		{
			bfw.write("asdkjfg");
			bfw.newLine();//��ƽ̨���з�����ֻ�л��������и÷���
			//�õ�����������Ҫˢ��
			bfw.flush();
		}
		//�رջ����������ڹرջ������е�������
		bfw.close();
		
		
		FileReader fr=new FileReader("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\TDemo.java");
		BufferedReader bfr=new BufferedReader(fr);
		String s1=null;
		while((s1=bfr.readLine())!=null)
		//�����������������ڶ����ݽ���һ�еĶ�ȡ�������ؿ�ʱ����ȵ���ĩβ
		{
			System.out.println(s1);
		}
	}
}
