package hackerrankquestions;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class MinimumLoss {

    public static int minimumLoss(List<Long> price) {
        long minimumLoss = Long.MAX_VALUE;
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < price.size(); i++) {
            map.put(price.get(i).longValue(), i);
        }

        Collections.sort(price);

        for (int i = price.size() - 1; i > 0; i--) {

            if (map.get(price.get(i)) > map.get(price.get(i - 1))) continue;

            long dayLoss = price.get(i) - price.get(i - 1);
            minimumLoss = Math.min(minimumLoss, dayLoss);
        }

        return (int) minimumLoss;
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(Long.valueOf("20"));
        list.add(Long.valueOf("7"));
        list.add(Long.valueOf("8"));
        list.add(Long.valueOf("2"));
        list.add(Long.valueOf("5"));

        System.out.println(minimumLoss(list));
    }
}
