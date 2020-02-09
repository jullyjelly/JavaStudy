package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class demo1 {
	//µÃµ½dom½âÎöÆ÷
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db=factory.newDocumentBuilder() ;
		System.out.println(db);

		Document doc=db.parse("book.xml");
	}

}
