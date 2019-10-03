package io.readerwriter;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayReaderAndWriterExample {

    public static void main(String []args) throws IOException {
        try (CharArrayWriter charArrayWriter = new CharArrayWriter()) {
            charArrayWriter.write("This is going to be written!!!");
            char [] chars = charArrayWriter.toCharArray();

            System.out.println("Char Array : " + ReflectionToStringBuilder.toString(chars));

            try (CharArrayReader charArrayReader = new CharArrayReader(chars)) {
                int ch = charArrayReader.read();
                String str = "";
                while(ch != -1) {
                    str = str + (char) ch;
                    ch = charArrayReader.read();
                }

                System.out.println("Char Array : " + str);
            }
        }
    }
}
