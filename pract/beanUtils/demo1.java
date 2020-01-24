package beanUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class demo1 {
	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException {
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "haha");

		System.out.println(p.getName());
	}

	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException {
		Person p=new Person();
		String name="aaaa";
		String psw="1m3";
		String age="13";
		String birthday="1999-04-15";
		
		ConvertUtils.register(new Converter()  {

			public  Date convert(Class type, Object value) {
				if(value==null) {
					return null;
				}
				if(!(value instanceof String)) {
					throw new ConversionException("只支持字符串类型的转换");
				}
				String str=(String) value;
				if(str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
			
		}, Date.class);
		
			
		
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "psw", psw);
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPsw());
		System.out.println(p.getBirthday());	
	}
	
	@Test
	public void test3() throws IllegalAccessException, InvocationTargetException {
		Map map=new HashMap();
		map.put("name","aaaa");
		map.put("psw","14b");
		map.put("age","15");
		map.put("birthday","1999-08-15");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person p=new Person();
		BeanUtils.populate(p, map);//用map集合中的值填充bean的属性
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPsw());
		System.out.println(p.getBirthday());
	}
}
