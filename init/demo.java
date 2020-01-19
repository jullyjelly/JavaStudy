/*
学习Java的第一次尝试
目的：打印出haha
步骤：
1。通过class关键字定义一个类，将代码都写到该类中
2.为了保证该类的独立运行，在类中定义一个主函数，格式public static void main (String[] args)
3.保存成一个扩展名为java的文件
4.在dos控制台中通过javac工具对java文件进行编译
5。通过java命令对生成的class文件进行执行
*/
class demo
{
	public static void main(String[] args)
	{
		System.out.println("haha");
		System.out.println(Integer.toBinaryString(-6));
		byte b = 3;
		b =(byte) (b+2);
		System.out.println(b);
		System.out.println('c'+1);
		System.out.println((int)('c'));
		System.out.println("c="+1);
		System.out.println("hello" instanceof String);
		int num = 60;
		//获取60的最低4位
		int n2 = num&15;
		System.out.println((char)(n2-10+'A'));
		
		int temp=60>>4;
		int n1 = temp&15;
		System.out.println(n1);
		//System.out.println(n1+(char)(n2-10+'A'));
		
		int s = 3;
		if(s>1)
		{
			System.out.println("yse");
		}
		int x = 12;
		if(x>12 || x<1)
			System.out.println("月份不存在");
		else if(x>=3 && x<=5)
			System.out.println("春");
		else if(x>=6 && x<=8)
			System.out.println("夏");
		else if(x>=9 && x<=11)
			System.out.println("夏");
		else
			System.out.println("冬");		
		int a1=3,a2=4;
		char ch='u';
		switch(ch)
		{
			case '-':
				System.out.println(a1-a2);
				break;
			case '+':
				System.out.println(a1+a2);
				break;
			case '*':
				System.out.println(a1*a2);
				break;
			case '/':
				System.out.println(a1/a2);
				break;
			default:
				System.out.println("wrong");
				
		}
	}
}