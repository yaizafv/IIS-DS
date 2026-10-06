package es.uniovi.ds.lab.editor.core;

public interface Figure {

    public void draw();

    public boolean contains(int x, int y);

    public void move(int dx, int dy);
}
