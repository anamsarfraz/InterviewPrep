/*
 * Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

 */
import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 

        if (a.size() <= 1) {
            return result;
        }

        ArrayList<Integer> sumArr = new ArrayList<Integer>();
        sumArr.add(0);

        int sum = 0;
        for (int i=0; i < a.size(); i++) {
            sum += a.get(i);
            sumArr.add(sum);
        }
        
        int start = -1;
        int end = -1;

        for (int i=0; i < sumArr.size(); i++) {
            int key = sumArr.get(i);
            if (hmap.containsKey(key)) {
                if (i - hmap.get(key) > end-start) {
                    start = hmap.get(key);
                    end = i;
                }
                
            } else {
                hmap.put(sumArr.get(i), i);
            }
        }
        
        
        for (int i=start; i <= end-1; i++) {
            result.add(a.get(i));
        }
        
        return result;
        
    }
}
