package cont;

import java.io.*;
import java.util.*;
public class NoteBookMain{
    public static void main(String[] args) throws Exception {
        NoteBook book=new NoteBook();
        book.run();
//        book.useUSB(null);
//        book.useUSB(new MouseByUSB());
    	File configFile = new File("usb.properties");
    	if(!configFile.exists()) {
    		configFile.createNewFile();
    	}
    	
    	//��ȡ�����ļ�
    	FileReader fr = new FileReader(configFile);
    	
    	//Ϊ�˻�ȡ���е���Ϣ���㣬����proerperties
    	Properties prop=new Properties();
    	prop.load(fr);
    	
    	for(int x = 1 ; x <= prop.size(); x++) {
    		String className=prop.getProperty("usb" + x);
    		
    		Class clazz = Class.forName(className);
    		USB usb = (USB) clazz.newInstance();
    		
    		book.useUSB(usb);
    		
    	}
    	fr.close();
    }
}
