package collections;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Example of Set interface. Following are the concrete implementation of Set.
 * 1. EnumSet
 * 2. HashSet
 * 3. LinkedHashSet
 * 4. TreeSet
 *
 * @author - surajs1n
 * @date - 2019-10-18
 */
public class SetExample {
    public static void main(String [] args) {
        // Initialize a set.
        Set<String> uniqueName = new HashSet<>();
        uniqueName.add("hello");  uniqueName.add("hello");  uniqueName.add("hello");  uniqueName.add("hello");
        uniqueName.add("hey");    uniqueName.add("hey");    uniqueName.add("hey");
        uniqueName.add("how");    uniqueName.add("how");
        uniqueName.add(null);     uniqueName.add(null);
        printCollection(uniqueName);

        uniqueName.remove(null);
        printCollection(uniqueName);
        uniqueName.remove("how hello");
        printCollection(uniqueName);
        uniqueName.remove("hey");
        printCollection(uniqueName);
    }


    private static void printArrayOfObject(Object[] objects) {
        System.out.print("Size of array is " + objects.length + " => ");
        for(int i=0; i<objects.length; i++) {
            System.out.print(objects[i] + " ");
        } System.out.print("\n");
    }

    private static void printCollection(Collection collections) {
        Iterator iterator = collections.iterator();
        if (0 == collections.size()) {
            System.out.println("Collection is empty.");
            return;
        }

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.print("\n");
    }

    private static void printObject(final Object object) {
        System.out.println(ReflectionToStringBuilder.toString(object));
    }

}
