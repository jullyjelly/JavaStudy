package cn.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;

public class demo2 {
	@Test
	public void test1() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Method method = clazz.getMethod("m1", null);
		method.invoke(p, null);
	}
	@Test
	public void test2() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Method method = clazz.getMethod("m1", String.class,int.class);
		method.invoke(p, "haha",32);
	}
	@Test
	public void test3() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Method method = clazz.getMethod("m2", String.class,int[].class);
		Class[] cla=(Class[])method.invoke(p, "haha",new int[] {32,1,14});
		System.out.println(cla[0]);
	}
	@Test
	public void test4() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Method method = clazz.getDeclaredMethod("m2", InputStream.class);
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("C:\\Users\\Jian\\eclipse-workspace\\test\\FileCopy.jpg"));
	}
	@Test
	public void test5() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Method method = clazz.getMethod("m2", int.class);
		method.invoke(null, 3);
	}
	@Test
	public void test6() throws Exception {
		Class clazz=Class.forName("cn.reflect.Person");
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, new Object[] {new String[] {"1","2"}});
	}
}
