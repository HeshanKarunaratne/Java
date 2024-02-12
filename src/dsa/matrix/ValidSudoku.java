package dsa.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heshan Karunaratne
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] arr = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(arr));

    }

    public static boolean isValidSudoku(char[][] board) {

        if (board == null || board.length == 0) return false;

        boolean isValid = true;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char val = board[i][j];
                if (val != '.') {
                    String rowVal = "R" + i + val;
                    String colVal = "C" + j + val;
                    String gridVal = "GRID"  + val + i/3 + j/3;

                    if (!set.contains(rowVal)) set.add(rowVal);
                    else return false;

                    if (!set.contains(colVal)) set.add(colVal);
                    else return false;

                    if (!set.contains(gridVal)) set.add(gridVal);
                    else return false;

                }
            }
        }
        return isValid;
    }
}
