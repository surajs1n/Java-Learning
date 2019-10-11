package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsExample {

    public static void main(String [] args) {
        List<Integer> integers = new ArrayList<Integer>();

        Collections.addAll(integers, 2, 3, 4, 5, 7);
        printCollection(integers);

        Collections.shuffle(integers);
        printCollection(integers);

        Collections.shuffle(integers);
        printCollection(integers);

        Collections.shuffle(integers);
        printCollection(integers);

        Collections.sort(integers);
        printCollection(integers);

        System.out.println(Collections.binarySearch(integers, 3));

        Collections.reverse(integers);
        printCollection(integers);

        //System.out.println(Collections.binarySearch(integers, 3));

        List<Integer> unmodifiableIntegerList = Collections.unmodifiableList(integers);

        try {
            unmodifiableIntegerList.add(34);
        } catch (UnsupportedOperationException e) {
            System.err.println("Can't add integer to unmodifiableIntegerList");
        }

    }

    private static void printCollection(final Collection collection) {
        final Iterator iterator = collection.iterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " , ");
        } System.out.print("\n");

        for(int i=0; i<=80; i++) {
            System.out.print("*");
        } System.out.print("\n");
    }
}
