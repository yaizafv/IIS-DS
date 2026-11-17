package es.uniovi.ds.lab.transformers;

import es.uniovi.ds.lab.structures.MyIterator;

// Question: What two DESIGN PATTERNS does this class implement?

public class Filter implements MyIterator {

    // Is this interface really necessary? Does Java already have a similar one that could be used?
    @FunctionalInterface
    public interface Condition {
        boolean isTrue(String value);
    }

    private MyIterator nextIterator;
    private Condition function;

    public Filter(MyIterator nextIterator, Condition condition) {
        this.nextIterator = nextIterator;
        this.function = condition;
    }

    @Override
    public String next() {
        String value;
        do {
            value = nextIterator.next();
            if (value == null)
                return null;
        } while (!function.isTrue(value));
        return value;
    }

}
