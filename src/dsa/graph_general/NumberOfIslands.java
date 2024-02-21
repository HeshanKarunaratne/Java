package dsa.graph_general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class NumberOfIslands {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return count;
    }

    private static void bfs(int ro, int co, int[][] visited, char[][] grid) {
        visited[ro][co] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        int[][] types = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for (int[] type : types) {
                int nRow = row + type[0];
                int nCol = col + type[1];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    queue.add(new Pair(nRow, nCol));
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }
}
