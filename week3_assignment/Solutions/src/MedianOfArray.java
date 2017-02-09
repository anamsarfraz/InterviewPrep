/*
 * There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element. 
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 
 */
import java.util.List;
public class MedianOfArray {
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

	    int m = a.size();
	    int n = b.size();
	    
        if (m > n) {
            return findMedianSortedArrays(b, a);
        }

	    int iMin = 0;
	    int iMax = m;
	    
	    while (iMin <= iMax) {
	       int i = (iMin + iMax) / 2;
           int j = ((m + n + 1) / 2) - i;
           /*
            (j == 0 or i == m or B[j - 1] <= A[i]) and 

   (i == 0 or j == n or A[i - 1] <= B[j])
           */
           if (j > 0 && i < m && b.get(j - 1) > a.get(i)) {
              iMin = i + 1;
           } else if (i > 0 && j < n && a.get(i - 1) > b.get(j)) {
               iMax = i - 1;
           } else {
               int median1 = 0;
               int median2 = 0;
               
               if (i==0) {
                   median1 = b.get(j-1);
               } else if (j == 0) {
                   median1 = a.get(i-1);
               } else {
                   median1 = Math.max(a.get(i-1), b.get(j-1));
               }
               if ((m+n)%2 == 1) {
                   return (double)(median1);
               } 
               if (i==m) {
                 median2 = b.get(j);
                } else if (j == n) {
                  median2 = a.get(i);
                 } else {
                   median2 = Math.min(a.get(i), b.get(j));
                 }
                   
                 return (double)(median1 + median2)/2;
            }
           
        }
	    return -1;
	}
}
