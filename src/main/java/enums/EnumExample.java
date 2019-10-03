package enums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnumExample {
    private enum Level {
        HIGH,
        MEDIUM,
        LOW,
        VERY_LOW
    }

    public static void main(String []args) {

        // Print normally;
        System.out.println(Level.HIGH);
        System.out.println(Level.MEDIUM);
        System.out.println(Level.LOW);
        System.out.println(Level.VERY_LOW);

        // Print using toString();
        System.out.println(Level.HIGH.toString());
        System.out.println(Level.MEDIUM.toString());
        System.out.println(Level.LOW.toString());
        System.out.println(Level.VERY_LOW.toString());

        for(Level level: Level.values()) {
            System.out.println(level);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            if (Level.HIGH.equals(input)) {
                System.out.println("Input is HIGH.");
            } else if (Level.MEDIUM.equals(input)) {
                System.out.println("Input is MEDIUM.");
            } else if (Level.LOW.equals(input)) {
                System.out.println("Input is LOW.");
            } else if (Level.VERY_LOW.equals(input)) {
                System.out.println("Input is VERY LOW.");
            } else {
                System.out.println("Input is something else.");
            }

            // This seems like the best way to compare the string converted ENUM with input string.
            input = reader.readLine();
            if (Level.HIGH.toString().equals(input)) {
                System.out.println("Input is HIGH.");
            } else if (Level.MEDIUM.toString().equals(input)) {
                System.out.println("Input is MEDIUM.");
            } else if (Level.LOW.toString().equals(input)) {
                System.out.println("Input is LOW.");
            } else if (Level.VERY_LOW.toString().equals(input)) {
                System.out.println("Input is VERY LOW.");
            } else {
                System.out.println("Input is something else.");
            }

            input = reader.readLine();
            switch (Level.valueOf(input)) {
                case HIGH:     System.out.println("Input is HIGH.");          break;
                case MEDIUM:   System.out.println("Input is MEDIUM.");        break;
                case LOW:      System.out.println("Input is LOW.");           break;
                case VERY_LOW: System.out.println("Input is VERY LOW.");      break;
                default:       System.out.println("Input is something else"); break;
            }
        } catch (IOException e) {
            System.err.println("Input Exception.");
        }
    }
}
