package es.uniovi.ds.lab.sets;

import java.util.List;

import es.uniovi.ds.lab.structures.MyIterator;

// Question: What DESIGN PATTERN does this class implement?

public class Concat implements MyIterator {

    private List<MyIterator> iterators;
    private int currentIndex;

    public Concat(MyIterator... iterators) {
        this.iterators = List.of(iterators);
        this.currentIndex = 0;
    }

    @Override
    public String next() {
        while (currentIndex < iterators.size()) {
            String value = iterators.get(currentIndex).next();
            if (value != null)
                return value;
            else
                currentIndex++;
        }
        return null;
    }
}
