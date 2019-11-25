package aban;

import java.util.*;

public class MapDemo {
	public static void main(String[] args)
	{
		Map<String,String> m =new HashMap<String,String>();
		
		m.put("01","j1");
		m.put("02","j2");
		System.out.println(m.put("03","j3"));
		System.out.println(m.put("03","j5"));
		//添加元素：如果添加时出现相同的键，那么后添加的值会覆盖原有键对应值，并且put方法会返回被覆盖的值
		
		
		System.out.println(m.get("023"));
		m.put("04","j4");
		System.out.println(m.get("04"));
		//keyset()
		Set<String> k=m.keySet();
		Iterator<String> it=k.iterator();
		System.out.println("=========");
		
		while(it.hasNext())
		{
			String key=it.next();
			String value=m.get(key);
			System.out.println(value);
		}
		//entryset()
		Set<Map.Entry<String, String>> entryset=m.entrySet();
		Iterator<Map.Entry<String, String>> itentry=entryset.iterator();
		System.out.println(itentry);
		while(itentry.hasNext())
		{
			Map.Entry<String, String> me=itentry.next();
			System.out.println(me);
			String key=me.getKey();
			String value=me.getValue();
			System.out.println("key...."+key);
			System.out.println("value...."+value);
		}
		
		//values()
		Collection<String> coll=m.values();
		System.out.println(coll);
		System.out.println(m);
	}
}
