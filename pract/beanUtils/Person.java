package beanUtils;

import java.util.Date;

public class Person {
	private String name; 
	private String psw;
	private int age;
	public Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAB() {
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw=psw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	
}
