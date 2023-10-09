package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class GameOfTwoStacks {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {

        int result = 0, st1_count = 0, st2_count = 0, total_sum = 0;

        for (Integer st1_element : a) {

            if (total_sum + st1_element > maxSum) break;
            total_sum += st1_element;
            st1_count++;
        }
        result = st1_count;


        for (Integer st2_element : b) {
            total_sum += st2_element;
            st2_count++;

            while (total_sum > maxSum && st1_count > 0) {
                total_sum -= a.get(st1_count - 1);
                st1_count--;
            }
            result = (total_sum <= maxSum) ? Math.max(st1_count + st2_count, result) : result;

        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        list2.add(8);
        list2.add(5);

        System.out.println(twoStacks(10, list1, list2));
    }
}
