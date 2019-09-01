package io.randomaccess;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {

    private static final String OUTPUT_FILE_TEXT = "Hello there, it is some text written.\n" +
                                                   "This is done for some experiment purposes.\n" +
                                                   "Happy Java Learning.\n\n";
    private static final String MODIFIED_FILE_TEXT = "Added lines!!!";
    private static final String LONG_MODIFIED_FILE_TEXT = "This is a long line written trying to cover lots of thing in one short.";
    private static final String OUTPUT_FILE_LOCATION = "./src/main/resources/text-files/RandomAccessFile-Example.txt";

    /**
     * Function to test the RandomAccessFile class functions.
     * 1. First generate a file with some words.
     * 2. Do some random write() operations on it.
     * 3. Do some random read()  operations on it.
     *
     * @param args input from cli.
     */
    public static void main(String [] args) throws IOException {

        OutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_LOCATION));
        fileOutputStream.write(OUTPUT_FILE_TEXT.getBytes());
        fileOutputStream.close();

        RandomAccessFile fileAccessor = new RandomAccessFile(OUTPUT_FILE_LOCATION, "rw");

        fileAccessor.seek(10);
        printFromHere(fileAccessor);

        fileAccessor.seek(30);
        printFromHere(fileAccessor);

        fileAccessor.seek(1);
        printFromHere(fileAccessor);

        fileAccessor.seek(0);
        printFromHere(fileAccessor);

        fileAccessor.seek(0);
        fileAccessor.write(MODIFIED_FILE_TEXT.getBytes());  // It overwrites on the previous characters.
        fileAccessor.seek(0);
        printFromHere(fileAccessor);

        fileAccessor.seek(14);
        fileAccessor.write(LONG_MODIFIED_FILE_TEXT.getBytes());  // It overwrites on the previous characters starting from the last pointer.
        fileAccessor.seek(0);
        printFromHere(fileAccessor);
    }

    private static void printFromHere(final RandomAccessFile fileAccessor) throws IOException {
        int character = fileAccessor.read();
        while(character != -1) {
            System.out.print((char) character);
            character = fileAccessor.read();
        }
    }
}
