package test;

interface PCI
{
	public void open();
	public void close();
}

class MainBoard
{
	public void run()
	{
		System.out.println("mainboard run");
	}
	public void usePCI(PCI p)
	{
		if(p!=null)
		{
			p.open();
			p.close();
		}
	}
}
class NetCard implements PCI
{
	public void open()
	{
		System.out.println("netcards open");
	}
	public void close()
	{
		System.out.println("netcards close");
	}
}

class SoundCard implements PCI
{
	public void open()
	{
		System.out.println("soundcard open");
	}
	public void close()
	{
		System.out.println("soundcard close");
	}
}

public class DuoTaiDemo2 
{
	public static void main(String[] args)
	{
		MainBoard m=new MainBoard();
		//m.usePCI(new PCI());
		m.usePCI(null);
		m.usePCI(new NetCard());
		m.usePCI(new SoundCard());
	}
}
