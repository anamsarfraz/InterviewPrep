
/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PatitionList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    
	public ListNode partition(ListNode a, int b) {

	    if (a == null) {
	        return a;
	    }
        
        ListNode head = new ListNode(-1);
        head.next = a;
        ListNode prev = head;
        ListNode curr = a;
        
        ListNode geHead = new ListNode(-1);
        ListNode geCurr = geHead;
        
        while (curr != null) {
            if (curr.val >= b) {
                prev.next = curr.next;
                geCurr.next = curr;
                geCurr = geCurr.next;
                geCurr.next = null;
            } else {
                prev = prev.next;
            }
            curr = prev.next;

            
        }
        prev.next = geHead.next;
        
        return head.next;
	    
	}
    
    
}
