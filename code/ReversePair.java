package aban;

public class ReversePair {
	public static void getrversePair(int[] arr)
	{
		if(arr==null || arr.length<2)
			return;
		mergeSort(arr,0,arr.length-1);
	}
	public static void mergeSort(int[] arr,int L,int R)
	{
		if(L==R)
			return;
		int mid=L+((R-L)>>1);
		mergeSort(arr,L,mid);
		mergeSort(arr,mid+1,R);
		merge(arr,L,mid,R);
	}
	public static void merge(int[] arr,int L,int mid,int R)
	{
		int[] help=new int[R-L+1];
		int i=0;
		int P1=L;
		int P2=mid+1;
		while(P1<=mid && P2<=R)
		{
			if(arr[P1]>arr[P2])
			{
				for(int x=0;x<mid-P1+1;x++)
					System.out.println(arr[P1+x]+","+arr[P2]);
			}
			help[i++]=arr[P1]<arr[P2]? arr[P1++]:arr[P2++];
		}
		while(P1<=mid)
			help[i++]=arr[P1++];
		while(P2<=R)
			help[i++]=arr[P2++];
		for(i=0;i<help.length;i++)
			arr[L+i]=help[i];
	}
//	public static void getrversePair(int[] arr) {
//		if (arr == null || arr.length < 2) {
//			return ;
//		}
//		mergeSort(arr, 0, arr.length - 1);
//	}
//
//	public static void mergeSort(int[] arr, int l, int r) {
//		if (l == r) {
//			return ;
//		}
//		int mid = l + ((r - l) >> 1);
//		mergeSort(arr, l, mid);
//		mergeSort(arr, mid + 1, r);
//		merge(arr, l, mid, r);
//	}
//
//	public static void merge(int[] arr, int l, int m, int r) {
//		int[] help = new int[r - l + 1];
//		int i = 0;
//		int p1 = l;
//		int p2 = m + 1;
//		while (p1 <= m && p2 <= r) {
//			if(arr[p1]>arr[p2])
//			{
//				for(int x=0;x<m-p1+1;x++)
//					System.out.println(arr[p1+x]+","+arr[p2]);
//			}
//			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
//		}
//		while (p1 <= m) {
//			help[i++] = arr[p1++];
//		}
//		while (p2 <= r) {
//			help[i++] = arr[p2++];
//		}
//		for (i = 0; i < help.length; i++) {
//			arr[l + i] = help[i];
//		}
//	}
	public static void main(String[] args)
	{
		int[] arr= {2,5,7,3,8,9,0,4};
		getrversePair(arr);
	}
}
