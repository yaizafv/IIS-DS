package es.uniovi.ds.lab.editor.cambios;

import es.uniovi.ds.lab.editor.core.*;

public class CreationChange implements Change {

    private Figure figure;
    private Drawing drawing;

    public CreationChange(Drawing drawing, Figure figure) {
        this.figure = figure;
        this.drawing = drawing;
    }

    public void undo() {
        drawing.removeFigure(figure);
    }

    public void redo() {
        drawing.addFigure(figure);
    }

}
