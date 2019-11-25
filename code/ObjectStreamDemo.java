package aban;

import java.io.*;
public class ObjectStreamDemo {
	public static void main(String[] args) throws Exception 
	{
//		writeObj();
		readObj();
	}
	public static void readObj()throws Exception
	{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("FileReaderCopy.txt"));
		Per p=(Per) ois.readObject();
		System.out.println(p);
		Per p1=(Per) ois.readObject();
		System.out.println(p1);
		Per p2=(Per) ois.readObject();
		System.out.println(p2);
		ois.close();
	}
	public static void writeObj()throws Exception
	{
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("FileReaderCopy.txt"));
		
		oos.writeObject(new Per("jian",23,"cn"));
		oos.writeObject(new Per("mei",23,"cn"));
		oos.writeObject(new Per("jul",24,"cn"));
		oos.close();
	}
}
