import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SubstringConcatenation {

	    
	    public boolean matchSubstring(String a, List<String> b, HashMap<String, Integer> hmap, int i) {
	        int strLen = b.get(0).length();
	        boolean matchFound = true;
	        int matchCount = b.size();
	        int end = i + (strLen*b.size());
	        
	        HashMap<String, Integer> matchMap = new HashMap<String, Integer>();
	        
	        for (; i <= a.length()-strLen && i < end; i+= strLen) {
	            String str = a.substring(i, i+strLen);
	            if (hmap.containsKey(str)) {
	                int count = matchMap.containsKey(str) ? matchMap.get(str)+1 : 1;
	                if (count > hmap.get(str)) {
	                    break;
	                }
	                matchMap.put(str, count);
	                matchCount--;
	            } else {
	                break;
	            }   
	        }
	        
	        if (matchCount !=0) {
	            matchFound = false;
	        }
	        
	        return matchFound;
	    }
	    
		public ArrayList<Integer> findSubstring(String a, final List<String> b) {
		    HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		    ArrayList<Integer> result = new ArrayList<Integer>();
		    
		    int strLen = b.get(0).length();
		    
		    for (int i=0; i < b.size(); i++) {
		        int count = hmap.containsKey(b.get(i)) ? hmap.get(b.get(i))+1 : 1; 
		        hmap.put(b.get(i), count);
		    }
		    
		    int i=0;

		    while (i <=a.length()-strLen) {
		        String str = a.substring(i, i+strLen);
		        if (hmap.containsKey(str)) {
		            if (matchSubstring(a, b, hmap, i)) {
		                result.add(i);
		            }
		        } 
		        i++;
		    }
		    
		    return result;
		}
}
