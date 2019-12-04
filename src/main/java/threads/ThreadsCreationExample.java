package threads;

import java.util.concurrent.TimeUnit;

/**
 * @author - suraj.s
 * @date - 2019-12-04
 */
public class ThreadsCreationExample {

    private static class MyFirstThreadClass extends Thread {
        @Override
        public void run() {
            try {
                // Remove below and its try-catch block to flip the output.
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("First thread's output");
        }
    }

    private static class MySecondThreadClass implements Runnable {
        @Override
        public void run() {
            System.out.println("Second thread's output");
        }
    }
    public static void main(String [] args) {
        Thread threadOne = new MyFirstThreadClass();
        Thread threadTwo = new Thread(new MySecondThreadClass());

        threadOne.start();
        threadTwo.start();
    }
}
