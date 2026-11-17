package es.uniovi.ds.lab.main.basic;

import static es.uniovi.ds.lab.main.TestsHelper.*;
import static es.uniovi.ds.lab.operations.Disk.*;
import static es.uniovi.ds.lab.operations.Printer.*;

import java.io.IOException;

import es.uniovi.ds.lab.structures.*;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        var vector = vectorOf("Victor", "Valentin", "Vidal");
        var linkedList = linkedListOf("Lucas", "Leandro", "Lorenzo");

        /*
          Now I want to have a copy of "vector" in another vector "vector2" to be able to modify it
        */
        MyVector vector2 = new MyVector(vector.iterator());
        sendToPrinter(vector2.iterator());

        /*
          Now I want to pass the elements from "vector2" to a doubly linked list "doubleList2"
        */
        MyDoubleLinkedList doubleList2 = new MyDoubleLinkedList(vector2.iterator());
        sendToPrinter(doubleList2.iterator());

        /*
          I want to copy the elements from "doubleList2" to a vector "vector3"
        */
        MyVector vector3 = new MyVector(doubleList2.iterator());
        sendToPrinter(vector3.iterator());

        /*
          Now I want to have a copy of "linkedList" in another "linkedList2" to be able to modify it
        */
        MyLinkedList linkedList2 = new MyLinkedList(linkedList.iterator());
        sendToPrinter(linkedList2.iterator());

        /*
          Finally, I want to load the lines from the file "file.txt" into a doubly linked list "doubleList3"
        */
        MyDoubleLinkedList doubleList3 = new MyDoubleLinkedList(fileIterator("file.txt"));
        sendToPrinter(doubleList3.iterator());

        // ------------------------------------------------
        // Java built-in collections also have constructors that accept other collections:
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html#%3Cinit%3E(java.util.Collection)
    }
}
