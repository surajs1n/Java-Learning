package threads;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author - suraj.s
 * @date - 2019-12-05
 */
public class ComplexThreadNameDetectionExample {

    private static class MyFirstThreadClass extends Thread {
        @Override
        public void run() {
            Thread executingThread = Thread.currentThread();
            System.out.println(ReflectionToStringBuilder.toString(executingThread));
        }
    }

    private static class MySecondThreadClass implements Runnable {
        @Override
        public void run() {
            Thread executingThread = Thread.currentThread();
            System.out.println(ReflectionToStringBuilder.toString(executingThread));
        }
    }

    public static void main(String[] args) {
        Thread firstThread = new MyFirstThreadClass();
        Thread secondThread = new Thread(new MySecondThreadClass());

        System.out.println("First Thread's Name : " + firstThread.getName());
        firstThread.start();
        System.out.println("\nSecond Thread's Name : " + secondThread.getName());
        secondThread.start();
    }
}
