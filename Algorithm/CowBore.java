package Algorithm;

public class CowBore {
	public static class Cow{
		public int age;
		Cow(){
			this.age=0;
		}
		public static int cowNum(int endYear) {
			Cow head=new Cow();
			head.age=3;
			return generateCow(head,1,1,endYear);
		}
		public static int generateCow(Cow head,int count,int year,int endYear) {
			if(year>endYear) {
				return count;
			}
			year++;
			if(++head.age>=3) {
				Cow cow=new Cow();
				count++;
				count=generateCow(cow,count,year,endYear);
			}
			count=generateCow(head,count,year,endYear);
			return count;
		}
	}
	public static void main(String[] args) {
		System.out.println(Cow.cowNum(10));
	}
}
