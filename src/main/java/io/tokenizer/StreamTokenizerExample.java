package io.tokenizer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class StreamTokenizerExample {

    private static final String STRING = "These are some random text. 4535 \n!!! \"\"\n";

    public static void main(String []args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(STRING));
        try {
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if(tokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(tokenizer.sval + " => a string.");
                } else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(tokenizer.nval + " => a number.");
                } else if (tokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("It was a next-line tokenizer.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error open string tokenizer.");
        }
    }
}
