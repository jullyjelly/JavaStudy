package practice;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class staticFun {
	public static void main(String[] args) throws IOException
	{
		BufferedWriter bfw=new BufferedWriter(new FileWriter("FileReaderCopy.txt"));
		
		Properties prop=System.getProperties();
		//��ΪProperties��HashTable�����࣬Ҳ����Map���ϵ�һ���������
		//����ͨ��Map����ȡ���ü����е�Ԫ��
		//�ü����д洢�Ķ����ַ�����û�з��Ͷ���
		//Ҳ����StringPropertyName()���������б�ļ���
		for(Object obj:prop.keySet())
		{
			String value=(String)prop.get(obj);
			bfw.write(obj+"...."+value);
			bfw.newLine();
			bfw.flush();
			System.out.println(obj+"...."+value);
		}
		//��ϵͳ���Զ���������Ϣ
		//System.setProperty("mykey","myvalue");
		//��ȡָ��������Ϣ
		String value =System.getProperty("os.name");
		System.out.println("value::"+value);
		//jvm����ʱ��̬����һЩ��Ϣ
		Runtime r=Runtime.getRuntime();
		//r.exec("C:\\Program Files\\MATLAB\\R2018a\\bin\\matlab.exe");
		bfw.close();
		
	}
}
