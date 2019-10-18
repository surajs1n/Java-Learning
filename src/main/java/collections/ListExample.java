package collections;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Example of List interface. Following are the concrete implementation of List.
 * 1. ArrayList
 * 2. LinkedList
 * 3. Vector
 * 4. Stack
 *
 * @author - surajs1n
 * @date - 2019-10-18
 */
public class ListExample {
    public static void main(String []args) {
        // Initialize and add some details.
        List<String> names = new ArrayList<>();
        names.add("suraj"); names.add(0, "akash"); names.add(0, "sarestha"); names.add(null);
        names.add("suraj"); names.add(0, "akash"); names.add(0, "sarestha"); names.add(null);
        printCollection(names);

        // Check the availability and return result.
        boolean result = names.contains(null);
        printObject(result);

        // Remove some inputs.
        names.remove(null);
        printCollection(names);
        names.remove(null);
        names.remove(null);
        printCollection(names);
        names.remove("suraj");
        printCollection(names);

        // Clear entire list.
        names.clear();
        printCollection(names);

        // Re-initialize the list.
        names.add("suraj"); names.add(0, "akash"); names.add(0, "sarestha"); names.add(null);
        names.add("suraj"); names.add(0, "akash"); names.add(0, "sarestha"); names.add(null);
        printCollection(names);

        // Take the sub-set of list.
        List<String> subNames = names.subList(2,5);
        printCollection(subNames);

        // Convert List into Set.
        Set<String> uniqueNames = new HashSet<>(names);
        printCollection(uniqueNames);

        // Convert List into Array of String.
        String [] nameArray = subNames.toArray(new String[0]);
        printArrayOfObject(nameArray);

        // Convert Array of string into List.
        List<String> numbers = Arrays.asList("one", "two", "three", "four", null, "six");
        printCollection(numbers);

        List generalList = new ArrayList();
        generalList.add(1);    generalList.add(3.4f);    generalList.add("eight");
        printListWithMetaData(generalList);
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

    private static void printListWithMetaData(List list) {
        System.out.println(list.getClass() + " ");

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i) + " => " + list.get(i).getClass());
        }
    }
}
