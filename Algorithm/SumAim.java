package Algorithm;

public class SumAim {
	public static boolean ifGetAim(int[] arr,int aim) {
		int len=arr.length;
		return getSum(arr,len,aim,0);
	}
	public static boolean getSum(int[] arr,int len,int aim,int sum) {
		if(sum>=aim) {
			return sum==aim;
		}
		boolean flag=false;
		for(int x=0;x<len;x++) {
			int he=sum+arr[x];
			flag=flag || getSum(arr,len,aim,he);
			if(flag==true)
				return flag;
			
		}
		return flag;
		
	}
	public static void main(String[] args) {
		int[] arr= {13,6,7,9};
		int aim=11;
		System.out.println(ifGetAim(arr,aim));
	}
}
