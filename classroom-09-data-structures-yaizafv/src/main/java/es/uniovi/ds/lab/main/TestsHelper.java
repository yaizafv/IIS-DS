package es.uniovi.ds.lab.main;

import es.uniovi.ds.lab.structures.*;

/**
 * Don't modify this class. It is only used for testing purposes.
 */
public class TestsHelper {

    public static MyVector vectorOf(String... elements) {
        MyVector vector = new MyVector();
        for (String element : elements)
            vector.add(element);
        return vector;
    }

    public static MyLinkedList linkedListOf(String... elements) {
        MyLinkedList list = new MyLinkedList();
        // Add elements in reverse order to maintain the input order
        for (int i = elements.length - 1; i >= 0; i--)
            list.add(elements[i]);
        return list;
    }

    public static MyDoubleLinkedList doubleLinkedListOf(String... elements) {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        // Add elements in reverse order to maintain the input order
        for (int i = elements.length - 1; i >= 0; i--)
            list.add(elements[i]);
        return list;
    }
}
