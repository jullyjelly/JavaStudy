package Algorithm;

public class ReverseNode {
	public static class Node{
		int num;
		public Node next;
		public Node(int num) {
			this.num=num;
		}
	}
	public static Node reverseList(Node head) {
		 Node pre=null;
		 Node next=null;
		 while(head!=null) {
			 next=head.next;
			 head.next=pre;
			 pre=head;
			 head=next;
		 }
		 return pre;
	}
	public static class DoubleNode {
		int num;
		DoubleNode last;
		DoubleNode next;
		public DoubleNode(int num) {
			this.num=num;
		}
	}
	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre=null;
		DoubleNode next=null;
		while(head!=null) {
			next=head.next;
			head.next=pre;
			head.last=next;
			pre=head;
			head=next;
		}
		return pre;
	}
	public static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.num+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static void printList(DoubleNode head) {
		while(head!=null) {
			System.out.print(head.num+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node head1=new Node(1);
		head1.next=new Node(2);
		head1.next.next=new Node(3);
		printList(head1);
		Node head2=reverseList(head1);
		printList(head2);
		
		DoubleNode head3=new DoubleNode(1);
		head3.next=new DoubleNode(2);
		head3.next.last=head3;
		head3.next.next=new DoubleNode(3);
		head3.next.next.next=new DoubleNode(4);
		head3.next.next.last=head3.next;
		head3.next.next.next.last=head3.next.next;
		printList(head3);
		DoubleNode head4=reverseList(head3);
		printList(head4);
	}
}
