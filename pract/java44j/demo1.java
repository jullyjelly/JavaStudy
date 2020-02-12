package java44j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class demo1 {
	@Test
	//遍历xml文档所有标签
	public void listFile() throws DocumentException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\ssax\\book.xml"));
		Element root=doc.getRootElement();
		list(root);
		getPointNode(root);
	}
	
	public void list(Element e) {
		System.out.println(e.getName());
//		for(Iterator<Element> it=e.elementIterator();it.hasNext();){
//			Element ele=it.next();
//			list(ele);
//			System.out.println(ele.getTextTrim());
//			
//		}
		List<Element> list=e.elements();
		for(Element child:list) {
			list(child);
		}
	}
	
	
	public void getPointNode(Element e) {
		//获取<作者 id="12">aa</作者>节点内容
		Element ele=e.element("书").element("作者");
		System.out.println(ele.getText());
		//获取<作者 id="12">aa</作者>节点属性
		Attribute ele2=e.element("书").element("作者").attribute(0);
		System.out.println(ele2.getText());
		System.out.println(e.element("书").element("作者").attributeValue("id")); 
	}
	
	//向xml文档中增加一个售价节点
	@Test
	public void addNode() throws DocumentException, IOException {
		SAXReader sr=new SAXReader();
		Document doc=sr.read(new File("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"));
		
//		Element ee=DocumentHelper.createElement("售价");
//		ee.setText("100");
		Element root=doc.getRootElement();
		Element ele=root.element("书").addElement("售价");
		ele.addAttribute("pprice", "100").addText("123");
		
		
//        XMLWriter writer = new XMLWriter(new OutputStreamWriter
//        		(new FileOutputStream("C:\\Users\\Jian\\"
//        				+ "eclipse-workspace\\workclass\\src\\"
//        				+ "ssax\\book.xml"),"UTF-8"));
		
//        XMLWriter writer = new XMLWriter(new FileWriter("C:\\Users\\Jian\\"
//				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"));
		//以上两种不常用
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");
		XMLWriter writer = new XMLWriter(new FileOutputStream("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"),format);
        writer.write( doc );
        writer.close();

	}
	
	//向xml文档指定位置添加一个售价节点
	@Test
	public void addNode2() throws DocumentException, IOException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"));
		Element root=doc.getRootElement();
		
		Element e=DocumentHelper.createElement("售价");
		e.setText("1000");
		
		List list=root.element("书").elements();
		list.add(2, e);
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"),format);
        writer.write( doc );
        writer.close();
	}
	
	//删除节点
	@Test
	public void delectNode() throws DocumentException, IOException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml");
		
		Element root=doc.getRootElement();
		Element e=root.element("书");
//		e.remove(e.element("售价"));//1.
		
//		List list=e.elements();//2.
//		list.remove(3);
		
		Element delNode=(Element) e.elements("售价").get(1);//3.
		delNode.getParent().remove(delNode);
		
		XMLWriter writer=new XMLWriter(new FileOutputStream("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"));
		writer.write(doc);
		writer.close();
	}
	//修改节点的值
	@Test
	public void changeText() throws DocumentException, IOException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml");
//		Element e=(Element) doc.getRootElement().element("书").elements("售价").get(1);
		//1.
		Element ele=(Element) doc.getRootElement().elements("书").get(1);//2.
		Element e=(Element) ele.elements("售价").get(0) ;
		
		e.setText("修改的20");
		
		XMLWriter writer=new XMLWriter(new FileOutputStream("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"));
		writer.write(doc);
		writer.close();
	}
	
	//根据节点里的内容删除所在节点
	@Test
	public void delFromText() throws DocumentException, IOException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml");
		Element root=doc.getRootElement();
		
		list2(root);

		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer=new XMLWriter(new FileOutputStream("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\ssax\\book.xml"),format);
		writer.write(doc);
		writer.close();
	}
	
	public void list2(Element e) {
		List<Element> list=e.elements();
		for(Element child:list) {
			if("java".equals(child.getText())){
				child.getParent().remove(child);
			}
			list2(child);
		}
	}

}



