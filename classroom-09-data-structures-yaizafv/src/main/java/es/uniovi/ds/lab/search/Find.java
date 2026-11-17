package es.uniovi.ds.lab.search;

import es.uniovi.ds.lab.structures.MyIterator;

public class Find {

    // Is this interface really necessary? Does Java already have a similar one that could be used?
    @FunctionalInterface
    public interface ElementMatcher {
        boolean matches(String value);
    }

    public static String findFirst(MyIterator iterator, ElementMatcher matcher) {
        String element;
        while ((element = iterator.next()) != null) {
            if (matcher.matches(element))
                return element;

        }
        return null;
    }
}
