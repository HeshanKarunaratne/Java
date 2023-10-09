package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class SparseArray {

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> intList = new ArrayList<>();
        for (String query : queries) {
            long count = stringList.stream().filter(val -> val.equals(query)).count();
            intList.add(Integer.parseInt(String.valueOf(count)));
        }
        return intList;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("aba");
        stringList.add("baba");
        stringList.add("aba");
        stringList.add("xzxb");

        List<String> queryList = new ArrayList<>();
        queryList.add("aba");
        queryList.add("xzxb");
        queryList.add("ab");

        System.out.println(matchingStrings(stringList, queryList));
    }
}
