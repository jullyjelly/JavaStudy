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
		raf.seek(8*3);//调整对象中的指针，可以随意设置位点
		//raf.skipBytes(8);//跳过指定字节数，只能往后跳不能往前跳
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
		raf.write("张三".getBytes());
		raf.writeInt(98);
		raf.write("李四".getBytes());
		raf.writeInt(278);
		raf.skipBytes(8);
		raf.write("周七".getBytes());
		raf.writeInt(27);
	}
}
