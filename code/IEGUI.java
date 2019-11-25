package aban;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class IEGUI {
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;

	IEGUI()
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
		String url=tf.getText();
		int index1=url.indexOf("//")+2;
		int index2=url.indexOf("/",index1);
		
		String str=url.substring(index1,index2);
		String[] arr=str.split(":");
		String host=arr[0];
		int port=Integer.parseInt(arr[1]);
		
		String path=url.substring(index2);
		ta.setText(str+"....."+path);
		
		Socket s=new Socket("10.108.53.126",8080);
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		out.println("GET "+path+" HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 10.108.50.213:10008");
		out.println("Connection: Keep-Alive");
		out.println();
		out.println();
		
		BufferedReader bfr=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line=null;
		while((line=bfr.readLine())!=null)
		{
			ta.append(line+"\r\n");
//			System.out.println(line);
		}
		s.close();
		
	}
	public static void main(String[] args)
	{
		new IEGUI();
	}
}
