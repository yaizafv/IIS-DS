package es.uniovi.ds.lab.editor.tools;

import java.awt.Point;

import es.uniovi.ds.lab.editor.core.*;

public abstract class CreationTool implements Tool {

    protected EditorWindow editor;
    private Point start;

    protected CreationTool(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        start = new Point(x, y);
    }

    public void mouseMoved(int x, int y) {
    }

    public void mouseReleased(int x, int y) {
        Point fin = new Point(x, y);
        Figure figure = doCreateFigure(start, fin);
        editor.getDrawing().addFigure(figure);

        editor.toolFinished();
    }

    protected abstract Figure doCreateFigure(Point start, Point end);

}
