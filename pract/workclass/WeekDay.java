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
			return "星期一";
		}
	}
	
	,TUE{
		public  String getDays(){
			return "星期二";
		}
	}
	
	,WED{
		public  String getDays(){
			return "星期三";
		}
	}
	
	,THU{
		public  String getDays(){
			return "星期四";
		}
	}
	
	,FRI{
		public  String getDays(){
			return "星期五";
		}
	}
	
	,SAT{
		public String getDays(){
			return "星期六";
		}
	}
	
	,SUN{
		public  String getDays(){
			return "星期日";
		}
	};
	
	public abstract String getDays();
	
}