package exam;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class xmlUtils {
	private static String fileName="C:/Users/Jian/eclipse-workspace/workclass/src/exam/exam.xml";
	public static Document getDocument() throws Exception {
		DocumentBuilderFactory docbuildfact= DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder=docbuildfact.newDocumentBuilder();
		Document doc=dbuilder.parse(fileName);
		return doc;
	}
	
	public static void write2xml(Document doc) throws Exception {
		TransformerFactory tf= TransformerFactory.newInstance();  
		Transformer trans=tf.newTransformer();
		trans.transform(new  DOMSource(doc), new StreamResult(new FileOutputStream(fileName)));
	}
}
