package dsa.matrix;

/**
 * @author Heshan Karunaratne
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
//        int[][] arr = {{0, 1, 2, 0}, {3, 4, 0, 2}, {1, 3, 1, 5}, {8, 7, 6, 9}};
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr);
    }

    public static void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 | matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }

        if (firstCol) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
