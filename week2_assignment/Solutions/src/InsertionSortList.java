/*
 * Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
 */
public class InsertionSortList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
	public ListNode insertionSortList(ListNode a) {
	    if (a == null) {
	        return a;
	    }
	    
        ListNode sorted = null;
        ListNode unsorted = a;
        ListNode curr = null;
        
        while (unsorted != null) {
            curr = unsorted;
            unsorted = unsorted.next;
            
            if (sorted == null || sorted.val > curr.val) {
                curr.next = sorted;
                sorted = curr;
            } else {
                ListNode s = sorted;
                while (s != null) {
                    if (s.next == null || s.next.val > curr.val) {
                        curr.next = s.next;
                        s.next = curr;
                        break;
                    }
                    s = s.next;
                }
            }
        }
	    

	    return sorted;
	    
	}

}
