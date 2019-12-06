package cont;

import java.lang.reflect.*;
public class refelectGetConstruction {
	public static void main(String[] args) throws Exception{
		getConstruction_1();
	}
	public static void getConstruction_1() throws Exception{
		String className="cont.Person";
		Class class1=Class.forName(className);
		//获取指定的构造器，获取Person类中两个参数为String和int的构造函数
		Constructor cons=class1.getConstructor(String.class,int.class);//形参
		
		//有了构造器后就通过构造器对象来初始化该类
		Object obj=cons.newInstance("j1",12);//实参
		System.out.println(obj);
	}

}
