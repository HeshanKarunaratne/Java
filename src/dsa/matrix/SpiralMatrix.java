package dsa.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return null;
        List<Integer> list = new ArrayList<>();

        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int i = colBegin; i <= colEnd; i++)
                list.add(matrix[rowBegin][i]);

            rowBegin++;

            for (int j = rowBegin; j <= rowEnd; j++)
                list.add(matrix[j][colEnd]);

            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--)
                    list.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--)
                    list.add(matrix[j][colBegin]);
            }
            colBegin++;
        }

        return list;
    }
}
