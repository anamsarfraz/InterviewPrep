/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */

import java.util.HashMap;

public class WindowString {
	public String minWindow(String S, String T) {
	    if (S.length() < T.length()) {
	        return "";
	    }
	    
	    HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
	    int count;
	    
	    for (int i=0; i < T.length(); i++) {
            count = 1;
            if (hmap.containsKey(T.charAt(i))) {
                count += hmap.get(T.charAt(i));
            }
            
            hmap.put(T.charAt(i), count);
	    }
	    
        int start = 0;
        int length = 0;
        int head = 0;
        int tail = 0;
	    int total = 0;

	    while (tail < S.length()) {
	        if (!hmap.containsKey(S.charAt(tail))) {
	            tail++;
	            continue;
	        }
	        
	        count = hmap.get(S.charAt(tail)) - 1;
	        hmap.put(S.charAt(tail), count);
	        if (count >= 0) {
	            total++;
	        }
	        
	        if (total == T.length()) {
	            while (!hmap.containsKey(S.charAt(head)) || hmap.get(S.charAt(head)) < 0) {
	                if (hmap.containsKey(S.charAt(head))) {
	                    count = hmap.get(S.charAt(head)) + 1;
	                    hmap.put(S.charAt(head), count);
	                }
	                head++;
	            }
	            
	            if (length==0 || tail-head+1 < length) {
	                length = tail - head+1;
	                start = head;

	            }
	        }
	        
	        
	        tail++;
	    }
	    return S.substring(start, start+length);
	}

}
