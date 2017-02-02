
/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
import java.util.ArrayList;
public class SortedInsertPosition {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    int start = 0;
	    int end = a.size()-1;
	    int mid = -1;
	    
	    if (a.size() == 0) {
	        return 0;
	    }
	    
	    while (start <= end) {
	        mid = (start+end)/2;

	        if (b < a.get(mid)) {
	            end = mid-1;
	        } else if (b > a.get(mid)) {
	            start = mid+1;
	        } else if (b == a.get(mid)) {
	            return mid;
	        }
	        
	    }
	    
	    return end+1;
	    // return start; // both are correct

	}
}
