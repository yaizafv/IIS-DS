package es.uniovi.ds.lab.structures;

class DoubleLinkNode {
    String text;
    DoubleLinkNode prev;
    DoubleLinkNode next;

    public DoubleLinkNode(String text, DoubleLinkNode prev, DoubleLinkNode next) {
        this.text = text;
        this.next = next;
        this.prev = prev;
    }
}

public class MyDoubleLinkedList {

    private DoubleLinkNode head;
    private int size;

    public MyDoubleLinkedList() {
        head = null;
        size = 0;
    }

    public MyDoubleLinkedList(MyIterator iterator) {
        this();
        String element;
        while ((element = iterator.next()) != null)
            add(element);
    }

    public int size() {
        return size;
    }

    public void add(String text) {
        head = new DoubleLinkNode(text, null, head);
        if (head.next != null)
            head.next.prev = head;
        size++;
    }

    public String getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        DoubleLinkNode current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current.text;
    }

    public MyIterator iterator() {
        return new DoubleLinkedListIterator(head);
    }
}

class DoubleLinkedListIterator implements MyIterator {
    private DoubleLinkNode current;

    public DoubleLinkedListIterator(DoubleLinkNode head) {
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
