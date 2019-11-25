package aban;

import java.util.*;
import java.text.*;
public class DateDemo {
	public static void main(String[] args) 
	{
		Date d=new Date();
		System.out.println(d);
		//将模式封装到format对象中
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年mm月dd日 E HH:mm:ss");
		//调用format方法让模式格式化指定的对象
		String time=sdf.format(d);
		System.out.println(time);
		
		long l=System.currentTimeMillis();
		Date d1=new Date(l);
		System.out.println(d1);
		
		Calendar c=Calendar.getInstance();
		printCal(c);
		//设定时间
		c.set(2020,1,18);
		printCal(c);
		//时间推移
		c.add(Calendar.YEAR, -24);
		printCal(c);
		
		//获取任意年的二月有多少天
		calFeb(2005);
		//获取昨天的这个时刻
		Calendar c1=Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, -1);
		printCal(c1);
	}
	public static void printCal(Calendar c)
	{
		String[] mons= {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
		String[] week= {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
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
