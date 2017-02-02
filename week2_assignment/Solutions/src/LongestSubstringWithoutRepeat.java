/*
 * Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
		public int lengthOfLongestSubstring(String a) {
		    int length = 0;
		    
		    if (a.length() == 0 || a.length() == 1) {
		        return a.length();
		    }
		    
		    HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		    
		    int start = 0;
		    int end = 0;
		    
		    for (int i=0; i < a.length(); i++) {
		        if (hmap.containsKey(a.charAt(i))) {
		            if ((end-start+1) > length) {
		                length = end-start+1;
		            }
		            
		            int oldEnd = hmap.get(a.charAt(i));
		            for (int j=start; j <=oldEnd; j++) {
		                hmap.remove(a.charAt(j));
		            } 
		            
		            start = oldEnd+1;
		        }
		        hmap.put(a.charAt(i), i);
		        end = i;
		    }
		    
		    if ((end-start+1) > length) {
		        length = end-start+1;
		    }
		    
		    return length;
		}
}
