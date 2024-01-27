package dsa.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 59;
        System.out.println(intToRomanV2(num));
    }

    //num = 58
    public static String intToRoman(int num) {

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        StringBuilder val = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            while (num >= entry.getValue()) {
                num = num - entry.getValue();
                val.append(entry.getKey());
            }
        }

        return val.toString();
    }

    public static String intToRomanV2(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder val = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            while (num >= values[i]) {
                num = num - values[i];
                val.append(roman[i]);
            }
        }

        return val.toString();
    }
}
