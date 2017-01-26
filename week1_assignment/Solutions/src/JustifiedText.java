/*
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 */

/*
 * ISSUE: Not sure if the solution is the most optimized one.
 */
import java.util.ArrayList;

public class JustifiedText {

	    
	    public void createJustfiedLine(ArrayList<String> a, ArrayList<String> result, int start, int end, int wordLen, int b) {
	        
	        StringBuffer sb = new StringBuffer();
	        int remainingLen = b - wordLen;
	        int spacing = remainingLen;
	        int diff = (end - start > 1) ? end-start : 1;
	        if (diff > 1) {
	            spacing = remainingLen/ diff; 
	        }
	        
	        int mod = remainingLen % diff;
	        
	        
	        for (int i=start; i <= end; i++) {
	            sb.append(a.get(i));
	            if (remainingLen > 0) {
	                for (int j = 0; j < spacing; j++) {
	                    sb.append(' ');
	                }
	                if (mod > 0) {
	                    sb.append(' ');
	                    mod -= 1;
	                    remainingLen -= 1;
	                }
	                
	                remainingLen -= spacing;


	            }
	        }
	        
	        result.add(sb.toString());
	    }
	    
		public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
		    ArrayList<String> result = new ArrayList<String>();
		    
		    if (a.size() < 1) {
		        return a;
		    }
		    
		    int lineLen = 0;
		    int start = 0;
		    for (int i=0; i < a.size(); i++) {
		        if (lineLen > 0) {
		            lineLen += 1;
		        }
		        int strLen = a.get(i).length();
		        if (lineLen+strLen > b) {
		            createJustfiedLine(a, result, start, i-1, lineLen-i+start, b);
		            start = i;
		            lineLen = 0;
		        }
		        lineLen += strLen;
		        
		        
		    }
		    
		    StringBuffer sb = new StringBuffer();
		    for (int i=start; i < a.size(); i++) {
		        sb.append(a.get(i));
		        if (i < a.size()-1) {
		            sb.append(' ');
		        } else {
		            int diff = b-sb.length();
		            for (int j=0; j < diff; j++) {
		                sb.append(' ');
		            }
		        }
		    }
		    
		    result.add(sb.toString());
		    return result;
		}


}
