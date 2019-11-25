package aban;

import java.io.*;
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException 
	{
//		writeFile();
		RandomAccessFile raf=new RandomAccessFile("FileReaderCopy.txt","r");
		readFile(raf);
	}
	public static void readFile(RandomAccessFile raf) throws IOException
	{
		raf.seek(8*3);//���������е�ָ�룬������������λ��
		//raf.skipBytes(8);//����ָ���ֽ�����ֻ��������������ǰ��
		byte[] buf=new byte[4];
		raf.read(buf);
		String name=new String(buf);
		int age=raf.readInt();
		System.out.println(name+":"+age);
//		raf.read(buf);
//		String name1=new String(buf);
//		int age1=raf.readInt();
//		System.out.println(name1+":"+age1);
	}
	public static void writeFile() throws IOException
	{
		RandomAccessFile raf=new RandomAccessFile("FileReaderCopy.txt","rw");
		raf.write("����".getBytes());
		raf.writeInt(98);
		raf.write("����".getBytes());
		raf.writeInt(278);
		raf.skipBytes(8);
		raf.write("����".getBytes());
		raf.writeInt(27);
	}
}
