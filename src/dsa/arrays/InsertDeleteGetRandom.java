package dsa.arrays;

import java.util.*;

/**
 * @author Heshan Karunaratne
 */
public class InsertDeleteGetRandom {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    public InsertDeleteGetRandom() {
        map = new HashMap();
        list = new ArrayList<>();
    }

    private boolean search(int val) {
        return map.containsKey(val);
    }

    public boolean insert(int val) {
        if (search(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!search(val)) return false;

        int index = map.get(val);
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom i = new InsertDeleteGetRandom();
        i.insert(5);
        i.insert(1);
        i.insert(6);
        i.insert(4);

        i.remove(1);
    }
}