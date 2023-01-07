package HackerRankQuestions;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class HourGlassSolution {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 9, 2, -4, -4, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, -1, -2, -4, 0}};

        System.out.println("........MAX........");
        System.out.println(findMax(arr));
        System.out.println("........MAX........");
    }

    private static int findMax(int[][] arr) {
        int temp[] = new int[16];
        int pointer = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                temp[pointer++] = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
            }
        }

        Arrays.sort(temp);
        return temp[temp.length-1];
    }

    private static void print(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
