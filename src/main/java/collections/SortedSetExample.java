package collections;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Implementation of a concrete set class, it stores unique details in sorted manner. {@link SortedSet}
 * SortedSet has one and only concrete implementation : TreeSet which in turns uses TreeSet.
 *
 * @author - surajs1n
 * @date - 2019-10-20
 */
public class SortedSetExample {
    public static void main(String [] args) {
        // Create a TreeSet and initialize it with some values.
        SortedSet<String> uniquePlaces = new TreeSet<>();
        uniquePlaces.add("blr"); uniquePlaces.add("del"); uniquePlaces.add("bom");
        uniquePlaces.addAll(Arrays.asList("lko", "cam", "sam"));
        printCollection(uniquePlaces);

        // Add some redundant values and watch the behaviour.
        uniquePlaces.addAll(Arrays.asList("blr", "del", "bom"));
        printCollection(uniquePlaces);

        // Put a customised comparator and observer the behaviour.
        Comparator comparator = uniquePlaces.comparator();
        printObject(comparator);

        // Print the first element in the SortedSet : TreeSet.
        printObject(uniquePlaces.first());

        // Print the last element in the SortedSet : TreeSet.
        printObject(uniquePlaces.last());

        /*
         * These headSet() and tailSet() actually do binary search and find the best suitable results
         * no matter the passed-in object in present or not.
         */
        // Print all the elements for the SortedSet : TreeSet prior to the given element.
        printCollection(uniquePlaces.headSet("cam"));

        // Print all the elements for the SortedSet : TreeSet after and including the given element.
        printCollection(uniquePlaces.tailSet("cam"));

        // Print all the elements for the SortedSet : TreeSet after the given invalid element in the Set.
        printCollection(uniquePlaces.tailSet("cdm"));

        // Print all the elements for given range of sorted elements. [a, b] where "a" comes prior to "b".
        printCollection(uniquePlaces.subSet("bom", "lko"));

        // God know what it does, let's find out.
        printObject(uniquePlaces.spliterator());


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
        if (object != null)
            System.out.println(ReflectionToStringBuilder.toString(object));
        else
            System.err.println("Object is null");
    }
}
