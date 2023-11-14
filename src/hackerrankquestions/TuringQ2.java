package hackerrankquestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class TuringQ2 {

    public static void main(String[] args) {
//        final int val = solution("DDC");
        final int val = solution("DDLC");
        System.out.println(val);
    }

    public static int solution(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                sum = sum + map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                sum = sum + map.get(s.charAt(i));
            }
        }

        return sum;
    }


}
