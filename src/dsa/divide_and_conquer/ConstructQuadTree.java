package dsa.divide_and_conquer;

/**
 * @author Heshan Karunaratne
 */
public class ConstructQuadTree {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;

    public static Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private static Node construct(int[][] grid, int r, int c, int n) {
        boolean allSame = true;
        int init = grid[r][c];
        int val = grid[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (grid[i][j] != val) {
                    allSame = false;
                    break;
                }
            }
        }

        if (allSame) {
            return new Node(init == 1, true);
        }

        Node tL = construct(grid, r, c, n / 2);
        Node tR = construct(grid, r, c + n / 2, n / 2);
        Node bL = construct(grid, r + n / 2, c, n / 2);
        Node bR = construct(grid, r + n / 2, c + n / 2, n / 2);

        return new Node(false, false, tL, tR, bL, bR);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        Node output = construct(grid);
        System.out.println(output);
    }
}
