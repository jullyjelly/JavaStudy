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
		
		//��frame���л�������
		f.setBounds(300, 200, 500, 360);
		f.setLayout(new FlowLayout());
		b=new Button("ת��");
		tf=new TextField(30) ;
		ta=new TextArea(15,60);
		
		//�������ӵ�frame��
		
		f.add(tf);
		f.add(b);
		f.add(ta);
		
		//�����¼�
		myEvent();

		//��ʾ�����¼�
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
//		b.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e) 
//			{
//				System.exit(0);
//			}
//		});//�����ͼ��̿ո�������˳�
		//��ť���Ӷ�������
		b.addActionListener(new ActionListener ()
		{
			int count=1;
			public void actionPerformed(ActionEvent e) 
			{
				//������ͼ��̿ո񶼻ᱻ������
				System.out.println("action ok"+count);
				count++;
			}
		});
		//��ť���Ӽ��̼���
		//��סctrl��enter���˳�
		b.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER  )
					System.exit(0);
				System.out.println(e.getKeyChar()+"....."+e.getKeyCode()+"....."+KeyEvent.getKeyText(e.getKeyCode()));
			}
		});
		//��ť���������
		//����������˫������
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
		//�ı�����Ӽ��̼���
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(!(e.getKeyCode()>=KeyEvent.VK_0 && e.getKeyCode()<=KeyEvent.VK_9))
				{	
					System.out.println("code�Ƿ�");
					e.consume();//���Ƿ����������뵽�ı���
				}
			}
		});
	}
	public static void main(String[] args) 
	{
		 new  FrameDemo();
	}
}
