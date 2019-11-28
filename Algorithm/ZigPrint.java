package Algorithm;

public class ZigPrint {
	public static void zigMatrix(int[][] matrix){
		int rowLength=matrix.length;
		int lineLength=matrix[0].length;
		int r=0;
		int l=0;
		for(int x=0;x<3;x++) {
			while(r>=0 && l<lineLength) {
				System.out.println(matrix[r][l]);
				r--;l++;
			}
			if(r<0)
				r++;
			if(l>lineLength-1) {
				r=r+2;
				l--;
			}
				
			while(r<rowLength && l>=0) {
				System.out.println(matrix[r][l]);
				r++;l--;
			}
			if(l<0) {
				l++;
			}
			if(r>rowLength-1) {
				l=l+2;
				r--;
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix= { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		zigMatrix(matrix);
	}
}
