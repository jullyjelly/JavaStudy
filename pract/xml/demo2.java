package xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class demo2 {
	Document doc;
	
	@Before
	public void before() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = factory.newDocumentBuilder();
		doc = build.parse("C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\xml\\book.xml");

	}

	// 利用dom完成文档的crud
	@Test
	public void listxml() throws Exception {
		list(doc);

	}

	public void list(Node node) {
		System.out.println(node.getNodeName());
		NodeList li = node.getChildNodes();
		for (int i = 0; i < li.getLength(); i++) {
			Node child = li.item(i);
			list(child);
		}
	}
	
	@Test
	public void test() {
		Node node=doc.getElementsByTagName("书名").item(0);
		String value=node.getTextContent();
		System.out.println(value);
	}
	
	@Test
	public void test2() {
		Node node=doc.getElementsByTagName("售价").item(1);
		Element price=(Element) node;
		String atrval=price.getAttribute("type");
		System.out.println(atrval);
	}
	
	//向xml文件中添加售价节点
	@Test
	public void test3() throws Exception {
		Document doc=this.doc;
		Element price =doc.createElement("售价");
		price.setTextContent("59");
		
		Node book=doc.getElementsByTagName("书").item(0);
		book.appendChild(price);
		
		TransformerFactory transfact=TransformerFactory.newInstance();
		Transformer tf=transfact.newTransformer();
		tf.transform(new DOMSource(doc) , new StreamResult(new FileOutputStream(
				"C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\xml\\book.xml")));
	}
	//向xml文件中指定位置添加售价节点
	@Test
	public void test4() throws Exception {
		Document doc=this.doc;
		Element price =doc.createElement("售价");
		price.setTextContent("59");
		
		Node book=doc.getElementsByTagName("书").item(0);
		book.insertBefore(price, doc.getElementsByTagName("售价").item(0));
		
		TransformerFactory transfact=TransformerFactory.newInstance();
		Transformer tf=transfact.newTransformer();
		tf.transform(new DOMSource(doc) , new StreamResult(new FileOutputStream(
				"C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\xml\\book.xml")));
	}
	
	
	//添加属性
	@Test
	public void test5() throws Exception{
		Document doc=this.doc;
		Element author =(Element) doc.getElementsByTagName("作者").item(0);
		author.setAttribute("id", "12");
		TransformerFactory transfact=TransformerFactory.newInstance();
		Transformer tf=transfact.newTransformer();
		tf.transform(new DOMSource(doc) , new StreamResult(new FileOutputStream(
				"C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\xml\\book.xml")));
		
	}
	@Test
	public void test6() throws Exception{
		Document doc=this.doc;
		Node price=doc.getElementsByTagName("售价").item(0);
		Node par=doc.getElementsByTagName("书").item(0);
		par.removeChild(price);
//		price.getParentNode().removeChild(price);//简单方法
		
		//删除售价节点所在的书节点
//		price.getParentNode().getParentNode().removeChild(price.getParentNode());
		TransformerFactory transfact=TransformerFactory.newInstance();
		Transformer tf=transfact.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(
				"C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\xml\\book.xml")));
	}
	
	@Test
	public void test7() throws Exception{
		Document doc=this.doc;
		Element author=(Element) doc.getElementsByTagName("售价").item(2);
		author.removeAttribute("type");
		
		TransformerFactory transfact=TransformerFactory.newInstance();
		Transformer tf=transfact.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(
				"C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\xml\\book.xml")));
	}
	
	@Test
	public void test8() throws Exception{
		Document doc=this.doc;
		Node price= doc.getElementsByTagName("售价").item(1);
		price.setTextContent("20");
		
		TransformerFactory transfact=TransformerFactory.newInstance();
		Transformer tf=transfact.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(
				"C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\xml\\book.xml")));
	}
}
