package aban;

import java.awt.*;
import java.awt.event.*;
public class AwtDemo {
	public static void main(String[] args) 
	{
		Frame f=new Frame("my fram");
		f.setSize(500,400);
		f.setLocation(300,200);
		f.setLayout(new FlowLayout());
		Button b=new Button("°´Å¥");
		f.add(b);
//		f.addWindowListener(new MyWin());
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("close");
				System.exit(0);
			}
			public void windowActivated(WindowEvent e)
			{
				System.out.println("act");
			}
			public void windowOpened(WindowEvent e) 
			{
				System.out.println("open");
			}
		});

		f.setVisible(true);
	}
}
//class MyWin extends WindowAdapter
//{
//	public void windowClosing(WindowEvent e)
//	{
//		System.out.println("close");
//		System.exit(0);
//	}
//}
