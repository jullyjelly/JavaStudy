package practice;

import java.util.*;
public class MapDemo2 {
	public static void main(String[] args)
	{
		HashMap<String,String> class1=new HashMap<String,String>();
		class1.put("A01","j1");
		class1.put("A02","j2");
		HashMap<String,String> class2=new HashMap<String,String>();
		class2.put("B01","j1");
		class2.put("B02","j2");
		HashMap<String,HashMap<String,String>> school=new HashMap<String,HashMap<String,String>>();
		school.put("class2",class2);
		school.put("class1",class1);
		
		System.out.println(school);
		
		Set<Map.Entry<String,HashMap<String,String>>> sm1=school.entrySet();
		Iterator<Map.Entry<String,HashMap<String,String>>> im1=sm1.iterator();
		while(im1.hasNext())
		{
			Map.Entry<String,HashMap<String,String>> me1=im1.next();
			String c=me1.getKey();
			HashMap<String,String> hm1=me1.getValue();
			Set<Map.Entry<String, String>> sm2=hm1.entrySet();
			Iterator<Map.Entry<String, String>> im2=sm2.iterator();
			while(im2.hasNext())
			{
				Map.Entry<String, String> me2=im2.next();
				String num=me2.getKey();
				String name=me2.getValue();
				System.out.println(c+':'+num+":"+name);
			}
		}
		System.out.println(school.get("class2"));
		
		Iterator<String> it=school.keySet().iterator();
		while(it.hasNext())
		{
			String classname=it.next();
			HashMap<String,String> cn=school.get(classname);
			System.out.println(classname);
			getInfo(school.get(classname));
		}
	}

	public static void getInfo(HashMap<String,String> h)
	{
		Set<Map.Entry<String,String>> ss=h.entrySet();
		Iterator<Map.Entry<String,String>> it=ss.iterator();
		while(it.hasNext())
		{
			Map.Entry<String,String> me=it.next();
			
			System.out.println(me.getKey()+":"+me.getValue());
		}
	}
}
