
package workclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello java");

		try {
			FileInputStream f1 = new FileInputStream("");
		} catch (FileNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
