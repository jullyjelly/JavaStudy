package practice;


public class StringDemo {
	public static void main(String[] args)
	{
		String s="askjpowenmt";
		System.out.println(s.lastIndexOf("o",2));
		byte[] b=s.getBytes();
		for(int x=0;x<b.length;x++)
			System.out.println(b[x]);
		char[] c=s.toCharArray();
		System.out.println(s.getBytes());
		for(int x=0;x<c.length;x++)
			System.out.println(c[x]);
		System.out.println(s.substring(3));
		System.out.println(s.subSequence(2, 7));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
