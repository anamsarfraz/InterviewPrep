/*
 * Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 */
import java.util.ArrayList;

public class Permutations {
    public void permuteHelper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result, int index) { 

        if (index == a.size()-1) {
           result.add(new ArrayList<Integer>());
           result.get(0).add(a.get(index));
           return;
        } 
        
        permuteHelper(a, result, index+1);
        

        
       int size = result.size() -1;
       while (size >= 0) {
           
           
           ArrayList<Integer> subResult = result.remove(0);
           int subSize = subResult.size();
           for (int i=0; i <= subSize; i++) {
               ArrayList<Integer> newSubResult = new ArrayList<Integer>(subResult);
               newSubResult.add(i, a.get(index));
               result.add(newSubResult);
           }
           
           
           size--;
       }
       
       
   }     

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    permuteHelper(a, result, 0);
	    
	    return result;
	}
}
