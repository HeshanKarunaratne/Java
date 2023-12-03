package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class BaseBallGame {

    public static void main(String[] args) {

        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        int result = 0;

        int arr[] = new int[ops.length];
        int index = 0;
        for (int i = 0; i < ops.length; i++) {

            if ("+".equals(ops[i])) {
                arr[index] = arr[index - 1] + arr[index - 2];
                index++;
            } else if ("D".equals(ops[i])) {
                arr[index] = arr[index - 1] * 2;
                index++;
            } else if ("C".equals(ops[i])) {
                arr[index - 1] = 0;
                index--;
            } else {
                arr[index] = Integer.parseInt(ops[i]);
                index++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return result;
            }
            result = result + arr[i];
        }
        return result;
    }
}
