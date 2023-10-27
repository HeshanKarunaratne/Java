package hackerrankquestions;

import java.util.Arrays;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class Equal {

    public static void main(String[] args) {
        List<Integer> list = List.of(11, 6, 8, 7);
        System.out.println(equal(list));
    }

    public static int equal(List<Integer> list) {

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        int[] possibilities = new int[5];

        int minimum = Arrays.stream(arr).min().getAsInt();

        for (int i = 0; i < possibilities.length; i++) {

            for (int k : arr) {
                int diff = k - minimum;
                int stepsRequired = (diff / 5) + ((diff % 5) / 2) + (((diff % 5) % 2));
                possibilities[i] += stepsRequired;
            }
            minimum--;
        }

        return Arrays.stream(possibilities).min().getAsInt();
    }
}
