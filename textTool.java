/**
 ����һ�����Խ�����������Ĺ���
 @author ����
 @version V1.1
 */

public class textTool {
	/**
	 * �ղ������캯��
	 */
	//private textTool() {}
	/**
	 ��ȡһ�����������е����ֵ
	 @param arr ����һ��int���͵�����
	 @return ���ظ���������ֵ
	 */
	public static int getMax(int[] arr)
	{
		int max = 0;
		for(int x=0;x<arr.length;x++)
		{
			if(arr[x]>arr[max])
				max = x;
		}
		return max;
	}
	/**
	 ��ȡһ�����������е���Сֵ
	 @param arr ����һ��int���͵�����
	 @return ���ظ��������Сֵ
	 */
	public static int getMin(int[] arr)
	{
		int min = 0;
		for(int x=0;x<arr.length;x++)
		{
			if(arr[x]<arr[min])
				min = x;
		}
		return min;
	}
	/**
	 ��int���鼰��������
	 @param arr ����һ��int���͵�����
	 */
	public static void Sort(int[] arr)
	{
		for(int x=0;x<arr.length-1;x++)
		{
			for(int y=x+1;y<arr.length;y++)
			{
				if(arr[x]>arr[y])
				{
					swap(arr,x,y);
				}
			}
		}
		printarr(arr);
	}
	/**
	 * �������е�Ԫ�ؽ���λ�õ��û�
	 * @param arr ����һ��int���͵�����
	 * @param x Ҫ�û���λ��
	 * @param y Ҫ�û���λ��
	 */
	public static void swap(int[] arr ,int x,int y)
	{
		int temp;
		temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	/**
	 * ���ڴ�ӡ�����е�Ԫ�أ���ӡ��ʽ��[element1��element2������������]
	 * @param arr ����һ��int���͵�����
	 */
	public static void printarr(int[] arr)
	{
		for(int x=0;x<arr.length;x++)
		{
			System.out.print(arr[x]+", ");
		}
		System.out.println();
	}

}
