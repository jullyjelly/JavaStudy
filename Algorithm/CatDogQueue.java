package Algorithm;

import java.util.*;
public class CatDogQueue {
	public static class Pet{
		private String type;
		Pet(String type){
			this.type=type;
		}
		public String getPetType() {
			return this.type;
		}
	}
	public static class Cat extends Pet{
		Cat(){
			super("cat");
		}
	}
	public static class Dog extends Pet{
		Dog(){
			super("dog");
		}
	}
	
	
	public static class PetQueue{
		private Pet pet;
		private long count;
		PetQueue(Pet pet,long count){
			this.pet=pet;
			this.count=count;
		}
		public Pet getPet() {
			return this.pet;
		}
		public long getCount() {
			return this.count;
		}
	}
	
	
	public static class CatDog{
		private Queue<PetQueue> catQ;
		private Queue<PetQueue> dogQ;
		private long count;
		CatDog(){
			this.catQ=new LinkedList<PetQueue>();
			this.dogQ=new LinkedList<PetQueue>();
			this.count=0;
		}
		public void add(Pet p) {
			if(p.getPetType().equals("cat")) {
				catQ.add(new PetQueue(p,count++));
			}
			else if(p.getPetType().equals("dog")) {
				dogQ.add(new PetQueue(p,count++));
			}
			else {
				throw new RuntimeException("not dog or cat");
			}
		}
		public long getCount() {
			return this.count;
		}
		public Pet poolAll() {
			if(catQ.isEmpty() && dogQ.isEmpty()) {
				throw new RuntimeException("queue is empty");
			}
			else if(catQ.isEmpty() && !dogQ.isEmpty()) {
				System.out.println(dogQ.peek().getPet().getPetType()+dogQ.peek().getCount());
				return dogQ.poll().getPet();
			}
			else if(!catQ.isEmpty() && dogQ.isEmpty()) {
				System.out.println(catQ.peek().getPet().getPetType()+catQ.peek().getCount());
				return catQ.poll().getPet();
			}
			else {
				if(catQ.peek().getCount()<dogQ.peek().getCount()) {
					System.out.println(catQ.peek().getPet().getPetType()+catQ.peek().getCount());
					return catQ.poll().getPet();
				}
				else {
					System.out.println(dogQ.peek().getPet().getPetType()+dogQ.peek().getCount());
					return dogQ.poll().getPet();
				}
			}
		}
		public Cat pollCat() {
			if(!catQ.isEmpty()) {
				return (Cat) catQ.poll().getPet();
			}
			else {
				throw new RuntimeException("cat queue is empty");
			}
		}
		public Dog pollDog() {
			if(!dogQ.isEmpty()) {
				return (Dog)dogQ.poll().getPet();
			}
			else {
				throw new RuntimeException("cat queue is empty");
			}
		}
		public boolean isAllEmpty() {
			return catQ.isEmpty() && dogQ.isEmpty();
		}
		public boolean isDogEmpty() {
			return dogQ.isEmpty();
		}
		public boolean isCatEmpty() {
			return catQ.isEmpty();
		}
	}
	public static void main(String[] args) {
		CatDog test=new CatDog();
		test.add(new Cat());
		test.add(new Dog());
		test.add(new Dog());
		test.add(new Dog());
		test.add(new Cat());
		test.add(new Cat());
		test.add(new Cat());
		test.add(new Dog());
		test.add(new Cat());
		test.add(new Dog());
//		while(!test.isAllEmpty()) {
//			System.out.println(test.poolAll().getPetType());
//		}
		while(!test.dogQ.isEmpty()) {
			System.out.println(test.pollDog().getPetType());
		}
		while(!test.isAllEmpty()) {
			System.out.println(test.poolAll().getPetType());
		}
	}
}
