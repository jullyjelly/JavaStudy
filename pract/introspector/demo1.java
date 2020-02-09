package introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;



public class demo1 {
	//�õ�bean��������
	@Test
	public void test1() throws Exception {
		BeanInfo info =Introspector.getBeanInfo(Person.class,Object.class);
		PropertyDescriptor[] prop = info.getPropertyDescriptors();
		
		for(PropertyDescriptor p: prop) {
			System.out.println(p.getName());
		}
		
	}
	//����bean��������
	@Test
	public void test2() throws Exception {
		Person p=new Person();
		PropertyDescriptor pd=new PropertyDescriptor("age",Person.class);
		Method method=pd.getWriteMethod();
		method.invoke(p, 23);
		System.out.println(p.getAge());
		
		method =pd.getReadMethod();
		System.out.println(method.invoke(p, null));
			
	}
	//��ȡ��ǰ�������Ե�����
	@Test
	public void test3() throws Exception {
		Person p=new Person();
		PropertyDescriptor pd=new PropertyDescriptor("age",Person.class);
		
		System.out.println(pd.getPropertyType());
			
	}
	
}
