package Algorithm;

import java.util.*;
public class ShortestPath {
	public static void getShortestPath(int[][] matrix) {
		int row=matrix.length;
		int line=matrix[0].length;
		int[] r=new int[row+line-1];
		r[0]=matrix[0][0];
		TreeSet<Integer> al=new TreeSet<Integer>();
		
//		ArrayList<Intege> al=new ArrayList<Integer>();
		
		System.out.println(countPath(0,matrix,0,0,row-1,line-1,r,al).first());
	}
	public static TreeSet<Integer> countPath(int route,int[][] matrix,int x,int y,int row,int line,int[] r,TreeSet<Integer> al){
		if(x==row && y==line) {
//			for (int i:r) {
//				System.out.print(i+" ");
//			}
//			System.out.println(route);
			al.add(route);
			return al;
		}
		if(x!=row) {
			r[x+y+1]=matrix[x+1][y];
			countPath(route+matrix[x+1][y],matrix,x+1,y,row,line,r,al);
		}
		if(y!=line) {
			r[x+y+1]=matrix[x][y+1];
			countPath(route+matrix[x][y+1],matrix,x,y+1,row,line,r,al);
		}
		return al;
	}
	public static void main(String[] args) {
		int[][] matrix= {{2,4,5,6},{3,2,6,8},{6,1,7,2},{5,3,9,8}};
		getShortestPath(matrix);
	}
}
