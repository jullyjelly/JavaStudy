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
		//因为Properties是HashTable的子类，也就是Map集合的一个子类对象
		//可以通过Map方法取出该集合中的元素
		//该集合中存储的都是字符串，没有泛型定义
		//也可用StringPropertyName()返回属性列表的键集
		for(Object obj:prop.keySet())
		{
			String value=(String)prop.get(obj);
			bfw.write(obj+"...."+value);
			bfw.newLine();
			bfw.flush();
			System.out.println(obj+"...."+value);
		}
		//在系统中自定义特有信息
		//System.setProperty("mykey","myvalue");
		//获取指定属性信息
		String value =System.getProperty("os.name");
		System.out.println("value::"+value);
		//jvm启动时动态加载一些信息
		Runtime r=Runtime.getRuntime();
		//r.exec("C:\\Program Files\\MATLAB\\R2018a\\bin\\matlab.exe");
		bfw.close();
		
	}
}
