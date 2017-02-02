/*
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

import java.util.List;

public class ValidSudoku {
	public int isValidSudoku(final List<String> a) {
	    if (a.size() != 9) {
	        return 0;
	    }
	    
	    char[][] row = new char[9][9];
	    char[][] col = new char[9][9];
	    char[][][] square = new char[3][3][9];
	    for (int i=0; i < a.size(); i++) {
	        String str = a.get(i);
	        if (str.length() != 9) {
	            return 0;
	        }
	        for (int j=0; j < str.length(); j++) {
	            Character c = str.charAt(j);
	            if (c < '1' || c > '9') {
	                continue;
	            }
	            
	            int index = c - '1';
	            if (row[i][index] == c || col[j][index] == c || square[i/3][j/3][index] == c) {
	                return 0;
	            }
	            
	            row[i][index] = c;
	            col[j][index] = c;
	            square[i/3][j/3][index] = c;
	            

	        }
	        
	    }
	    
	    return 1;
	}

}
