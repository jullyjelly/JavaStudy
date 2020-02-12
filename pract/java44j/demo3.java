package java44j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class demo3 {
	@Test
	public void test1() throws DocumentException {
		String name="wsgg";
		String psw="763";
		
		SAXReader reader=new SAXReader();
		Document doc=reader.read("C:\\Users\\Jian\\"
				+ "eclipse-workspace\\workclass\\src\\java44j\\users.xml");
		Element ele=(Element) doc.selectSingleNode(
				"//user[@username='"+name+"' and @password='"+psw+"']");
		if(ele!=null) {
			System.out.println("µÇÂ¼³É¹¦");
		}else {
			System.out.println("µÇÂ¼Ê§°Ü");
		}
	}
}
