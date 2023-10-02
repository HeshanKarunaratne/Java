package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class DynamicArray {

    public static void main(String[] args) {
        int n = 2;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 0, 5));
        queries.add(List.of(1, 1, 7));
        queries.add(List.of(1, 0, 3));
        queries.add(List.of(2, 1, 0));
        queries.add(List.of(2, 1, 1));
        System.out.println(dynamicArray(n, queries));
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int lastAnswer = 0;

        for (int i = 0; i < n; i++) {
            sequences.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            int qType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            if (qType == 1) {
                int seqIndex = (x ^ lastAnswer) % n;
                sequences.get(seqIndex).add(y);
            } else if (qType == 2) {
                int seqIndex = (x ^ lastAnswer) % n;
                lastAnswer = sequences.get(seqIndex).get(y % sequences.get(seqIndex).size());
                result.add(lastAnswer);
            }
        }
        return result;
    }
}
