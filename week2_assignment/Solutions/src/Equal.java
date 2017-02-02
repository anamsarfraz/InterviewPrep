/*
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.
 */
import java.util.ArrayList;
import java.util.HashMap;


public class Equal {
    class Pair {
        int i;
        int j;
        
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        
        HashMap<Integer, Pair> hmap = new HashMap<Integer, Pair>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> currAns = new ArrayList<Integer>();
        
        int size = a.size();
        
        if (size <=3 ) {
            return result;
        }
        
        for (int l=0; l <= 3; l++) {
            currAns.add(-1);
        }
        
        for (int i=0; i < size-1; i++) {
            for (int j=i+1; j < size; j++) {
                int sum = a.get(i)+a.get(j);
                
                if (!hmap.containsKey(sum)) {
                    hmap.put(sum, new Pair(i, j));
                } else {
                    Pair pair = hmap.get(sum);
                    if (i != pair.i && i != pair.j && j != pair.i && j != pair.j) {
                        if (result.size() == 0) {
                            result.add(pair.i);
                            result.add(pair.j);
                            result.add(i);
                            result.add(j);
                        } else {
                            currAns.set(0, pair.i);
                            currAns.set(1, pair.j);
                            currAns.set(2, i);
                            currAns.set(3, j);
                            
                            boolean isNewAns = false;
                            for (int k=0; k < result.size(); k++) {
                                if (result.get(k) < currAns.get(k)) {
                                    isNewAns = false;
                                    break;
                                } else if (result.get(k) > currAns.get(k)) {
                                    isNewAns = true;
                                    break;
                                }
                            }
                            
                            if (isNewAns) {
                                for (int k=0; k < result.size(); k++) {
                                    result.set(k, currAns.get(k));
                                }
                            }
                        }
                    }
                }
                        

            }
        }
        
        return result;
    }

}
