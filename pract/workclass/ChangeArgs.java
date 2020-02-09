package workclass;

import org.junit.Test;

public class ChangeArgs {
	@Test
	public void testSum() {
		sum(1, 2, 4, 5, 6, 8, 9);
	}

	public void sum(int... nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		System.out.println(sum);
	}

	@Test
	public void test() {
		print(Grade.C);
		Grade[] gd=Grade.values();
		for(Grade g:gd) {
			System.out.println(g);
		}
	}

	public void print(Grade g) {
		String value = g.localValue();
		System.out.println(value);
	}
}

enum Grade {
	A("90-100") {
		public String localValue() {
			return "优";
		}
	},
	B("80-89") {
		public String localValue() {
			return "良";
		}
	},
	C("70-79") {
		public String localValue() {
			return "中";
		}
	},
	D("60-69") {
		public String localValue() {
			return "差";
		}
	},
	E("0-59") {
		public String localValue() {
			return "不及格";
		}
	};

	private String value;

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public abstract String localValue();
}