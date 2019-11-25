package FN;

class Circle
{
	private static double pi=3.14;
	private double radius;
	public Circle(double r)
	{
		radius=r;
	}
	public static double compare(Circle[] cir)
	{
		//int max=cir[0].radius;
		int maxindex=0;
		for(int x=0;x<cir.length;x++)
		//for(int x=0;x<3;x++)
		{
			if(cir[maxindex].radius<cir[x].radius)
			{
				maxindex=x;
			}
		}
		return cir[maxindex].radius;
	}
}
public class TC 
{
	public static void main(String[] args)
	{
		Circle[] cir=new Circle[3];
		cir[0]=new Circle(1);
		cir[1]=new Circle(2);
		cir[2]=new Circle(4);
		System.out.println("最大的半径值是"+Circle.compare(cir));
	}
}
