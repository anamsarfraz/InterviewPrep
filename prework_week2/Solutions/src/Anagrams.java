
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Anagrams {
    
    public boolean isAnagram(List<String> a, int idxA, int idxB) {
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        String aStr = a.get(idxA);
        String bStr = a.get(idxB);
        
        if (aStr.length() != bStr.length()) {
            return false;
        }
        
        for (int i=0; i < aStr.length(); i++) {
            int count = 1;
            if (hmap.containsKey(aStr.charAt(i))) {
                count += hmap.get(aStr.charAt(i));
            }
            hmap.put(aStr.charAt(i), count);
            
        }
        
        for (int i=0; i < bStr.length(); i++) {
            if (hmap.containsKey(bStr.charAt(i))) {
                int count = hmap.get(bStr.charAt(i))-1;
                if (count == 0) {
                    hmap.remove(bStr.charAt(i));
                } else {
                    hmap.put(bStr.charAt(i), count);
                }
            }
        }
        
        return hmap.isEmpty();
    }
    
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    
	    result.add(new ArrayList<Integer>());
	    result.get(0).add(1);
	    
	    for (int i=1; i < a.size(); i++) {
	        boolean foundAnagram = false;
	        int j = 0;
	        for (j=0; j < result.size(); j++) {
	            if (isAnagram(a, result.get(j).get(0)-1, i)) {
	                result.get(j).add(i+1);
	                foundAnagram = true;
	                break;
	            }
	        }
	        
	        if (!foundAnagram) {
	            result.add(new ArrayList<Integer>());
	            result.get(j).add(i+1);
	        }
	    }
	    
	    return result;
	}
}

