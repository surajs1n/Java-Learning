package io.outputstreams;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {

    private static final int THOUSAND = 1000;
    private static final int MILLION  = 1000000;

    public static void main(String []args) throws IOException {
        // Writing to console.
        long starTime, endTime;

        starTime = System.nanoTime();
        String outputString = RandomStringUtils.randomAlphanumeric(10000);
        endTime = System.nanoTime();
        printMessage("RandomStringUtils ::", starTime, endTime);

        starTime = System.nanoTime();
        OutputStream consoleOutputStream = new BufferedOutputStream(System.out);
        for (int i=0; i<outputString.length(); i++) {
            consoleOutputStream.write(outputString.charAt(i));
        }
        consoleOutputStream.flush();
        endTime = System.nanoTime();
        printMessage("Buffered Console Output ::", starTime, endTime);
        consoleOutputStream.close();  // This also closes the connection for normal use of System.out.print().
    }

    private static void printMessage(String message, long startTime, long endTime) {
        System.out.print("\n" + message + " Time Elapsed = " + (endTime - startTime)/MILLION + "ms \n");
    }
}
