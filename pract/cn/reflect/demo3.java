package cn.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class demo3 {
	@Test
	public void test1() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Field f= clazz.getField("t");
		//��ȡ�ֶε�ֵ
		Object value=f.get(p);
		//��ȡ�ֶε�����
		Class type=f.getType();
		
		if(type.equals(String.class)) {
			String svalue=(String) value;
			System.out.println(svalue);
		}
		
		System.out.println(f.get(p));
		
		//�����ֶε�ֵ
		f.set(p, "aaaaaaaaa");
		System.out.println(p.t);
	}
	@Test
	public void test2() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Field f=clazz.getDeclaredField("v");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
	@Test
	public void test3() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Field f=clazz.getDeclaredField("num");
		f.setAccessible(true);
		System.out.println(f.get(null));
	}
}
