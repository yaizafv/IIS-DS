package es.uniovi.ds.lab.transformers;

import es.uniovi.ds.lab.structures.MyIterator;

// This class REPLACES the classes `FirstLetters.java`, `MrPrefix.java`, and `UpperCase.java`
// Question: What two DESIGN PATTERNS does this class implement?

public class Map implements MyIterator {

    // Is this interface really necessary? Does Java already have a similar one that could be used?
    @FunctionalInterface
    public interface Transformation {
        String transform(String value);
    }

    private MyIterator nextIterator;
    private Transformation transformation;

    public Map(MyIterator nextIterator, Transformation transformation) {
        this.nextIterator = nextIterator;
        this.transformation = transformation;
    }

    @Override
    public String next() {
        String value = nextIterator.next();
        if (value == null)
            return null;
        return transformation.transform(value);
    }
}
