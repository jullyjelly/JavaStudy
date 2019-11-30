package Algorithm;

import java.util.*;
public class BinaryTreeTraversal {
	public static class Node{
		public int val;
		public Node left;
		public Node right;
		Node(int val){
			this.val=val;
		}
	}
	public static void preorderTraversal(Node head) {
		if(head!=null) {
			System.out.println(head.val);
			preorderTraversal(head.left);
			preorderTraversal(head.right);
		}
	}
	public static void preorderTraversal2(Node head) {
		if(head!=null) {
			Stack<Node> s=new Stack<Node>();
			s.push(head);
			while(!s.empty()) {
				head=s.pop();
				System.out.print(head.val+" ");
				if(head.right!=null) {
					s.push(head.right);
				}
				if(head.left!=null) {
					s.push(head.left);
				}
			}
			System.out.println();
		}
	}
	public static void inOrderTraversal(Node head) {
		if(head!=null) {
			inOrderTraversal(head.left);
			System.out.println(head.val);
			inOrderTraversal(head.right);
		}
	}public static void inOrderTraversal2(Node head) {
		if(head!=null) {
			Stack<Node> s=new Stack<Node>();
			while(!s.empty() || head!=null) {
				if(head!=null) {
					s.push(head);
					head=head.left;
				}
				else {
					head=s.pop();
					System.out.print(head.val+" ");
					head=head.right;
				}
			}
			System.out.println();
		}
	}
	public static void postorderTraversal(Node head) {
		if(head!=null) {
			postorderTraversal(head.left);
			postorderTraversal(head.right);
			System.out.println(head.val);
		}
	}
	public static void postorderTraversal2(Node head) {
		if(head!=null) {
			Stack<Node> s1=new Stack<Node>();
			Stack<Node> s2=new Stack<Node>();
			s1.push(head);
			while(!s1.empty()) {
				head=s1.pop();
				s2.push(head);
				if(head.left!=null)
					s1.push(head.left);
				if(head.right!=null)
					s1.push(head.right);
			}
			while(!s2.empty()) {
				System.out.print(s2.pop().val+" ");
			}
			System.out.println();
		}
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
		head2.left=head4;
		head2.right=head5;
		head5.left=head7;
		head5.right=head8;
		head3.right=head6;
		
		preorderTraversal2(head1);
		inOrderTraversal2(head1);
		postorderTraversal2(head1);
	}
}