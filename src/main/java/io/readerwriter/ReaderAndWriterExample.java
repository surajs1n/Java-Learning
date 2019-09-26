package io.readerwriter;

import metrics.Timer;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderAndWriterExample {

    private static final int EOF = -1;
    private static final int ONE_MILLION = 1000000;
    private static final String OUTPUT_STRING = RandomStringUtils.randomAlphanumeric(10000);
    private static final String FILE_PATH = "./src/main/resources/text-files/ReaderAndWriter-Example.txt";

    public static void main(String []args) {
        // Write into file.
        Timer fileWriterTimer = Timer.builder().statTime(System.nanoTime()).build();
        try (Writer fileWriter = new FileWriter(FILE_PATH)) {
            for(char ch: OUTPUT_STRING.toCharArray()) {
                fileWriter.write(ch);
            }
        } catch (IOException e) {
            System.err.println("Error open file : " + FILE_PATH);
        }
        fileWriterTimer.setEndTime(System.nanoTime());

        // Read form file.
        Timer fileReaderTimer = Timer.builder().statTime(System.nanoTime()).build();
        try (Reader fileReader = new FileReader(FILE_PATH)) {
            String outputString = "";
            int ch = fileReader.read();
            while(ch != EOF) {
                outputString = outputString + (char) ch;
                ch = fileReader.read();
            }

            System.out.println(outputString);
        } catch (IOException e) {
            System.err.println("Error open file : " + FILE_PATH);
        }
        fileReaderTimer.setEndTime(System.nanoTime());

        // Write into file using Buffer.
        Timer fileBufferedWriterTimer = Timer.builder().statTime(System.nanoTime()).build();
        try (Writer fileBufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for(char ch: OUTPUT_STRING.toCharArray()) {
                fileBufferedWriter.write(ch);
            }
        } catch (IOException e) {
            System.err.println("Error open file : " + FILE_PATH);
        }
        fileBufferedWriterTimer.setEndTime(System.nanoTime());

        // Read from file using Buffer.
        Timer fileBufferedReaderTimer = Timer.builder().statTime(System.nanoTime()).build();
        try (Reader fileBufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String outputString = "";
            int ch = fileBufferedReader.read();
            while(ch != EOF) {
                outputString = outputString + (char) ch;
                ch = fileBufferedReader.read();
            }

            System.out.println(outputString);
        } catch (IOException e) {
            System.err.println("Erro open file : " + FILE_PATH);
        }
        fileBufferedReaderTimer.setEndTime(System.nanoTime());

        System.out.println("FileWriter took " + (fileWriterTimer.getEndTime() - fileWriterTimer.getStatTime())/ONE_MILLION + " time to execute.");
        System.out.println("Buffered-FileWriter took " + (fileBufferedWriterTimer.getEndTime() - fileBufferedWriterTimer.getStatTime())/ONE_MILLION + " time to execute.");
        System.out.println("FileReader took " + (fileReaderTimer.getEndTime() - fileReaderTimer.getStatTime())/ONE_MILLION + " time to execute.");
        System.out.println("Buffered-FileReader took " + (fileBufferedReaderTimer.getEndTime() - fileBufferedReaderTimer.getStatTime())/ONE_MILLION + " time to execute.");
    }
}
