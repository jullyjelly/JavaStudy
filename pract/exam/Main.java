package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("添加用户(a)  查找用户(b)  删除用户(c)\n请选择操作类型：");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String type=br.readLine();
			if("a".equals(type)) {
				Student stu=new Student();
				System.out.print("请输入学生姓名：");
				String name=br.readLine();
				stu.setName(name);
				System.out.print("请输入学生准考证号：");
				String examid=br.readLine();
				stu.setExamid(examid);
				System.out.print("请输入学生身份证号：");
				String idcard=br.readLine();
				stu.setIdcard(idcard);
				System.out.print("请输入学生所在地：");
				String location=br.readLine();
				stu.setLocation(location);
				System.out.print("请输入学生成绩：");
				while(true) {
					try {
						String grade = br.readLine();
						stu.setGrade(Double.parseDouble(grade));
						break;
					} catch (Exception e) {
						System.out.print("输入数据类型错误,请重新输入：");// TODO: handle exception
					}
				}
				
				StudentDao studao=new StudentDao();
				studao.add(stu);
				System.out.println("--添加成功--");
				
			}else if("b".equals(type)){
				System.out.print("请输入学生姓名：");
				String name=br.readLine();
				StudentDao studao=new StudentDao();
				Student stu=studao.find(name); 
				System.out.println("姓名："+stu.getName()+"  准考证号："+stu.getExamid()
					+"     身份证号："+stu.getIdcard()+"  地理位置："+stu.getLocation()+
					"  成绩："+stu.getGrade());
			}else if("c".equals(type)){
				System.out.print("请输入学生姓名：");
				String name=br.readLine();
				StudentDao studao=new StudentDao();
				studao.delect(name);
			}else {
				System.out.println("异常");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("程序出错");
			
		}
	}

}
