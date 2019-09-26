package io.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputAndOutputStreamsExample {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Student implements Serializable {
        private static final long serialVersionUID = 111;
        private String name;
        private String clazz;
        private int age;
        private String phoneNumber;
    }

    private static final String FILE_PATH = "./src/main/resources/text-files/ObjectInputAndOutputStreams-Example.txt";

    public static void main(String [] args) {
        Student studentOne = new Student("Suraj", "Xth", 23, "444444");
        Student studentTwo = new Student("Akash", "Xth", 20, "222222");
        Student studentThree = new Student("Sreshta", "XIth", 18, "22222");

        // Writing Objects into the file.
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(studentOne);
            outputStream.writeObject(studentTwo);
            outputStream.writeObject(studentThree);

            System.out.println(ReflectionToStringBuilder.toString(studentOne));
            System.out.println(ReflectionToStringBuilder.toString(studentTwo));
            System.out.println(ReflectionToStringBuilder.toString(studentThree));
        } catch (IOException e) {
            System.out.println("Error trying writing object into file : " + FILE_PATH);
        }

        // Reading objects from the file.
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Student rollNoOneStudent   = (Student) inputStream.readObject();
            Student rollNoTwoStudent   = (Student) inputStream.readObject();
            Student rollNoThreeStudent = (Student) inputStream.readObject();

            System.out.println(ReflectionToStringBuilder.toString(rollNoOneStudent));
            System.out.println(ReflectionToStringBuilder.toString(rollNoTwoStudent));
            System.out.println(ReflectionToStringBuilder.toString(rollNoThreeStudent));
        } catch (IOException e) {
            System.err.println("Error reading object from file : " + FILE_PATH);
        } catch (ClassNotFoundException e) {
            System.err.println("Call not found. ");
        }

        // Reading chars from the file.
        try (InputStream inputStream = new FileInputStream(FILE_PATH)) {
//            TODO : https://github.com/surajs1n/Java-Learning/issues/2
//            TODO : This is running into infinite-loop. Need to deep dive why?
//            char ch = (char) inputStream.read();
//            while(ch != -1) {
//                System.out.println(ch);
//                ch = (char) inputStream.read();
//            }

              byte [] array = new byte[100];
              inputStream.read(array);
              System.out.println(array.toString());
              for(int i=0; i<array.length; i++) {
                  System.out.print(array[i] + " ");
              }System.out.println("\n");

        } catch (IOException e) {
            System.err.println("Error reading object from file : " + FILE_PATH);
        }
    }
}
