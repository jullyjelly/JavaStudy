package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("����û�(a)  �����û�(b)  ɾ���û�(c)\n��ѡ��������ͣ�");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String type=br.readLine();
			if("a".equals(type)) {
				Student stu=new Student();
				System.out.print("������ѧ��������");
				String name=br.readLine();
				stu.setName(name);
				System.out.print("������ѧ��׼��֤�ţ�");
				String examid=br.readLine();
				stu.setExamid(examid);
				System.out.print("������ѧ�����֤�ţ�");
				String idcard=br.readLine();
				stu.setIdcard(idcard);
				System.out.print("������ѧ�����ڵأ�");
				String location=br.readLine();
				stu.setLocation(location);
				System.out.print("������ѧ���ɼ���");
				while(true) {
					try {
						String grade = br.readLine();
						stu.setGrade(Double.parseDouble(grade));
						break;
					} catch (Exception e) {
						System.out.print("�����������ʹ���,���������룺");// TODO: handle exception
					}
				}
				
				StudentDao studao=new StudentDao();
				studao.add(stu);
				System.out.println("--��ӳɹ�--");
				
			}else if("b".equals(type)){
				System.out.print("������ѧ��������");
				String name=br.readLine();
				StudentDao studao=new StudentDao();
				Student stu=studao.find(name); 
				System.out.println("������"+stu.getName()+"  ׼��֤�ţ�"+stu.getExamid()
					+"     ���֤�ţ�"+stu.getIdcard()+"  ����λ�ã�"+stu.getLocation()+
					"  �ɼ���"+stu.getGrade());
			}else if("c".equals(type)){
				System.out.print("������ѧ��������");
				String name=br.readLine();
				StudentDao studao=new StudentDao();
				studao.delect(name);
			}else {
				System.out.println("�쳣");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������");
			
		}
	}

}
