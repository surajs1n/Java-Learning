package io.inputstreams;

import java.io.*;

public class InputStreamExample {

    private static final int EOF = -1;
    private static final int ONE_MILLION = 1000000;

    public static void main(String [] str) throws IOException {

        long startTimeWithoutBuffer, endTimeWithoutBuffer;

        startTimeWithoutBuffer = System.nanoTime();
        // Reading using FileInputStream.
        InputStream inputStream = new FileInputStream("./src/main/resources/text-files/GPL-3.0-sample.txt");

        int data = inputStream.read();
        while(data != EOF) {
            System.out.print((char)data);
            data = inputStream.read();
        }
        inputStream.close();
        endTimeWithoutBuffer = System.nanoTime();


        System.out.println("\n");
        for(int i=0; i<80; i++)
            System.out.print("=");
        System.out.println("\n");

        long startTimeWithBuffer, endTimeWithBuffer;

        startTimeWithBuffer = System.nanoTime();
        // Reading the same file with BufferedInputStream.
        InputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("./src/main/resources/text-files/GPL-3.0-sample.txt")
        );

        data = bufferedInputStream.read();
        while(data != EOF) {
            System.out.print((char)data);
            data = bufferedInputStream.read();
        }
        bufferedInputStream.close();
        endTimeWithBuffer = System.nanoTime();

        System.out.println("\nWithout Buffer Time => " + (endTimeWithoutBuffer-startTimeWithoutBuffer)/ONE_MILLION
                + " With Buffer Time => " + (endTimeWithBuffer - startTimeWithBuffer)/ONE_MILLION);
    }
}
