package Algorithm;

public class HeapTest {
	public static void headSort(int[] arr) {
		if(arr==null || arr.length<2)
			return;
		for(int index=0;index<arr.length;index++) {
			heapInset(arr,index);
		}
		int heapSize=arr.length;
		swap(arr,0,--heapSize);
		while(heapSize>0) {
			heapify(arr,0,heapSize);
			swap(arr,0,--heapSize);
		}
	}
	public static void heapInset(int[] arr,int index) {
		while(arr[index]>arr[(index-1)/2]) {
			swap(arr,index,(index-1)/2);
			index=(index-1)/2;
		}
	}
	public static void heapify(int[] arr,int index,int heapSize) {
		int left=2*index+1;
		while(left<heapSize) {
			int largest=left+1<heapSize && arr[left+1]>arr[left]? left+1:left;
			largest=arr[largest]>arr[index]? largest:index;
			if(largest==index)
				break;
			swap(arr,largest,index);
			index=largest;
			left=2*index+1;
		}
	}
	
	public static void swap(int[] arr,int x,int y) {
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	public static void main(String[] args) {
		int[] arr= {3,5,7,1,3,6,7,4,5,8,9,2,0,2,6,9,0};
		headSort(arr);
		for(int i:arr)
			System.out.println(i);
		
	}
}
