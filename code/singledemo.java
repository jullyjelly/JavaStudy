package test;

class single
{
	private int num;
	public void setnum(int num)
	{
		this.num = num;
	}
	public int getnum()
	{
		return num;
	}
	private single(){}
	private static single s = new single();
	public static single getinstace()
	{
		return s;
	}
}
public class singledemo {
	public static void main(String[] args)
	{
		single s1 = single.getinstace();
		single s2 = single.getinstace();
		s1.setnum(23);
		System.out.println(s2.getnum());
	}
}
