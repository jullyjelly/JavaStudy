package aban;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class IEGUI2{
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;

	IEGUI2()
	{
		init();
	}
	public void init()
	{
		f=new Frame("my window");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		tf=new TextField(60);
		but=new Button("×ªµ½");
		ta=new TextArea(25,70);
		
		
		f.add(tf);
		f.add(but);
		f.add(ta);
		myEvent();
		f.setVisible(true);
	}
	public void myEvent()
	{

		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					try
					{
						showDir();
					}
					catch(Exception ex) {}
			}
		});
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					showDir();
				}
				catch(Exception ex) {}
			}
		});
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	public void showDir() throws Exception
	{
		ta.setText("");
		String u=tf.getText();
		URL url=new URL(u);
		URLConnection uc=url.openConnection();
		InputStream id=uc.getInputStream();
		byte[] buf=new byte[1024];
		int len=id.read(buf);
		ta.append(new String(buf,0,len));
	}
	public static void main(String[] args)
	{
		new IEGUI2();
	}
}

