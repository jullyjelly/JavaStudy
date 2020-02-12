package java44j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class demo2 {

	private Document doc;
	@Before
	public void before() throws DocumentException {
		SAXReader reader=new SAXReader();
		doc=reader.read("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml");
	}
	
	@Test
	public void test1() {
//		Element ele=(Element) doc.selectSingleNode("//作者");
		
		Element e = (Element) doc.selectNodes("//作者").get(1);
		System.out.println(e.getText());
	}
	@After
	public void after() throws IOException {
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer=new XMLWriter(new FileOutputStream("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"),format);
		writer.write(doc);
		writer.close();
	}
}
