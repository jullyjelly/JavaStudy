package Algorithm;

import java.util.*;
public class FirstInsertNode {
	public static class Node{
		int num;
		Node next;
		public Node(int num) {
			this.num=num;
		}
	}
	public static Node findFirst(Node head1,Node head2) {
		Node loop1=findLoopHead(head1);
		Node loop2=findLoopHead(head2);
		if(loop1==null && loop2==null) {
			return noLoop(head1,head2);
		}
		else if(loop1!=null && loop2!=null) {
			return bothLoop(head1,loop1,head2,loop2);
		}
		return null;
	}
	public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2) {
		if(loop1==loop2) {
			int n=0;
			Node cur1=head1;
			Node cur2=head2;
			while(cur1!=loop1) {
				n++;
				cur1=cur1.next;
			}
			while(cur2!=loop2) {
				n--;
				cur2=cur2.next;
			}
			cur1 = n > 0 ? head1 : head2 ;
			cur2 = cur1 == head1 ? head2 : head1;
			for(int x=0;x<Math.abs(n);x++) {
				cur1=cur1.next;
			}
			while(cur1!=cur2) {
				cur1=cur1.next;
				cur2=cur2.next;
			}
			return cur1;
		}
		Node l1=loop1.next;
		while(l1!=loop2) {
			if(l1==loop1)
				return null;
			l1=l1.next;
		}
		return loop1;
		
	}
	public static Node noLoop(Node head1,Node head2) {
		int n=0;
		Node cur1=head1;
		Node cur2=head2;
		while(cur1!=null) {
			n++;
			cur1=cur1.next;
		}
		while(cur2!=null) {
			n--;
			cur2=cur2.next;
		}
		if(cur1!=cur2)
			return null;
		cur1 = n > 0 ? head1 : head2 ;
		cur2 = cur1 == head1 ? head2 : head1;
		for(int x=0;x<Math.abs(n);x++) {
			cur1=cur1.next;
		}
		while(cur1!=cur2) {
			cur1=cur1.next;
			cur2=cur2.next;
		}
		return cur1;
	}
	public static Node findLoopHead(Node head) {
		HashSet<Node> hs=new HashSet<Node>();
		boolean flag=true;
		while(head!=null) {
			flag=hs.add(head);
			if(!flag)
				return head;
			head=head.next;
		}
		return null;
	}
	public static Node findLoopHead2(Node head) {
		if(head==null || head.next==null || head.next.next==null)
			return null;
		Node slow=head;
		Node fast=head;
		while(slow!=fast) {
			if(fast.next==null || fast.next.next==null)
				return null;
			slow=slow.next;
			fast=fast.next.next;
		}
		fast=head;
		while(fast!=slow) {
			fast=fast.next;
			slow=slow.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		Node head1=new Node(1);
		Node head2=new Node(2);
		Node head3=new Node(3);
		Node head4=new Node(4);
		Node head5=new Node(5);
		Node head6=new Node(6);
		Node head7=new Node(7);
		Node head8=new Node(8);
		Node head9=new Node(9);
		Node head10=new Node(10);
		Node head11=new Node(11);
		Node head12=new Node(12);
		
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head5;
		head5.next=head6;
		head6.next=head7;
		head7.next=head4;
		
		head8.next=head9;
		head9.next=head3;
		System.out.println(findFirst(head1,head8).num);
		
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head5;
		head5.next=head6;
		head6.next=head3;
		
		head7.next=head8;
		head8.next=head9;
		head9.next=head10;
		head10.next=head11;
		head11.next=head12;
		head12.next=head9;
		System.out.println(findFirst(head1,head7));
		
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head5;
		head5.next=head6;
		head6.next=head7;
		head7.next=head8;
		head8.next=head4;
		
		head9.next=head10;
		head10.next=head11;
		head11.next=head12;
		head12.next=head8;
		System.out.println(findFirst(head1,head8).num);
	}
}
