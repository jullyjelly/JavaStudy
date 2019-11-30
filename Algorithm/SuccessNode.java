package Algorithm;

import java.util.*;

public class SuccessNode {
	public static class Node{
		public int val;
		public Node left;
		public Node right;
		public Node parent;
		Node(int val){
			this.val=val;
		}
	}
	public static Node findSuccessNode(Node head) {
		if(head==null)
			return null;
		if(head.right!=null) {
			Stack<Node> s1=new Stack<Node>();
			Stack<Node> s2=new Stack<Node>();
			head=head.right;
			s1.push(head);
			while(!s1.empty()) {
				head=s1.pop();
				s2.push(head);
				if(head.left!=null)
					s1.push(head.left);
				if(head.right!=null)
					s1.push(head.right);
			}
			return s2.pop();
		}
		while(head.parent!=null)
			if(head.parent.left!=head) {
				head=head.parent;
			}
			else {
				return head.parent;
			}
		return null;
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
		
		head1.left=head2;
		head1.right=head3;
		head2.parent=head1;
		head3.parent=head1;
		
		head2.left=head4;
		head2.right=head5;
		head4.parent=head2;
		head5.parent=head2;
		
		head5.left=head7;
		head5.right=head8;
		head7.parent=head5;
		head8.parent=head5;
		
		head3.right=head6;
		head6.parent=head3;
		System.out.println(findSuccessNode(head7).val);
	}
}
