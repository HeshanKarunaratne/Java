package dsa.hashmap;

/**
 * @author Heshan Karunaratne
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {

        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
        }

        for (int item : arr) {
            if (item != 0) return false;
        }
        return true;
    }

}
