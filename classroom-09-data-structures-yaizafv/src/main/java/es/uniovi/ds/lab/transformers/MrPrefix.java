package es.uniovi.ds.lab.transformers;

import es.uniovi.ds.lab.structures.MyIterator;

public class MrPrefix implements MyIterator {

    private MyIterator nextIterator;

    public MrPrefix(MyIterator nextIterator) {
        this.nextIterator = nextIterator;
    }

    @Override
    public String next() {
        String value = nextIterator.next();
        if (value == null)
            return null;
        return "Mr. " + value;
    }
}
