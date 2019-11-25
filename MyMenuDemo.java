package menu;

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
		fdopen=new FileDialog(f,"打开",FileDialog.LOAD);
		fdsave=new FileDialog(f,"保存",FileDialog.SAVE);
		document=new Menu("文件");
		settings=new Menu("设置");
		subMenu=new Menu("子菜单");
		close=new MenuItem("退出");
		subOpt=new MenuItem("子选项");
		open=new MenuItem("打开");
		save=new MenuItem("保存");
		newfile=new MenuItem("新建");
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
		//右上角可以关闭
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