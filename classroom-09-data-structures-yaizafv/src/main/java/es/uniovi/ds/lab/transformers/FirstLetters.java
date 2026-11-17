package es.uniovi.ds.lab.transformers;

import es.uniovi.ds.lab.structures.MyIterator;

public class FirstLetters implements MyIterator {

    private MyIterator nextIterator;

    public FirstLetters(MyIterator nextIterator) {
        this.nextIterator = nextIterator;
    }

    @Override
    public String next() {
        String value = nextIterator.next();
        if (value == null)
            return null;
        return value.substring(0, 4);
    }
}
