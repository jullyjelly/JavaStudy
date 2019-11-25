package FN;

class Super
{
	int i=0;
	//Super(){}
	public Super(String s)
	{
		i=1;
	}
}



class TDemo extends Super
{
	public TDemo(String s)
	{
		super(s);
		i=2;
	}
	public static void main(String[] args)
	{
		TDemo l=new TDemo("yes");
		System.out.println(l.i);
	}
}