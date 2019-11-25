package aban;

import java.io.*;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException
	{
		//创建一个FileWriter对象，该对象一初始化就要明确被操作的文件
		//而该文件会被创建到指定目录下，如果该目录下已有同名文件将被覆盖
		//这一步是为了明确数据要存放的目的地
		FileWriter fw=new FileWriter("Demo.txt");
		//调用write方法将字符串写到流中
		fw.write("abc");
		//刷新流对象中的缓冲中的数据
		//将数据刷到目的地中
		//fw.flush();
		//也可用close，关闭流资源，关闭前会刷新一次内部缓冲中的数据，将数据刷到目的地中
		//和flush的区别：flush刷新后还可以继续使用，close刷新后会将流关闭
		fw.close();
		
	}
}
