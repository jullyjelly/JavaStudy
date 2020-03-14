package java44j;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class xmlUtills {
	private static String fileName="C:\\Users\\Jian\\eclipse-workspace\\"
			+ "workclass\\src\\java44j\\exam.xml";
	private static Document doc;
	public static Document getDocument() throws DocumentException {
		SAXReader reader=new SAXReader();
		doc=reader.read(fileName);
		return doc;
	}
	
	public static void write2xml() throws IOException {
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer=new XMLWriter(new FileOutputStream(fileName));
		writer.write(doc);
		writer.close();
	}
}
