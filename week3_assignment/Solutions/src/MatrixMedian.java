/*
 * Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
 */
import java.util.ArrayList;

public class MatrixMedian {
    public int upper_bound(ArrayList<Integer> arr, int mid) {
        int count = 0;
        for (Integer i: arr) {
            if (i <= mid) {
                count++;
            }
        }
        return count;
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        
        if (A.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        int mid;
        int size = A.size() * A.get(0).size();
        
        if (size %2 == 0) {
            return -1;
        }
        
        while(right - left > 1){
            mid = (left+right) / 2;
            int count = 0;
            for(ArrayList<Integer> arr: A){ 
                //using upper bound in a sorted array to count number of elements smaller than or equal to mid
                int smallerThanMid = upper_bound(arr, mid);
                count += smallerThanMid;
            }
            if(count >= (size/2 +1)) {
                right = mid;
            } else {
                left = mid;
            }
        }   
        return right;
        
    }
}
