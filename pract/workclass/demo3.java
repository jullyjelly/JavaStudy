package workclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class demo3 {
	Person d;
	@Before
	public void before() {
		System.out.println("before");
		d=new Person();
	}
	
	
	@Test
	public void testrun() {
		d.run();
	}
	@Test
	public void testeat() {
		d.eat();
	}
	
	@After
	public void after() {
		d=null;
		System.out.println("after");
	}
}
