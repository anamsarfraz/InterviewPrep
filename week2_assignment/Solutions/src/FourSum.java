/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 */

import java.util.ArrayList;
import java.util.Collections;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    int size = a.size();
	    if (size <= 3) {
	        return result;
	    }
	    
	    Collections.sort(a);
	    for (int i=0; i < size-3; i++) {
	        if (i > 0 && a.get(i) == a.get(i - 1)) {
                continue;
            }
	        for (int j=i+1; j < size-2; j++) {
	            if (j > i+1 && a.get(j) == a.get(j - 1)) {
                    continue;
                }
	            int num1 = a.get(i);
	            int num2 = a.get(j);
	            int target = b - num1 - num2;
	            int start = j+1;
	            int end = size-1;
	            
	            while (start < end) {
	                int sum = a.get(start) + a.get(end);
	                if (sum == target){
	                    int num3 = a.get(start);
	                    ArrayList<Integer> tuple = new ArrayList<Integer>();
	                    tuple.add(num1);
	                    tuple.add(num2);
	                    tuple.add(num3);
	                    tuple.add(a.get(end));
	                    result.add(tuple);
	                } else if (sum > target) {
	                    end--;
	                } else if (sum < target) {
	                    start++;
	                } 
	                
	                if (sum == target){

	                    
	                    start++;
	                    
	                    while (start < end && a.get(start) == a.get(start-1)) {
	                        start++;
	                    }
	
	                    
	                }
	            }
	        }
	    }
	    
	    return result;
	}
}
