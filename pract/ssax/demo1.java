package ssax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser sp=spf.newSAXParser();
		XMLReader reader=sp.getXMLReader();
		
//		BeanListHandler handler=new BeanListHandler();
//		reader.setContentHandler(handler);
		reader.setContentHandler(new bookNameHandler());
		
		reader.parse("C:\\Users\\Jian\\eclipse-workspace\\workclass\\src\\ssax\\book.xml");
//		System.out.println(handler.getList().size());
	}

}

//�����ݷ�װ��javabean�Ĵ�����
class BeanListHandler extends DefaultHandler{
	private List<Book> list=new ArrayList<Book> ();
	private String currentTagName;
	private Book book;
	public List<Book> getList() {
		return list;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		currentTagName=qName;
		if(qName.equals("��")) {
			book=new Book();
		}		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
 		if(currentTagName !=null && currentTagName.equals("����")) {
			book.setBookName(new String(ch,start,length));
		}if(currentTagName !=null && currentTagName.equals("����")) {
			book.setAuthor(new String(ch,start,length));
		}if(currentTagName !=null && currentTagName.equals("�ۼ�")) {
			book.setPrice(new String(ch,start,length));
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equals("��")){
			list.add(book);
		}
		currentTagName=null;
	}

}



//��ȡ����xml���ݵ��ĵ�������
class ListHandler extends DefaultHandler{

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("<"+qName+">");
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("</"+qName+">");
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(new String(ch,start,length));
	}
}

class bookNameHandler extends DefaultHandler{
	private String currentTagName;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		
		currentTagName=qName;
		for(int i=0;attributes!=null && i<attributes.getLength();i++) {
			String arrtName=attributes.getQName(i);
			String arrtValue=attributes.getValue(arrtName);
			System.out.println(arrtName+":"+arrtValue);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if("����".equals(currentTagName)) {
			System.out.println(new String(ch,start,length));
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
 
}

