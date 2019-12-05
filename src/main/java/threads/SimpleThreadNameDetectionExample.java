package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author - suraj.s
 * @date - 2019-12-05
 */
public class SimpleThreadNameDetectionExample {

    public static void main(String[] args) throws IOException {
        Thread runningThread = Thread.currentThread();
        System.out.println("Running thread name: " + runningThread.getName());
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int a = scanner.nextInt();
        System.out.println("Value of a : "+ a);
        int b = scanner.nextByte();
        System.out.println("Value of b : "+ b);
        scanner.close();

        System.out.println("sum of a+b : "+ sum(a, b));

        runningThread = Thread.currentThread();
        System.out.println("Running thread name: " + runningThread.getName());
    }

    private static int sum(final int a, final int b) {
        return a+b;
    }
}
