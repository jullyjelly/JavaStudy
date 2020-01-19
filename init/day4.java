class day4
{
	public static void main(String[] args)
	{
		
		
		//int[] x = {2,4,6,5,7,9,3,1};
		
		//maopao(x);
		//bubble(x); 
		int[] r ={2,5,6,8,9,30,45,57,68} ;
		//System.out.println(half(r,50));
		System.out.println(half2(r,50));
		tob(20);
		/*
		double[] y={1.1,3.4,6.5,2.3,6.1,3.5};
		System.out.println(getmax(x));
		System.out.println(getmax(y));

		for(int i=0;i<x.length-1;i++)
		{
			for(int j=i+1;j<x.length;j++)
			{
				if(x[i]>x[j])
				{
					int a=x[i];
					x[i]=x[j];
					x[j]=a;
				}
					
			}
			System.out.println(x[i]);
		}
		printarr(x);
		*/
		
	}
	
	/*
	public static int getmax(int[] arr)
	{
		int maxnum=arr[0];
		for(int x=0;x<arr.length;x++)
		{
			maxnum = (maxnum<arr[x])? arr[x]:maxnum;
		}
		return maxnum;
	}
	
	public static double getmax(double[] arr)
	{
		double maxnum=arr[0];
		for(int x=0;x<arr.length;x++)
		{
			maxnum = (maxnum<arr[x])? arr[x]:maxnum;
		}
		return maxnum;
	}
	*/
	public static void tob(int num)
	{
		int[] b=new int[]
		while(num!=0)
		{
			System.out.println(num%2);
			num = num>>1;
		}
	}
	public static int half2(int[] a, int key)
	{
		int min=0,max=a.length-1,mid;
		while(min<=max)
		{
			mid=(min+max)>>1;
			if(key>a[mid])
				min=mid+1;
			else if(key<a[mid])
				max=mid=1;
			else
				return mid;
		}
		return min;
	}
	/*
	public static int half(int[] a,int key)
	{
		int min,max,mid;
		min=0;
		max=a.length-1;
		mid=(min+max)/2;
		while(a[mid]!=key)
		{
			
			if(a[mid]<key)
				min=mid+1;
			else if(a[mid]>key)
				max=mid-1;
			if(min>max)
				return -1;
			mid=(min+max)/2;
		}
		return mid;
	}
	public static void maopao(int[] a)
	{
		for (int i=a.length;i>=1;i--)
		{
			for(int x=0;x<i-1;x++)
			{
				if(a[x]>a[x+1])
				{
					int temp=a[x];
					a[x]=a[x+1];
					a[x+1]=temp;
				}
			}
		}
		printarr(a);
		
	}
	public static void bubble(int[] a)
	{
		for(int x=0;x<a.length-1;x++)
		{
			for(int y=0;y<a.length-x-1;y++)
			{
				if(a[y]<a[y+1])
				{
					int temp=a[y];
					a[y]=a[y+1];
					a[y+1]=temp;
				}
			}
		}
		printarr(a);
	}
	public static void printarr(int[] a)
	{
		for(int x=0;x<a.length;x++)
			System.out.print(a[x]+", ");
		System.out.println();
	}
	*/
}
