package aban;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class MyWindowDemo2 {
	private Frame f;
	private Button b;
	private TextField tf;
	private TextArea ta;
	
	private Dialog d;//��ӶԻ���
	private Label l;//���������Ϣ
	private Button okb;
	MyWindowDemo2()
	{
		init();
	}
	public void init()
	{
		f=new Frame("this is a frame");

		f.setBounds(300, 200, 500, 400);
		f.setLayout(new FlowLayout());
		b=new Button("botton");
		tf=new TextField(30) ;
		ta=new TextArea(20,60);
		
		
		d=new Dialog(f,"��ʾ��Ϣ",true);
		d.setBounds(400, 250, 300, 100);
		d.setLayout(new FlowLayout());
		//true,����ȥ���ô��ڿ�����������޷�������false�����㲻ȥ��Ҳ���Լ�������
		l=new Label();
		okb=new Button("ok");
		
		d.add(l);
		d.add(okb);

		f.add(tf);
		f.add(b);
		f.add(ta);
		
		myEvent();
		f.setVisible(true);
	}
	public void myEvent()
	{
		//���Ͻǿ��Թر�
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
		});
		okb.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e) 
			{
				d.setVisible(false);
			}
		});
		
		b.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e) 
			{
				getDir();
//				ta.setText("");
//				String dirPath=tf.getText();
//				File dir=new File(dirPath);
//				if(dir.exists())
//					showDir(dir,0);
//				else 
//				{
//					String info="�ļ�·��"+dir.getName()+"����";
//					l.setText(info);
//					d.setVisible(true);
//				}
					
				
				//ta.setText(sb.toString());
				tf.setText("");
			}
		});
		tf.addKeyListener(new controlTA());
//		tf.addKeyListener(new KeyAdapter()
//		{
//			public void keyPressed(KeyEvent e) 
//			{
//				if(e.getKeyCode()==KeyEvent.VK_ENTER)
//				{
//					getDir();
//				}
//			}
//		});
		okb.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					d.setVisible(false);
			}
		});
	}
	//StringBuilder sb=new StringBuilder();
	
	class controlTA extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				getDir();
//				}
			}
		}		
	}
	private void getDir()
	{
		ta.setText("");
		String dirPath=tf.getText();
		File dir=new File(dirPath);
		if(dir.exists())
			showDir(dir,0);
		else 
		{
			String info="�ļ�·��"+dir.getName()+"����";
			l.setText(info);
			d.setVisible(true);
		}
	}
	public void showDir(File dir,int level)
	{
		level++;
		//sb.append(getLevel(level)+"======"+dir.getName()+"======\r\n");
		ta.append(getLevel(level)+"======"+dir.getName()+"======\r\n");
		File[] files=dir.listFiles();
		for(File f:files)
		{
			if(f.isDirectory())
				showDir(f,level);
			else
				ta.append(getLevel(level)+f.getName()+"\r\n");
				//sb.append(getLevel(level)+f.getName()+"\r\n");
		}
	}
	public String getLevel(int level)
	{
		StringBuilder sb=new StringBuilder();
		for(int x=0;x<level;x++)
		{
			sb.append("    ");
		}
		return sb.toString();
	}
	public static void main(String[] args) 
	{
		 new  MyWindowDemo2();
	}
}
