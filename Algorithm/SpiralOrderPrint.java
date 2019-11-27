package Algorithm;

/*
给定一个整型矩阵，按照转圈的方式打印它
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
打印：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10*/
public class SpiralOrderPrint {
	public static void spiralPrint(int[][] matrix) {
		int sr=0;
		int sl=0;
		int er=matrix.length-1;
		int el=matrix[0].length-1;
		while(sr <= er && sl <= el) {
			int cr=sr;
			int cl=sl;
			if(sr==er) {
				for(int i=0;i<=el;i++)
					System.out.println(matrix[0][i]);
				
			}
			else if(sl==el) {
				for(int i=0;i<=er;i++)
					System.out.println(matrix[i][0]);
			}
			else {
				while(cl!=el)
					System.out.println(matrix[sr][cl++]);
				while(cr!=er)
					System.out.println(matrix[cr++][el]);
				while(cl!=sl)
					System.out.println(matrix[er][cl--]);
				while(cr!=sr)
					System.out.println(matrix[cr--][sl]);
			}	
			sr++;sl++;er--;el--;
			
		}
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralPrint(matrix);
	}
}
