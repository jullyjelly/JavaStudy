package test;


class EDemo
{
	int div(int a,int b) throws ArithmeticException,ArrayIndexOutOfBoundsException//������ͨ��throw�ؼ��������ù����п��ܻ��������
	{
		int[] arr = new int[a];
		System.out.println(arr[4]);
		return a/b;
	}
}

public class EceptionDemo 
{
	public static void main(String[] args)
	{
		EDemo d = new EDemo();
		try 
		{
			int x = d.div(4, 1);
			System.out.println(x);
		}
		catch(ArithmeticException e)
		{
			System.out.println("�������");
			System.out.println(e.getMessage());//�쳣��Ϣ
			System.out.println(e.toString());//�쳣���ƣ��쳣��Ϣ
			e.printStackTrace();//�쳣��Ϣ���쳣���ƣ��쳣λ��
			//java��Ĭ���쳣������ƾ��ǵ���printStackTrace()��������ӡ�쳣�ڶ�ջ�еĸ�����Ϣ
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.toString());
			System.out.println("��������Խ��");
		}
		System.out.println("over");
	}
}
