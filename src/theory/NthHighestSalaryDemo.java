package theory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Heshan Karunaratne
 */
public class NthHighestSalaryDemo {
    //Find the second highest salary
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A1", 1300);
        map.put("A2", 1200);
        map.put("A3", 1500);
        map.put("A4", 1600);
        map.put("A5", 1600);
        map.put("A6", 1300);
        map.put("A7", 1400);

        map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(1);


    }

    public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num - 1);
    }

}
