package aban;

import java.awt.*;
import java.awt.event.*;
public class FrameDemo {
	private Frame f;
	private Button b;
	private TextField tf;
	private TextArea ta;
	FrameDemo()
	{
		init();
	}
	public void init()
	{
		f=new Frame("this is a frame");
		
		//对frame进行基本设置
		f.setBounds(300, 200, 500, 360);
		f.setLayout(new FlowLayout());
		b=new Button("转到");
		tf=new TextField(30) ;
		ta=new TextArea(15,60);
		
		//将组件添加到frame中
		
		f.add(tf);
		f.add(b);
		f.add(ta);
		
		//加载事件
		myEvent();

		//显示窗体事件
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
//		b.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e) 
//			{
//				System.exit(0);
//			}
//		});//点鼠标和键盘空格键都会退出
		//按钮增加动作监听
		b.addActionListener(new ActionListener ()
		{
			int count=1;
			public void actionPerformed(ActionEvent e) 
			{
				//点击鼠标和键盘空格都会被监听到
				System.out.println("action ok"+count);
				count++;
			}
		});
		//按钮增加键盘监听
		//按住ctrl和enter会退出
		b.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER  )
					System.exit(0);
				System.out.println(e.getKeyChar()+"....."+e.getKeyCode()+"....."+KeyEvent.getKeyText(e.getKeyCode()));
			}
		});
		//按钮添加鼠标监听
		//鼠标进入和鼠标双击监听
		b.addMouseListener(new MouseAdapter()
		{
			int count=1;
			int tclick=1;
			public void mouseEntered(MouseEvent e) 
			{
				System.out.println("mouse in"+count);
				count++;
			}
			public void mouseClicked(MouseEvent e) 
			{
				if(e.getClickCount()==2)
				{
					System.out.println("mouse twice click"+tclick);
					tclick++;
				}
			}
		});
		//文本框添加键盘监听
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(!(e.getKeyCode()>=KeyEvent.VK_0 && e.getKeyCode()<=KeyEvent.VK_9))
				{	
					System.out.println("code非法");
					e.consume();//若非法则不让其输入到文本框
				}
			}
		});
	}
	public static void main(String[] args) 
	{
		 new  FrameDemo();
	}
}
