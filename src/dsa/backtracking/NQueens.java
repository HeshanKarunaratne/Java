package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
 */

/**
 * @author Heshan Karunaratne
 */
public class NQueens {

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> result = new ArrayList<>();
        backTrack(n, board, 0, result);
        return result;
    }

    private static void backTrack(int n, char[][] board, int row, List<List<String>> result) {
        if (n == row) {
            result.add(constructBoard(board));
        }

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, row, col)) {
                board[row][col] = 'Q';
                backTrack(n, board, row + 1, result);
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

    private static List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}

/*
Fill the array with '.' and if we can play a queen we change it to 'Q'

Base Case - if the row == n then construct the string using the board
Placing the queen
1. In previous column
2. To left diagonal
3. To right anti-diagonal

 */