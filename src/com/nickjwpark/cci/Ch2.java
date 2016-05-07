package com.nickjwpark.cci;

import java.util.HashSet;

public class Ch2 {
	public static void main(String[] args) {
//		q1();
//		q2();
//		q3();
//		q4();
//		q5();
		q6();
//		q7();
	}
	
	public static void q7(){
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 5; i++) {
			second = new LinkedListNode(i, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		for (int i = 4; i >= 0; i--) {
			second = new LinkedListNode(i, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		boolean isPalindrome = checkPalindrome(head);
		System.out.println(isPalindrome);
	}
	public static boolean checkPalindrome(LinkedListNode n){
		LinkedListNode palin = n.clone();
		LinkedListNode end = n;
		int count = 0;
		while(n!=null) {
			end = n;
			count++;
			n = n.next;
		}
		for(int i=0; i<count/2; i++){
//			System.out.println(""+palin.data + " " + end.data);
			if(palin.data != end.data) {
				return false;
			}
			palin = palin.next;
			end = end.prev;
		}
		return true;
	}
	
	public static void q6(){
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		LinkedListNode corruptNode = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 10, null, null);
			first.setNext(second);
			second.setPrevious(first);
			if(i==3) corruptNode = first;
			first = second;
		}
		System.out.println(head.printForward());
		second.setNext(corruptNode);
		findCorruptNode(head);
	}
	public static void findCorruptNode(LinkedListNode n){
		LinkedListNode temp = n;
		while(n!=null){
			n = n.next;
			if(temp != n.prev){
				System.out.println("CRIMINAL FOUND:"+n.data);
				break;
			}
			temp = n;
		}
	}
	
	public static void q5(){
		LinkedListNode firstNum = AssortedMethods.randomLinkedList(4, 0, 9);
		System.out.println(firstNum.printForward());
		LinkedListNode secondNum = AssortedMethods.randomLinkedList(3, 0, 9);
		System.out.println(secondNum.printForward());
		addList(firstNum, secondNum);
	}
	public static void addList(LinkedListNode n1, LinkedListNode n2){
		boolean overTen = false;
		int one = 0;
		int ten = 0;
		if(n1.data + n2.data >= 10){
			overTen = true;
			one = n1.data + n2.data - 10;
		} else {
			overTen = false;
			one = n1.data + n2.data;
		}
		n1 = n1.next;
		n2 = n2.next;
		LinkedListNode sum = new LinkedListNode(one, null, null);
		LinkedListNode first = sum;
		LinkedListNode second = sum;
		while (n1 != null || n2 != null) {
			if(n1 == null){

				if(overTen){
					ten=1;
				} else {
					ten=0;
				}

				if(n2.data + ten >= 10){
					overTen = true;
					one = n2.data + ten - 10;
				} else {
					overTen = false;
					one = n2.data + ten;
				}
				second = new LinkedListNode(one, null, null);
				first.setNext(second);
				second.setPrevious(first);
				first = second;

				n2 = n2.next;

			} else if(n2 == null){
				
				if(overTen){
					ten=1;
				} else {
					ten=0;
				}

				if(n1.data + ten >= 10){
					overTen = true;
					one = n1.data + ten - 10;
				} else {
					overTen = false;
					one = n1.data + ten;
				}
				second = new LinkedListNode(one, null, null);
				first.setNext(second);
				second.setPrevious(first);
				first = second;

				n1 = n1.next;
				
			} else {
				
				if(overTen){
					ten=1;
				} else {
					ten=0;
				}
				
				if(n1.data + n2.data + ten >= 10){
					overTen = true;
					one = n1.data + n2.data + ten - 10;
				} else {
					overTen = false;
					one = n1.data + n2.data + ten;
				}
				second = new LinkedListNode(one, null, null);
				first.setNext(second);
				second.setPrevious(first);
				first = second;

				n1 = n1.next;
				n2 = n2.next;
			}		
		}
		if(overTen){
			second = new LinkedListNode(1, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		System.out.println(sum.printForward());
	}
	
	public static void q4(){
		LinkedListNode first = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(first.printForward());
		int x = 5;
		partision(first, x);
	}
	public static void partision(LinkedListNode n, int x){
		LinkedListNode less = new LinkedListNode(0, null, null);
		LinkedListNode lessFirst = less;
		LinkedListNode lessSecond = less;
		LinkedListNode more = new LinkedListNode(x, null, null);
		LinkedListNode moreFirst = more;
		LinkedListNode moreSecond = more;
		boolean lessFound = false;
		while (n != null) {
			if(n.data < x){
				if(lessFound){
					lessSecond = new LinkedListNode(n.data, null, null);
					lessFirst.setNext(lessSecond);
					lessSecond.setPrevious(lessFirst);
					lessFirst = lessSecond;
				} else {
					lessFound = true;
					less = new LinkedListNode(n.data, null, null);
					lessFirst = less;
					lessSecond = less;
				}
			} else {
				moreSecond = new LinkedListNode(n.data, null, null);
				moreFirst.setNext(moreSecond);
				moreSecond.setPrevious(moreFirst);
				moreFirst = moreSecond;
			}
			n = n.next;
		}
		lessSecond.setNext(more);
		System.out.println(less.printForward());
	}
	
	public static void q3(){
		LinkedListNode first = new LinkedListNode(0, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 10, null, null);
			first.setNext(second);
			first = second;
		}
		System.out.println(head.printForward());
		LinkedListNode head2 = head;
		
		for (int i = 0; i < 4; i++) {
			head = head.next;
		}		
		System.out.println(""+head.data);	
		deleteNode(head);
		System.out.println(head2.printForward());
	}
	public static void deleteNode(LinkedListNode n){
		if(n.next!=null){
			n.data = n.next.data;
			n.next = n.next.next;			
		} else {
			return;
		}
	}
	
	public static void q2(){
		LinkedListNode first = AssortedMethods.randomLinkedList(10, 0, 10);
		LinkedListNode head = first;
		System.out.println(head.printForward());
		int k = 4;
		getKthLast(head, k);
	}
	public static void getKthLast(LinkedListNode n, int k){
		LinkedListNode clone = n.clone();
		int len = 0 ;
		while (clone != null) {
			len++;
			clone = clone.next;
		}		
		if(k > len) return;
		for(int i=0; i<(len-k); i++){
			n = n.next;
		}
		System.out.println(""+n.data);
		
	}
	
	public static void q1(){
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		LinkedListNode clone = head.clone();
		deleteDupsA(head);
		System.out.println(head.printForward());
		deleteDupsC(clone);
		System.out.println(head.printForward());
	}
	public static void deleteDupsA(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	public static void deleteDupsC(LinkedListNode head) {
		if (head == null) return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			LinkedListNode runner = head;
			while (runner != current) { 
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/* We know we can't have more than one dup preceding
					 * our element since it would have been removed 
					 * earlier. */
				    break;
				}
				runner = runner.next;
			}
			
			/* If runner == current, then we didn't find any duplicate 
			 * elements in the previous for loop.  We then need to 
			 * increment current.  
			 * If runner != current, then we must have hit the ‘break’ 
			 * condition, in which case we found a dup and current has
			 * already been incremented.*/
			if (runner == current) {
				previous = current;
		        current = current.next;
			}
		}
	}
}
