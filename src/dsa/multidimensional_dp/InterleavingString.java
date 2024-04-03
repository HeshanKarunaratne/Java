package dsa.multidimensional_dp;

/**
 * @author Heshan Karunaratne
 */
public class InterleavingString {
    static Boolean[][] cache;
    static char[] s1Arr, s2Arr, s3Arr;
    static char UNKNOWN = '0';

    public static boolean isInterleave(String s1, String s2, String s3) {
        s1Arr = s1.toCharArray();
        s2Arr = s2.toCharArray();
        s3Arr = s3.toCharArray();
        if (s1Arr.length + s2Arr.length != s3Arr.length) return false;
        cache = new Boolean[s1Arr.length + 1][s2Arr.length + 1];
        return dfs(0, 0);
    }

    private static boolean dfs(int ps1, int ps2) {
        if (ps1 == s1Arr.length && ps2 == s2Arr.length) return true;

        if (cache[ps1][ps2] != null) return cache[ps1][ps2];
        int ps3 = ps1 + ps2;
        char s1Char = ps1 == s1Arr.length ? UNKNOWN : s1Arr[ps1];
        char s2Char = ps2 == s2Arr.length ? UNKNOWN : s2Arr[ps2];
        char s3Char = s3Arr[ps3];

        if (s1Char == s3Char && s2Char == s3Char) {
            cache[ps1][ps2] = dfs(ps1, ps2 + 1) || dfs(ps1 + 1, ps2);
        } else if (s1Char == s3Char) {
            cache[ps1][ps2] = dfs(ps1 + 1, ps2);
        } else if (s2Char == s3Char) {
            cache[ps1][ps2] = dfs(ps1, ps2 + 1);
        } else {
            cache[ps1][ps2] = false;
        }
        return cache[ps1][ps2];
    }

    public static void main(String[] args) {
        boolean interleave = isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
    }
}
