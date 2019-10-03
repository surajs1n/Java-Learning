package io.readerwriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderAndWriterExample {
    private static final String STRING = "These are some random text. 4535 \n!!! \"\"\n";

    public static void main(String [] args) throws IOException {
        StringReader reader = new StringReader(STRING);

        int ch = reader.read();
        while(ch != -1) {
            System.out.print((char) ch);
            ch = reader.read();
        }
        reader.close();

        StringWriter writer = new StringWriter();
        writer.write(STRING);
        System.out.print(writer.toString());
        writer.close();
    }
}
