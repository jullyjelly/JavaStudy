package cn.reflect;

import java.lang.reflect.Constructor;
import java.util.*;

import org.junit.Test;



public class demo1 {
	@Test
	public void test1() throws Exception {
		Class clazz = Class.forName("cn.reflect.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);
		System.out.println(p.t);
	}

	@Test
	public void test2() throws Exception {
		Class clazz = Class.forName("cn.reflect.Person");
		Constructor c = clazz.getConstructor(String.class);

		Person p = (Person) c.newInstance("xxxxx");
		System.out.println(p.t);
	}

	@Test
	public void test3() throws Exception {
		Class clazz = Class.forName("cn.reflect.Person");
		Constructor c = clazz.getConstructor(String.class, int.class);
		Person p = (Person) c.newInstance("xxxxx",3);
		System.out.println(p.t);
	}
	@Test
	public void test4() throws Exception {
		Class clazz = Class.forName("cn.reflect.Person");
		Constructor c = clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);
		Person p = (Person) c.newInstance(new ArrayList());
		System.out.println(p.t);
		
	}
	@Test
	public void test5() throws Exception {
		Class clazz = Class.forName("cn.reflect.Person");
		Person p = (Person) clazz.newInstance();
		System.out.println(p.t);
		
	}
}
