package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class NQueens2 {

    public static void main(String[] args) {
        int i = totalNQueens(4);
        System.out.println(i);
    }

    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> res = new ArrayList<>();
        solve(res, n, 0, board);
        return res.size();
    }

    static void solve(List<List<String>> res, int n, int row, char[][] board) {
        if (n == row) {
            res.add(construct(board));
        }

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, row, col)) {
                board[row][col] = 'Q';
                solve(res, n, row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    private static boolean canPlaceQueen(char[][] board, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            res.add(new String(chars));
        }
        return res;
    }
}
