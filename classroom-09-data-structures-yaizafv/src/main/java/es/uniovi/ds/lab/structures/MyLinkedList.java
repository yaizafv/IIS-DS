package es.uniovi.ds.lab.structures;

class SingleLinkNode {
    String text;
    SingleLinkNode next;

    public SingleLinkNode(String text, SingleLinkNode next) {
        this.text = text;
        this.next = next;
    }
}

public class MyLinkedList {

    private SingleLinkNode head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public MyLinkedList(MyIterator iterator) {
        this();
        String element;
        while ((element = iterator.next()) != null)
            add(element);
    }

    public int size() {
        return size;
    }

    public void add(String text) {
        head = new SingleLinkNode(text, head);
        size++;
    }

    public String getString(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        SingleLinkNode current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current.text;
    }

    public MyIterator iterator() {
        return new LinkedListIterator(head);
    }
}

class LinkedListIterator implements MyIterator {
    private SingleLinkNode current;

    public LinkedListIterator(SingleLinkNode head) {
        current = head;
    }

    @Override
    public String next() {
        if (current == null)
            return null;

        String text = current.text;
        current = current.next;
        return text;
    }
}
