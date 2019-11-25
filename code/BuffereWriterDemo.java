package aban;

import java.io.*;

public class BuffereWriterDemo {
	public static void main(String[] args) throws IOException
	{
		//创建一个字符写入流对象
		FileWriter fw=new FileWriter("FileReaderCopy.txt");
		//为提高媳妇写入流效率，加入缓冲技术
		//只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可
		BufferedWriter bfw=new BufferedWriter(fw);
		for(int x=1;x<6;x++)
		{
			bfw.write("asdkjfg");
			bfw.newLine();//跨平台换行方法，只有缓冲区才有该方法
			//用到缓冲区就需要刷新
			bfw.flush();
		}
		//关闭缓冲区就是在关闭缓冲区中的流对象
		bfw.close();
		
		
		FileReader fr=new FileReader("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\TDemo.java");
		BufferedReader bfr=new BufferedReader(fr);
		String s1=null;
		while((s1=bfr.readLine())!=null)
		//缓冲区方法，方便于对数据进行一行的读取，当返回空时标书度到了末尾
		{
			System.out.println(s1);
		}
	}
}
