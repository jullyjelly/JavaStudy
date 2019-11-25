package aban;

import java.util.*;
import java.text.*;
public class DateDemo {
	public static void main(String[] args) 
	{
		Date d=new Date();
		System.out.println(d);
		//��ģʽ��װ��format������
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��mm��dd�� E HH:mm:ss");
		//����format������ģʽ��ʽ��ָ���Ķ���
		String time=sdf.format(d);
		System.out.println(time);
		
		long l=System.currentTimeMillis();
		Date d1=new Date(l);
		System.out.println(d1);
		
		Calendar c=Calendar.getInstance();
		printCal(c);
		//�趨ʱ��
		c.set(2020,1,18);
		printCal(c);
		//ʱ������
		c.add(Calendar.YEAR, -24);
		printCal(c);
		
		//��ȡ������Ķ����ж�����
		calFeb(2005);
		//��ȡ��������ʱ��
		Calendar c1=Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, -1);
		printCal(c1);
	}
	public static void printCal(Calendar c)
	{
		String[] mons= {"һ��","����","����","����","����","����","����","����","����","ʮ��","ʮһ��","ʮ����"};
		String[] week= {"","������","����һ","���ڶ�","������","������","������","������"};
		System.out.println(c);
		int mindex=c.get(Calendar.MONTH);
		System.out.println(mons[mindex]);
		int windex=c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week[windex]);
		System.out.println(c.get(Calendar.YEAR));
		
	}
	public static void calFeb(int year)
	{
		Calendar c=Calendar.getInstance();
		c.set(year,2,1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int d=c.get(Calendar.DAY_OF_MONTH);
		System.out.println(d);
	}

}
