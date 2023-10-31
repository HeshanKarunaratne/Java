package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Heshan Karunaratne
 */
public class MissingNumbers {

    public static void main(String[] args) {

        List<Integer> arr = List.of(7, 2, 5, 3, 5, 3);
        List<Integer> brr = List.of(7, 2, 5, 4, 6, 3, 5, 3, 1, 1);
        System.out.println(missingNumbers(arr, brr));
    }

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        List<Integer> crr = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (Integer integer : brr) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.put(integer, map.get(integer) + 1);
            }
        }
        for (Integer integer : arr) {
            int freq = map.get(integer);
            freq--;
            if (freq == 0) {
                map.remove(integer);
            } else {
                map.put(integer, freq);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                crr.add(entry.getKey());
            }
        }
        return crr;
    }
}
