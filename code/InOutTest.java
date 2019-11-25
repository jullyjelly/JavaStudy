package aban;

import java.io.*;

public class InOutTest {
	public static void main(String[] args) throws IOException
	{
		BufferedReader bfr=new BufferedReader(new InputStreamReader(new 
				FileInputStream("t.txt"),"ASCII"));
		BufferedWriter bfw=new BufferedWriter(new FileWriter("FileReaderCopy.txt"));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			bfw.write(line);
			bfw.newLine();
		}
		bfr.close();
		bfw.close();
	}
}
