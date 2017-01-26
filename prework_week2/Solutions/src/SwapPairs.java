
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
