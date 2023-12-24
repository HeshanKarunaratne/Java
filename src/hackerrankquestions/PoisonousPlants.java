package hackerrankquestions;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class PoisonousPlants {

    public static int poisonousPlants(List<Integer> list) {

        int[] p = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int n = p.length;
        int[] daysToDie = new int[n];
        Stack<Integer> stack = new Stack<>();
        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            int days = 0;

            while (!stack.isEmpty() && p[i] <= p[stack.peek()]) {
                days = Math.max(daysToDie[stack.pop()], days);
            }

            if (stack.isEmpty()) {
                daysToDie[i] = 0;
            } else {
                daysToDie[i] = days + 1;
            }

            stack.push(i);
            maxDays = Math.max(maxDays, daysToDie[i]);
        }

        return maxDays;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
//        list.add(6);
//        list.add(5);
//        list.add(8);
//        list.add(4);
//        list.add(7);
//        list.add(10);
//        list.add(9);

        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        System.out.println(poisonousPlants(list));
    }


}
