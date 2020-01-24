package cn.reflect;

import java.io.InputStream;
import java.util.*;



public class Person {
	public String t="ssss";
	private String v="vvv";
	private static int num=3;
	public Person(){
		System.out.println("a");
	}
	public Person(String s){
		System.out.println(s);
	}
	public Person(String s,int i){
		System.out.println(s+"+"+i);
	}
	private Person(List list){
		System.out.println("list");
	}
	public void m1() {
		System.out.println("m1");
	}
	public void m1(String s,int n) {
		System.out.println(s+":"+n);
	}
	public Class[] m2(String s,int[] n) {
		return new Class[] {String.class};
	}
	private void m2(InputStream in) {
		System.out.println(in);
	}
	public static void m2(int num) {
		System.out.println(num);
	}
	public static void main(String[] args) {
		System.out.println("main");
	}
}
