package es.uniovi.ds.lab.form;

public interface Editable {

    String getElementType();

    // Field A ------------
    String getFirstLabel();

    String getFirstValue();

    void setFirstValue(String text);

    // Field B ------------
    String getSecondLabel();

    String getSecondValue();

    void setSecondValue(String text);
}
