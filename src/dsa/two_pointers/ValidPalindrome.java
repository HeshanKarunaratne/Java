package dsa.two_pointers;

/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

/**
 * @author Heshan Karunaratne
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindromeV2(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.isBlank()) return true;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String filteredString = sb.toString();
        String reversedString = sb.reverse().toString();
        return filteredString.equals(reversedString);
    }

    public static boolean isPalindromeV2(String s) {
        if (s.isBlank()) return true;

        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char cStart = s.charAt(start);
            char cEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(cStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(cEnd)) {
                end--;
            } else {
                if (cStart != cEnd) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}

/*
If the string is empty then return true
Use the Characters static function isLetterOrDigit to identify whether the given char is actually a letter or a number

Move the pointers from left if it is not a valid character
Move the pointers from right if it is not a valid character
 */