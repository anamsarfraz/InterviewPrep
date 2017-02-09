/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,
1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
2. Entries should be sorted within themselves.

Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Combinations {
    public void combineHelper(ArrayList<Integer> current, int n, int k, ArrayList<ArrayList<Integer>> result) {
        if (k == 0) {
            ArrayList<Integer> newEntry = new ArrayList<Integer>(current); 
            Collections.sort(newEntry);
            result.add(newEntry);
            return;
        }
        if (n == 0 || n < k) return;
        // We have 2 options here. We can either include n or not. 
        // Option 1 : Do not include n.
        combineHelper(current, n - 1, k, result);
        // Option 2 : Include n. 
        current.add(n);
        combineHelper(current, n - 1, k - 1, result);
        current.remove(current.size()-1);
        return;
    }

public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    

    ArrayList<Integer> current = new ArrayList<Integer>();
    combineHelper(current, n, k, result);
    
    Collections.sort(result, new Comparator<ArrayList<Integer>>() {
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
           int i = 0;
           int compare = 0;
           while (i < a.size()) {
               if (a.get(i) < b.get(i)) {
                   compare = -1;
                   break;
               } else if (a.get(i) > b.get(i)) {
                   compare = 1;
                   break;
               }
               i++;
           }
           
           return compare;
            
        }
    });
    return result;
    
}
}
