package cont;

import java.lang.reflect.*;
public class refelectGetConstruction {
	public static void main(String[] args) throws Exception{
		getConstruction_1();
	}
	public static void getConstruction_1() throws Exception{
		String className="cont.Person";
		Class class1=Class.forName(className);
		//��ȡָ���Ĺ���������ȡPerson������������ΪString��int�Ĺ��캯��
		Constructor cons=class1.getConstructor(String.class,int.class);//�β�
		
		//���˹��������ͨ����������������ʼ������
		Object obj=cons.newInstance("j1",12);//ʵ��
		System.out.println(obj);
	}

}
