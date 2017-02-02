
/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.
 */
public class ListCycle {
	
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
}

	public ListNode detectCycle(ListNode a) {
	    if (a== null) {
	        return null;
	    }
	    ListNode slow = a;
	    ListNode fast = a;
	    boolean cycleExists = false;
	    
	    while (fast != null && fast.next != null) {

	        slow = slow.next;
	        fast = fast.next.next;
	        
	        if (fast == slow) {
	            cycleExists = true;
	            break;
	        }
	    }
	    
	    if (!cycleExists) {
	        return null;
	    }
	    
	    slow = a;
	

	    while (slow != fast) {
	        slow = slow.next;
	        fast = fast.next;

	        if (slow == fast) {
	            break;
	        }
	
	    }
	    
	    return slow;
	}

}
