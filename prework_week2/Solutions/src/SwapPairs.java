/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
public class SwapPairs {
	 class ListNode {
		 public int val;
		 public ListNode next;
		 ListNode(int x) { val = x; next = null; }
	}
	 	 
	public ListNode swapPairs(ListNode a) {
	    
	    if (a==null) {
	        return a;
	    }
	    
	    ListNode curr = a;
	    ListNode prev = null;

	    while (curr != null && curr.next != null) {
            if (prev == null) {
                a = curr.next;
            } else {
                prev.next = curr.next;
            }
            prev = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = curr.next;
            prev = prev.next;
	    }
	    return a;

	}
}
