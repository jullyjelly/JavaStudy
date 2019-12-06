package cont;

import java.lang.reflect.*;
public class reflectGetField {
	public static void main(String[] args) throws Exception{
		getFile_1();
	}
	public static void getFile_1() throws Exception{
		String className="cont.Person";
		Class class1=Class.forName(className);
		
		Object obj=class1.newInstance();
		
		String FieldName="age";//public 
        //这里age的修饰符若为private则会报错
		Field field=class1.getField(FieldName);
		System.out.println(field);
		field.set(obj,30);
		System.out.println(field.get(obj));


        String FieldName1="name";//private
        Field field1=class1.getDeclaredField(FieldName1);
		System.out.println(field1);
		
		field1.setAccessible(true);
		field1.set(obj,"haha");
		System.out.println(field1.get(obj));
	}
}
