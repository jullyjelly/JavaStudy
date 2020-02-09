package introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;



public class demo1 {
	//得到bean所有属性
	@Test
	public void test1() throws Exception {
		BeanInfo info =Introspector.getBeanInfo(Person.class,Object.class);
		PropertyDescriptor[] prop = info.getPropertyDescriptors();
		
		for(PropertyDescriptor p: prop) {
			System.out.println(p.getName());
		}
		
	}
	//操作bean单个属性
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
	//获取当前操作属性的类型
	@Test
	public void test3() throws Exception {
		Person p=new Person();
		PropertyDescriptor pd=new PropertyDescriptor("age",Person.class);
		
		System.out.println(pd.getPropertyType());
			
	}
	
}
