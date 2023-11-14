package hackerrankquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class TuringQ1 {

    public static void main(String[] args) {
//        int[] a = {40, 10, 20, 30};
//        int[] a = {100, 100, 100};
        int[] a = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        final int[] solution = solution(a);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] a) {
        final int[] temp = Arrays.copyOf(a, a.length);
        int[] result = new int[a.length];

        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int position = 1;
        for (int i : temp) {
            if (!map.containsKey(i)) {
                map.put(i, position);
                position++;
            }
        }

        for (int i = 0; i < a.length; i++) {

            int pos = map.get(a[i]);
            result[i] = pos;
        }
        return result;
    }
}
