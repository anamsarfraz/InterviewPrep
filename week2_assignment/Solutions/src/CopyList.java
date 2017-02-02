/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
import java.util.HashMap;

public class CopyList {
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		 }
	;
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head;
        if (curr == null) {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> hmap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(curr.label);
        RandomListNode newCurr = newHead;
        
        hmap.put(curr, newCurr);
        
        curr = curr.next;
        
        while (curr != null) {
            newCurr.next = new RandomListNode(curr.label);
            newCurr = newCurr.next;
            
            hmap.put(curr, newCurr);
            curr = curr.next;
        }
        
        newCurr = newHead;
        curr = head;
        while (newCurr != null && curr != null) {
            newCurr.random = hmap.get(curr.random);
            newCurr = newCurr.next;
            curr = curr.next;
        } 
        
        return newHead;
    }
}
