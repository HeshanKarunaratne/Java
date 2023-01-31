package hackerrankquestions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class LeftRotateList {

    public static int[] rotateLeft(int d, int[] arr) {
        int[] temp = new int[arr.length];
        int size = arr.length;

        for (int i = 0; i < size; i++) {

            int newIndex = (i + (size - d)) % (size);
            int val = arr[i];
            temp[newIndex] = val;
        }

        return temp;
    }

    public static List<Integer> rotateLeftList(int d, List<Integer> arr) {
        int size = arr.size();
        List<Integer> temp = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            temp.add(i, 0);
        }

        for (int i = 0; i < size; i++) {

            int newIndex = (i + (size - d)) % (size);
            int val = arr.get(i);
            temp.set(newIndex, val);
        }

        return temp;
    }

}

class SolutionLeftRotateList {
    public static void main(String[] args) throws IOException {

        int d = 2;
        int[] arr = {10, 20, 30, 40, 50};
        List<Integer> intArr = new ArrayList<>();

        for (int i : arr) {
            intArr.add(i);
        }

        List<Integer> result = LeftRotateList.rotateLeftList(d, intArr);

        for (int i : result) {
            System.out.println(i);
        }

    }
}