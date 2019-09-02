package io.outputstreams;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamExample {

    private static final int THOUSAND = 1000;
    private static final int MILLION  = 1000000;
    private static final String OUTPUT_FILE_PATH = "./src/main/resources/text-files/FileOutputStream-Example.txt";

    public static void main(String [] args) throws IOException {
        // Creating a new file.
        long startTime, endTime;

        startTime = System.nanoTime();
        String outputString = RandomStringUtils.randomAlphanumeric(10000);
        endTime = System.nanoTime();
        printMessage("RandomStringUtils ::", startTime, endTime);

        startTime = System.nanoTime();
        OutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE_PATH);
        for (int i=0; i<outputString.length(); i++) {
            fileOutputStream.write(outputString.charAt(i));
        }
        fileOutputStream.flush(); fileOutputStream.close();
        endTime = System.nanoTime();
        printMessage("FileOutputStream ::", startTime, endTime);

        // Appending to the same file using Buffered memory.
        startTime = System.nanoTime();
        outputString = RandomStringUtils.randomAlphabetic(10000);
        endTime = System.nanoTime();
        printMessage("RandomStringUtils ::", startTime, endTime);

        startTime = System.nanoTime();
        OutputStream fileBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH, true));
        for (int i=0; i<outputString.length(); i++) {
            fileBufferedOutputStream.write(outputString.charAt(i));
        }
        fileBufferedOutputStream.flush(); fileBufferedOutputStream.close();
        endTime = System.nanoTime();
        printMessage("BufferedOutputStream ::", startTime, endTime);
    }

    private static void printMessage(String message, long startTime, long endTime) {
        System.out.print("\n" + message + " Time Elapsed = " + (endTime - startTime)/MILLION + "ms \n");
    }
}
