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
    	
    	//读取配置文件
    	FileReader fr = new FileReader(configFile);
    	
    	//为了获取其中的信息方便，建立proerperties
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
