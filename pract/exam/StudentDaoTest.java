package exam;

import org.junit.Test;

public class StudentDaoTest {
	@Test
	public void testAdd() {
		Student stu=new Student();
		stu.setIdcard("111");
		stu.setExamid("aaa");
		stu.setName("haha");
		stu.setLocation("jing");
		stu.setGrade(90);
		StudentDao studao=new StudentDao();
		studao.add(stu);
	}
	
	@Test
	public void testDel() {
		StudentDao studao=new StudentDao();
		studao.delect("haha");
	}
	
	@Test
	public void testFind() {
		StudentDao studao=new StudentDao();
		Student stu=studao.find("jian");
		System.out.println("������"+stu.getName()+"  ׼��֤�ţ�"+stu.getExamid()
			+"     ���֤�ţ�"+stu.getIdcard()+"  ����λ�ã�"+stu.getLocation()+"  �ɼ���"+stu.getGrade());
	}
}
