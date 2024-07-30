package dsa.arrays;

import java.util.*;

/*
380. Insert Delete GetRandom O(1)

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

 */

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

        int position = map.get(val);
        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);

        if (position != lastIndex) {
            list.set(position, lastValue);
            map.put(lastValue, position);
        }

        list.remove(lastIndex);
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

/*
If we use an ArrayList we get below functionalities
Insert: O(1)
GetRandom: O(1)
DeleteFromEnd: O(1)
DeleteFromBeginning: O(N)

If we use a HashMap we get below functionalities
Insert: O(1)
Delete: O(1)
GetRandom: O(N)

We need to use the feature of DeleteFromEnd of ArrayList to achieve the O(1) time complexity. Therefor we need to switch the item that is going to be deleted, to the last index of the ArrayList. So we need a HashMap as well to keep track of the value and the index.

getRandom(N) where (N=size of the list) gives you a random number between 0 and N-1 value
 */