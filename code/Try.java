package test;
import  java.util.*;
public class Try {
	public static void main(String[] args)
	{
		String items[] = {"1","2","3","4","5"};
		for(String a:items)
		    System.out.println(a);

		List<String> list1=Arrays.asList(items);
		List<String> arrList = new ArrayList<>(list1); 
		System.out.println(arrList);
		int[] i= {3,5,2,7,6,9};
		Arrays.parallelSort(i);
		Integer[] integers1 = Arrays.stream(i).boxed().toArray(Integer[]::new);
		
		for(int a:integers1)
			System.out.println(a);
		

	}

}

