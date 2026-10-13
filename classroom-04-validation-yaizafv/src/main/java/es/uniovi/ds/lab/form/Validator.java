package es.uniovi.ds.lab.form;

@FunctionalInterface
public interface Validator {
    public boolean isValid(String text);
}
