package workclass;

import org.junit.Test;

public class WeekDay {
	@Test
	public void testWeek() {
		System.out.println(Week.SAT.getDays());
	}
	
}

enum Week{
	MON{
		public  String getDays(){
			return "����һ";
		}
	}
	
	,TUE{
		public  String getDays(){
			return "���ڶ�";
		}
	}
	
	,WED{
		public  String getDays(){
			return "������";
		}
	}
	
	,THU{
		public  String getDays(){
			return "������";
		}
	}
	
	,FRI{
		public  String getDays(){
			return "������";
		}
	}
	
	,SAT{
		public String getDays(){
			return "������";
		}
	}
	
	,SUN{
		public  String getDays(){
			return "������";
		}
	};
	
	public abstract String getDays();
	
}