package es.uniovi.ds.lab.structures;

public class MyVector {

    private String[] elements;
    private int size;

    public MyVector() {
        elements = new String[20];
        size = 0;
    }

    public MyVector(MyIterator iterator) {
        this();
        String element;
        while ((element = iterator.next()) != null)
            add(element);
    }

    public int size() {
        return size;
    }

    public void add(String text) {
        if (size == elements.length)
            throw new IndexOutOfBoundsException("Vector is full. Cannot add more elements.");

        elements[size] = text;
        size++;
    }

    public String get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return elements[index];
    }

    public MyIterator iterator() {
        return new VectorIterator(this);
    }
}

class VectorIterator implements MyIterator {
    private int currentIndex;
    private MyVector vector;

    public VectorIterator(MyVector vector) {
        this.vector = vector;
        this.currentIndex = 0;
    }

    @Override
    public String next() {
        if (currentIndex >= vector.size())
            return null;

        return vector.get(currentIndex++);
    }
}
