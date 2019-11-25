package practice;

import java.util.*;
public class MapTest2 {
	public static void main(String[] args)
	{
		String s="sdfggcsyhg,cs-yc+yg";
		System.out.println(charCount(s));
	}
	public static String charCount(String str)
	{
		char[] ch=str.toCharArray();
		TreeMap<Character,Integer> tm=new TreeMap<Character,Integer>();
		int count=0;
		for(int x=0;x<ch.length;x++)
		{
			if(!(ch[x]>='a'&&ch[x]<='z' || ch[x]>='A' && ch[x]<='Z'))
				continue;
			Integer value =tm.get(ch[x]);
			if(value!=null)
				count=value;
			count++;
			tm.put(ch[x],count);
			count=0;
//			if(value==null)
//				tm.put(ch[x],1);
//			else
//			{
//				value=value+1;
//				tm.put(ch[x],value);
//			}
		}
		
		StringBuilder sb=new StringBuilder();
		Set<Map.Entry<Character,Integer>> sen=tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> ien=sen.iterator();
		while(ien.hasNext())
		{
			Map.Entry<Character,Integer> me=ien.next();
			Character c=me.getKey();
			Integer i=me.getValue();
			sb.append(c+"("+i+")");
			
		}
		String st=sb.toString();
		return st;
			
	}
}
