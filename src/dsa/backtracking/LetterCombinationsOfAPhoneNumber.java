package dsa.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> outputArr = new LinkedList<>();
        if (digits == null || digits.equals("")) return outputArr;
        outputArr.add("");

        String[] charMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (outputArr.peek().length() == i) {
                String permutation = outputArr.remove();
                for (char c : charMap[index].toCharArray()) {
                    outputArr.add(permutation + c);
                }
            }
        }
        return outputArr;
    }

    public static void main(String[] args) {

        List<String> output = letterCombinations("23");
        System.out.println(output);
    }
}
