package cont;

public class Person {
	public int age;
	private String name;
	Person(){
		System.out.println("person run");
	}
	public Person(String name,int age){
		super();
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void show(String name,int age) {
		System.out.println(name+"..."+age);
	}
	public static void staticShow() {
		System.out.println("static person run");
	}
}
