package Algorithm;

public class FindNum {
	public static boolean find(int[][] matrix,int num) {
		int rowL=matrix.length-1;
		int lineL=matrix[0].length-1;
		int row=0;
		int line=lineL;
		while(row<=rowL && line>=0) {
			if(matrix[row][line]>num) {
				line--;
			}
			else if(matrix[row][line]<num) {
				row++;
			}
			else {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix= {{1,3,5,6},{2,5,7,8},{4,6,8,9}};
		System.out.println(find(matrix, 7));
	}
}
