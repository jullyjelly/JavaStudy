package exam;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StudentDao {
	public  void add(Student stu)  {
		try {
			Document doc = xmlUtils.getDocument();
			Element student_tag=doc.createElement("student");
			student_tag.setAttribute("idcard", stu.getIdcard());
			student_tag.setAttribute("examid", stu.getExamid());
			
			Element name=doc.createElement("name");
			name.setTextContent(stu.getName());
			student_tag.appendChild(name);
			
			Element location=doc.createElement("location");
			location.setTextContent(stu.getLocation());
			student_tag.appendChild(location);
			
			Element grade=doc.createElement("grade");
			grade.setTextContent(stu.getGrade()+"");
			student_tag.appendChild(grade);
			
			Element exam=(Element) doc.getElementsByTagName("exam").item(0);
			exam.appendChild(student_tag);
			
			xmlUtils.write2xml(doc);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	public void delect(String name) {
		try {
			Document doc=xmlUtils.getDocument();
			NodeList stunames=doc.getElementsByTagName("name");
			for(int i=0;i<stunames.getLength();i++) {
				if(stunames.item(i).getTextContent().equals(name)) {
					stunames.item(i).getParentNode().getParentNode().removeChild(
							stunames.item(i).getParentNode());
				}
			}
			xmlUtils.write2xml(doc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public Student find(String name) {
		try {
			Student student=new Student();
			Document doc=xmlUtils.getDocument();
			NodeList stunames=doc.getElementsByTagName("name");
			for(int i=0;i<stunames.getLength();i++) {
				if(stunames.item(i).getTextContent().equals(name)) {
					Node stu=stunames.item(i).getParentNode();
					NamedNodeMap infoAttr= stu.getAttributes();

					student.setExamid(infoAttr.getNamedItem("examid").getTextContent());
					student.setIdcard(infoAttr.getNamedItem("idcard").getTextContent());
					
					NodeList infonode=stu.getChildNodes();
					for(int j=0;j<infonode.getLength();j++) {
						if(infonode.item(j).getNodeName().equals("name")) {
							student.setName(infonode.item(j).getTextContent());
						}else if(infonode.item(j).getNodeName().equals("location")) {
							student.setLocation(infonode.item(j).getTextContent());
						}else if(infonode.item(j).getNodeName().equals("grade")) {
							student.setGrade(Double.parseDouble(infonode.item(j).getTextContent()));
						}
						
					}
				}
			}
			return student;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
