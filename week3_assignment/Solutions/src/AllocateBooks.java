/*
 * N number of books are given. 
The ith book has Pi number of pages. 
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:
 List of Books M number of students 

Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113. 
 */
import java.util.ArrayList;

public class AllocateBooks {
    public boolean isPossible(ArrayList<Integer> a, int m, int currMin) {
        int currSum = 0;
        int numStudents = 1;
        
        for (int i=0; i < a.size(); i++) {
            if (a.get(i) > currMin) {
                return false;
            }   
            
            if (a.get(i)+currSum > currMin) {
                numStudents++;
                currSum = a.get(i);
                if (numStudents > m) {
                    return false;
                }
                
            } else {
                currSum += a.get(i);
            }
            
            
        }
        
        return true;    

    }
    
	public int books(ArrayList<Integer> a, int b) {
	    if (b > a.size()) {
	        return -1;
	    }
	    
	    int minMax = Integer.MAX_VALUE;
	    int sum = 0;

	    for (int i=0; i < a.size(); i++) {
	        sum += a.get(i);
	    }

	    int start = 0;
	    int end = sum;
	    int mid;
	    
	    while (start <= end) {
	        mid = (start+end)/2;
	        if (isPossible(a, b, mid)) {
	            minMax = Math.min(minMax, mid);
	            end = mid-1;
	        } else {
	            start = mid+1;
	        }
	    }
	    
	    
	    return minMax;
	}
}
