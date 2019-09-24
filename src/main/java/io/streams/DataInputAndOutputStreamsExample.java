package io.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputAndOutputStreamsExample {
    private static final String FILE_PATH = "./src/main/resources/text-files/DataInputAndOutputStreamsExample-Example.txt";

    /**
     * Input given to DataOutputStream.
     * 1
     * a
     * 2.3
     * 23.33
     * suraj
     *
     * Expected input into DataInputStream.
     * @param args
     */
    public static void main(String [] args) throws IOException {

        // Write into File.
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_PATH)))) {
            dataOutputStream.writeInt(1);
            dataOutputStream.writeChar('a');
            dataOutputStream.writeFloat(2.3f);
            dataOutputStream.writeDouble(23.33);
            dataOutputStream.writeUTF("Suraj");
            dataOutputStream.flush();
        } catch (IOException e) {
            System.err.println("Error writing into " + FILE_PATH + " file.\n" + e);
        }

        // Read from File.
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)))) {
            System.out.println(dataInputStream.readInt()); System.out.flush();
            System.out.println(dataInputStream.readChar()); System.out.flush();
            System.out.println(dataInputStream.readFloat()); System.out.flush();
            System.out.println(dataInputStream.readDouble()); System.out.flush();
            System.out.println(dataInputStream.readUTF());
        } catch (IOException e) {
            System.err.println("Error reading from " + FILE_PATH + " file.\n" + e);
        }
    }
}
