/*
ѧϰJava�ĵ�һ�γ���
Ŀ�ģ���ӡ��haha
���裺
1��ͨ��class�ؼ��ֶ���һ���࣬�����붼д��������
2.Ϊ�˱�֤����Ķ������У������ж���һ������������ʽpublic static void main (String[] args)
3.�����һ����չ��Ϊjava���ļ�
4.��dos����̨��ͨ��javac���߶�java�ļ����б���
5��ͨ��java��������ɵ�class�ļ�����ִ��
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
		//��ȡ60�����4λ
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
			System.out.println("�·ݲ�����");
		else if(x>=3 && x<=5)
			System.out.println("��");
		else if(x>=6 && x<=8)
			System.out.println("��");
		else if(x>=9 && x<=11)
			System.out.println("��");
		else
			System.out.println("��");		
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