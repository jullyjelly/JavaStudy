/**
 这是一个可以进行数组操作的工具
 @author 简悦
 @version V1.1
 */

public class textTool {
	/**
	 * 空参数构造函数
	 */
	//private textTool() {}
	/**
	 获取一个整型数组中的最大值
	 @param arr 接收一个int类型的数组
	 @return 返回该数组的最大值
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
	 获取一个整型数组中的最小值
	 @param arr 接收一个int类型的数组
	 @return 返回该数组的最小值
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
	 给int数组及逆行排序
	 @param arr 接收一个int类型的数组
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
	 * 给数组中的元素进行位置的置换
	 * @param arr 接收一个int类型的数组
	 * @param x 要置换的位置
	 * @param y 要置换的位置
	 */
	public static void swap(int[] arr ,int x,int y)
	{
		int temp;
		temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	/**
	 * 用于打印数组中的元素，打印形式是[element1，element2，·····]
	 * @param arr 接收一个int类型的数组
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
