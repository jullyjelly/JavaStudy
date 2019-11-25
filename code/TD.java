package FN;


class Cir
{
	private double radius;
	public Cir(double r)
	{
		radius=r;
	}
	public Cir compare(Cir cir)
	{
//		if(this.radius>cir.radius)
//			return this;
//		else
//			return cir;
		return (this.radius>cir.radius)? this:cir;
	}
}
public class TD 
{
	public static void main(String[] args)
	{
		Cir cir1=new Cir(1);
		Cir cir2=new Cir(2);
		Cir cir;
		cir=cir1.compare(cir2);
		if(cir1==cir)
			System.out.println("圆1的半径比较大");
		else
			System.out.println("圆2的半径比较大");
		
	}
}
