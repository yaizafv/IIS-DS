package es.uniovi.ds.lab.editor.tools;

import java.awt.Point;

import es.uniovi.ds.lab.editor.core.*;

public class SelectionTool implements Tool {

    private EditorWindow editor;

    private Figure selectedFigure;
    private Point lastPoint;

    public SelectionTool(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        selectedFigure = editor.getDrawing().getFigure(x, y);
        lastPoint = new Point(x, y);
    }

    public void mouseMoved(int x, int y) {
        moveSelectedFigure(x, y);
    }

    public void mouseReleased(int x, int y) {
        moveSelectedFigure(x, y);
        selectedFigure = null;
    }

    private void moveSelectedFigure(int x, int y) {
        if (selectedFigure != null) {
            selectedFigure.move(x - lastPoint.x, y - lastPoint.y);
            lastPoint = new Point(x, y);
        }
    }

}
