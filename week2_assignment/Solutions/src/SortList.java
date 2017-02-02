/*
 * Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
 */
public class SortList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    
    public ListNode mergeSortedLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        
        ListNode head;
        ListNode headA = a;
        ListNode headB = b;
        
        if (headA.val < headB.val) {
            head = headA;
            headA = headA.next;
        } else {
            head = headB;
            headB = headB.next;
        }
        
        ListNode curr = head;
        
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                curr.next = headA;
                headA = headA.next;
            } else {
                curr.next = headB;
                headB = headB.next;
            }
            curr = curr.next;
        }
        
        if (headA != null) {
            curr.next = headA;
        } else {
            curr.next = headB;
        }
        
        return head;
        
    }
	public ListNode sortList(ListNode a) {
	    if (a == null || a.next == null) {
	        return a;
	    }
	    
        ListNode slow = a;
        ListNode fast = a.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        
        slow.next = null;
        
        return mergeSortedLists(sortList(a), sortList(fast));
        

	}
}
