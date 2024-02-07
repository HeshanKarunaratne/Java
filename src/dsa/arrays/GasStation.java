package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class GasStation {

    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int output = canCompleteCircuit(gas, cost);
        System.out.println(output);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int position = 0;
        int sum = 0;
        int total = 0;

        for (int index = 0; index < gas.length; index++) {
            sum += gas[index] - cost[index];
            if (sum < 0) {
                total += sum;
                sum = 0;
                position = index + 1;
            }
        }
        total += sum;
        return (total >= 0) ? position : -1;
    }
}
