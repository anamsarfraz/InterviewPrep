/*
 * Given a digit string, return all possible letter combinations that the number could represent.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
 */
import java.util.HashMap;
import java.util.ArrayList;

public class LetterPhone {
    HashMap<Character, String> hmap = new HashMap<Character, String>() {{
        put('0', "0");
        put('1', "1");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
	/*
	//Iterative
	public ArrayList<String> letterCombinations(String a) {
	    ArrayList<String> subResult = new ArrayList<String>();
	    ArrayList<String> result = new ArrayList<String>();
	    
	    result.add("");
	    for (int i=0; i < a.length(); i++) {
	        String mapping = hmap.get(a.charAt(i));
	        for (String prefix: result) {
	            for (int j=0; j < mapping.length(); j++) {
	                subResult.add(prefix+mapping.charAt(j));
	            }
	            
	        }
	        
	        result = subResult;
	        subResult = new ArrayList<String>();
	        
	    }
	    
	    return result;
	    
	}
	*/
	
	// Recursive
	public ArrayList<String> letterCombHelper(String a, int index) {
	    if (index < 0) {
	        ArrayList<String> result = new ArrayList<String>();
	        result.add("");
	        return result;
	    }
	    
	    ArrayList<String> subResult = letterCombHelper(a, index-1);
	    ArrayList<String> result = new ArrayList<String>();
	    String mapping = hmap.get(a.charAt(index));
	    
	    for (String str: subResult) {
	        for (int i=0; i < mapping.length(); i++) {
	            result.add(str+mapping.charAt(i));
	        }
	    }
	    
	    return result;
	    
	    
	}
	public ArrayList<String> letterCombinations(String a) {
	    
	    return letterCombHelper(a, a.length()-1);
	    
	}
}
