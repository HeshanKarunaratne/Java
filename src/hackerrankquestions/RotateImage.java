package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        final int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {

            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }

    public static void rotatePointer(int[][] matrix) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            for (int i = l; i <= r - 1; i++) {
                int top = l, bottom = r;

                //Save the topLeft
                int topLeft = matrix[top][l + i];

                //Move bottom Left into top left
                matrix[top][l + i] = matrix[bottom - i][l];

                //Move bottom right into bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                //Move top right into bottom right
                matrix[bottom][r - i] = matrix[top + i][r];

                //Move top left into top right
                matrix[top + i][r] = topLeft;
            }
            r -= 1;
            l += 1;
        }
    }

    /*
    1 2 3    7 4 1
    4 5 6 -> 8 5 2
    7 8 9    9 6 3
     */

    public static void main(String[] args) {

        int[][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;
        rotatePointer(arr);
    }
}

