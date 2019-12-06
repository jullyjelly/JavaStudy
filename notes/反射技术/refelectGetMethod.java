package cont;

import java.lang.reflect.*;
public class refelectGetMethod {
	public static void main(String[] args) throws Exception{
		getMethod_1();
		getMethod_2();
	}
	public static void getMethod_1() throws Exception{
		String className="cont.Person";
		Class class1=Class.forName(className);
		
		Object obj=class1.newInstance();
		
		String methodName="show";
		Method met=class1.getMethod(methodName, String.class,int.class);
		
		met.invoke(obj, "hi",10);
	}
	public static void getMethod_2() throws Exception{
		String className="cont.Person";
		Class class1=Class.forName(className);
		
		String methodName="staticShow";
		Method met=class1.getMethod(methodName, null);//参数为空
		met.invoke(null, null);//静态方法不需要new对象
	}
}
