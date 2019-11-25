package aban;

import java.io.*;

public class PrintStreamDemo {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		
//		PrintWriter out=new PrintWriter(System.out,true);
//		PrintWriter out=new PrintWriter("FileReaderCopy.txt");
//		PrintWriter out=new PrintWriter(new FileWriter("FileReaderCopy.txt"),true);
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("FileReaderCopy.txt")),true);
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			//out.write(line);
			out.println(line);
			//out.flush();
		}
		bfr.close();
		out.close();
	}
}
