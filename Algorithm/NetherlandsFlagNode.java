package Algorithm;

import java.util.*;
public class NetherlandsFlagNode {
	public static class Node{
		int num;
		public Node next;
		public Node(int num) {
			this.num=num;
		}
	}
	
	public static Node netherlandsFlag(Node head,int num) {
		List<Node> arr=new ArrayList<>();
		Node cur=head;
		while(cur!=null) {
			arr.add(cur);
			cur=cur.next;
		}
		Node[] narr=arr.toArray(new Node[arr.size()]);
		netherlandsFlagArray(narr,0,narr.length-1,num);
		for(int x=0;x<narr.length-1;x++) {
			narr[x].next=narr[x+1];
			narr[x+1].next=null;
		}
		return narr[0];
	}
	public static void netherlandsFlagArray(Node[] arr,int L,int R,int num) {
		int less=L-1;
		int more=R+1;
		while(L<more) {
			if(arr[L].num<num) {
				swap(arr,L++,less+1);
				less++;
			}
			else if(arr[L].num>num) {
				swap(arr,L,more-1);
				more--;
				R--;
			}
			else {
				L++;
			}
		}
	}
	public static void swap(Node[] arr,int x,int y) {
		Node temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	public static void printList(Node[] arr) {
		for(Node n:arr) {
			System.out.println(n.num);
		}
	}
	public static void printNode(Node head) {
		while(head!=null) {
			System.out.println(head.num);
			head=head.next;
		}
	}
	public static void main(String[] args) {
		Node head1=new Node(8);
		Node head2=new Node(3);
		Node head3=new Node(5);
		Node head4=new Node(2);
		Node head5=new Node(1);
		Node head6=new Node(4);
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head5;
		head5.next=head6;
		Node newhead=netherlandsFlag(head1,4);
		printNode(newhead);
	}
}
