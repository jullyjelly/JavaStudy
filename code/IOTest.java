package aban;

import java.io.*;
import java.util.*;

class Sstudent implements Comparable<Sstudent>
{
	String name;
	int pram1,pram2,pram3,sumPram;
	Sstudent(String name,int pram1,int pram2,int pram3)
	{
		this.name=name;
		this.pram1=pram1;
		this.pram2=pram2;
		this.pram3=pram3;
		sumPram=pram1+pram2+pram3;
	}
	public int compareTo(Sstudent s)
	{
		int num=new Integer(this.sumPram).compareTo(new Integer(s.sumPram));
		if(num==0)
		{
			return this.name.compareTo(s.name);
		}
		else
			return num;
	}
	public int hashCode()
	{
		return name.hashCode()+sumPram*100;
	}
	public boolean equals(Object obj)
	{
		
		if(!(obj instanceof Sstudent))
			throw new ClassCastException("类型错误");
		Sstudent s=(Sstudent) obj;
		return this.name.equals(s.name)&& new Integer(this.sumPram).equals(new Integer(s.sumPram));
	}
	public String toString()
	{
		return "["+name+","+pram1+","+pram2+","+pram3+","+sumPram+"]";
	}
}
public class IOTest {
	public static void main(String[] args) throws IOException 
	{
		
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		
		TreeSet<Sstudent> ts=new TreeSet<Sstudent>(Collections.reverseOrder());
		String s=null;
		while((s=bfr.readLine())!=null)
		{
			if(s.equals("q"))
			{
				break;
			}
			else
			{
				String[] p=s.split(",");
				if(p.length==4 )
				{
					int pram1=Integer.parseInt(p[1]);
					int pram2=Integer.parseInt(p[2]);
					int pram3=Integer.parseInt(p[3]);
					Sstudent ss=new Sstudent(p[0],pram1,pram2,pram3);
					ts.add(ss);
				}
			}
		}
		BufferedWriter bfw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("FileReaderCopy.txt")));
		bfw.write("姓名\t语文\t数学\t英语\t总分");
		bfw.flush();
		bfw.newLine();
		Iterator<Sstudent> it=ts.iterator();
		while(it.hasNext())
		{
			Sstudent stu=it.next();
			String info=stu.name+"\t"+stu.pram1+"\t"+stu.pram2+"\t"+stu.pram3+"\t"+stu.sumPram;
			//bfw.write(info);
			bfw.write(stu.toString());
			bfw.flush();
			bfw.newLine();
		}
		bfr.close();
		bfw.close();
	}
}
