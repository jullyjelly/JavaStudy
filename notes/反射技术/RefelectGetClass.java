package cont;

public class RefelectGetClass  {
	public static void main(String[] args) throws Exception {
		getClass_1();
	}
	public static void getClass_1() throws Exception{
		Person p1=new Person();
		Person p2=new Person();
		Class class1=p1.getClass();
		Class class2=p2.getClass();
		System.out.println(class1==class2);
		System.out.println(class1.getName());
		String fieldName="age";
		System.out.println(class1.getField(fieldName));
		for(Object f:class1.getFields())
			System.out.println(f);
		System.out.println("==========");
		for(Object f:class1.getMethods())
			System.out.println(f);
		
	}
	public static void getClass_2()  {
		//拿到Person字节码文件的对应的字节码对象
		 Class class1=Person.class;
	}
	public static void getClass_3() throws ClassNotFoundException,InstantiationException,IllegalAccessException  {
		String className="cont.Person";
		Class class1=Class.forName(className);
		System.out.println(class1);
		//通过newInstance方法创建字节码对象所表示的类的实例
		Object obj=class1.newInstance();
		System.out.println(obj);
	}
}
