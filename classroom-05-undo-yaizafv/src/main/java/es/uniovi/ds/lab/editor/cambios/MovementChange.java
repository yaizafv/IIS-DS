package es.uniovi.ds.lab.editor.cambios;

import es.uniovi.ds.lab.editor.core.*;

public class MovementChange implements Change {

    private Figure figure;
    private int dx;
    private int dy;

    public MovementChange(Figure figure, int dx, int dy) {
        this.figure = figure;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void undo() {
        figure.move(-dx, -dy);
    }

    @Override
    public void redo() {
        figure.move(dx, dy);
    }

}
