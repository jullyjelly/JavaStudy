package aban;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class MyMenuDemo {
	private Frame f;
	private MenuBar mb;
	private Button b;
	private Menu document,settings,subMenu;
	private MenuItem close,subOpt,open,save,newfile;
	private FileDialog fdopen,fdsave;
	private TextArea ta;
	private File file;
	
	MyMenuDemo()
	{
		init();
	}
	public void init()
	{
		f=new Frame("my window");

		f.setBounds(300, 200, 500, 400);
		f.setLayout(new FlowLayout());
		
		mb=new MenuBar();
		b=new Button("botton");
		fdopen=new FileDialog(f,"��",FileDialog.LOAD);
		fdsave=new FileDialog(f,"����",FileDialog.SAVE);
		document=new Menu("�ļ�");
		settings=new Menu("����");
		subMenu=new Menu("�Ӳ˵�");
		close=new MenuItem("�˳�");
		subOpt=new MenuItem("��ѡ��");
		open=new MenuItem("��");
		save=new MenuItem("����");
		newfile=new MenuItem("�½�");
		ta=new TextArea(20,60);
		
		f.add(b);
		f.add(ta);
		subMenu.add(subOpt);
		document.add(subMenu);
		document.add(close);
		document.add(open);
		document.add(save);
		document.add(newfile);
		
		mb.add(document);
		mb.add(settings);
		
		f.setMenuBar(mb);
		
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
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});

		open.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				fdopen.setVisible(true);
				String dir=fdopen.getDirectory();
				String filename=fdopen.getFile();
				if(dir==null||filename==null)
					return;
				ta.setText("");
				file=new File(dir,filename);
				try
				{
					BufferedReader bfr=new BufferedReader(new FileReader(file));
					String line=null;
					while((line=bfr.readLine())!=null)
					{
						ta.append(line+"\r\n");
					}
					bfr.close();
				}
				catch(IOException ex)
				{
					
				}
			}
		});
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(file==null)
				{
					fdsave.setVisible(true);
					String dir=fdsave.getDirectory();
					String filename=fdsave.getFile();
					if(dir==null||filename==null)
						return;
					file=new File(dir,filename);
					try
					{
						BufferedWriter bfw=new BufferedWriter(new FileWriter(file));
						String str=ta.getText();
						bfw.write(str);
						bfw.flush();
						bfw.close();
					}
					catch(IOException exe)
					{
						throw new RuntimeException("");
					}
				}
				else
				{
					try
					{
						BufferedWriter bfw=new BufferedWriter(new FileWriter(file));
						String str=ta.getText();
						bfw.write(str);
						bfw.flush();
						bfw.close();
					}
					catch(IOException exe)
					{
						throw new RuntimeException("");
					}
				}
			}
		});
		newfile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				file=null;
				ta.setText("");
			}
		});
	}
	
	public static void main(String[] args) 
	{
		new MyMenuDemo();
	}
}