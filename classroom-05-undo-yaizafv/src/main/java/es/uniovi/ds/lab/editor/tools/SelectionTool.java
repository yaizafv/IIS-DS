package es.uniovi.ds.lab.editor.tools;

import java.awt.Point;

import es.uniovi.ds.lab.editor.cambios.MovementChange;
import es.uniovi.ds.lab.editor.core.*;

public class SelectionTool implements Tool {

    private EditorWindow editor;

    private Figure selectedFigure;
    private Point lastPoint;
    private Point initialPoint;

    public SelectionTool(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        initialPoint = new Point(x, y);
        selectedFigure = editor.getDrawing().getFigure(x, y);
        lastPoint = new Point(x, y);
    }

    public void mouseMoved(int x, int y) {
        moveSelectedFigure(x, y);
    }

    public void mouseReleased(int x, int y) {
        moveSelectedFigure(x, y);

        if (selectedFigure != null)
            editor.getHistory().addChange(
                    new MovementChange(selectedFigure, lastPoint.x - initialPoint.x, lastPoint.y - initialPoint.y));

        selectedFigure = null;
    }

    private void moveSelectedFigure(int x, int y) {
        if (selectedFigure != null) {
            selectedFigure.move(x - lastPoint.x, y - lastPoint.y);
            lastPoint = new Point(x, y);
        }
    }

}
