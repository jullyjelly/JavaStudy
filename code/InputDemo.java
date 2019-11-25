package aban;

import java.io.*;

public class InputDemo {
	public static void main(String[] args) throws IOException
	{
//		InputStream in=System.in;
//		//将字节流对象转换成字符流对象，使用转换流
//		InputStreamReader isr=new InputStreamReader(in);
//		//对字符流使用缓冲区技术
//		BufferedReader br=new BufferedReader(isr);
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Jian\\eclipse-workspace\\test\\src\\aban\\InterDemo.java")));
		
		
		
//		StringBuilder sb=new StringBuilder();
//		while(true)
//		{
//			int ch=in.read();
//			if(ch=='\r')
//				continue;
//			else if(ch=='\n')
//			{
//				String s=sb.toString();
//				if("over".equals(s))
//					break;
//				System.out.println(s);
//				sb.delete(0, sb.length());
//			}
//			else
//				sb.append((char)ch);
//		}
		
//		OutputStream out=System.out;
//		OutputStreamWriter osw=new OutputStreamWriter(out);
//		BufferedWriter bw=new BufferedWriter(osw);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("FileReaderCopy.txt")));
		
		
		String s=null;
		while((s=br.readLine())!=null)
		{
			if("over".equals(s)||"q".equals(s)||"Q".equals(s))
				break;
			bw.write(s);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		
	}
}
