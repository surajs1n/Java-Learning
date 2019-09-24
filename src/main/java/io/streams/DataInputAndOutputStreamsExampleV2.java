package io.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputAndOutputStreamsExampleV2 {
    private static final String FILE_PATH = "./src/main/resources/text-files/DataInputAndOutputStreamsExampleV2-Example.txt";

    /**
     * Input given to DataOutputStream.
     * 10
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 9
     * 10
     *
     * Expected input into DataInputStream.
     * @param args
     */
    public static void main(String [] args) throws IOException {
        final int LENGTH = 10;

        // Write into File.
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_PATH)))) {
            dataOutputStream.writeInt(LENGTH);
            for(int i=1; i<=10; i++) {
                dataOutputStream.writeInt(i);
            }
            dataOutputStream.flush();
        } catch (IOException e) {
            System.err.println("Error writing into " + FILE_PATH + " file.\n" + e);
        }

        // Read from File.
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)))) {
            int length = dataInputStream.readInt();
            while(length-- > 0) {
                System.out.println(dataInputStream.readInt());
            }
        } catch (IOException e) {
            System.err.println("Error reading from " + FILE_PATH + " file.\n" + e);
        }
    }
}
