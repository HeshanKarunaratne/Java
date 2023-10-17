package theory;

/**
 * @author Heshan Karunaratne
 */
public class MyRunnable {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread increaseThread = new Thread(new IncreaseTask());
        Thread decreaseThread = new Thread(new DecreaseTask());

        increaseThread.start();
        decreaseThread.start();

        try {
            increaseThread.join();
            decreaseThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter);
    }

    static class IncreaseTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                synchronized (MyRunnable.class) {
                    counter++;
                }
            }
        }
    }

    static class DecreaseTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                synchronized (MyRunnable.class) {
                    counter--;
                }
            }
        }
    }
}
