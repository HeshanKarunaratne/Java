package dsa.arrays;

/*
6. Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"
 */

/**
 * @author Heshan Karunaratne
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(convert(s, rows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] sbs = new StringBuilder[numRows];
        int row = 0, dir = 0;

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            row += dir;
            sbs[row].append(c);

            if (row == 0 || row == numRows - 1) {
                dir = (dir == 0) ? 1 : -dir;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
            result.append(sbs[i].toString());
        }

        return result.toString();
    }
}

/*

     P  A  Y  P  A  L  I  S  H  I  R  I  N  G
row: 0  1  2  1  0  1  2  1  0  1  2  1  0  1
dir: 1  1 -1 -1  1  1 -1 -1  1  1 -1 -1  1  1

sb0: P   A   H   N
sb1: A P L S I I G
sb2: Y   I   R
 */