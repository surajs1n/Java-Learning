package collections;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IteratorExample {
    public static void main(String [] args ) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("123");
        stringList.add("456");
        stringList.add("789");

        Set<String> stringSet = new HashSet<>();
        stringSet.add("789");
        stringSet.add("654");
        stringSet.add("321");

        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }

        iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(ReflectionToStringBuilder.toString(object));
        }

        iterator = stringList.iterator();
        while(iterator.hasNext()) {
            Object object = iterator.next();
            if (object.equals("456")) {
                System.out.println("It is 456");
            } else if (object.equals("789")) {
                try {
                    //stringList.add("1234"); // Uncomment to see different behavior.
                } catch (ConcurrentModificationException e) {
                    System.out.println("Not allowed.");
                }
            } else if (object.equals("123")) {
                iterator.remove();
            }
        }

        System.out.println("String Size :: " + stringList.size());
        iterator = stringList.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }

    }
}
