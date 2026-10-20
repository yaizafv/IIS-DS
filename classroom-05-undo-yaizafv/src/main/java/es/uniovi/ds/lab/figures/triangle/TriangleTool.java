
package es.uniovi.ds.lab.figures.triangle;

import java.awt.Point;

import es.uniovi.ds.lab.editor.cambios.CreationChange;
import es.uniovi.ds.lab.editor.core.*;

public class TriangleTool implements Tool {

    private int vertexCount = 0;
    private Point[] vertices = new Point[3];
    private EditorWindow editor;

    public TriangleTool(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        vertices[vertexCount++] = new Point(x, y);
        if (vertexCount == 3) {
            Figure figure = new Triangle(vertices[0], vertices[1], vertices[2]);
            editor.getDrawing().addFigure(figure);
            vertexCount = 0;

            editor.getHistory().addChange(
                    new CreationChange(editor.getDrawing(), figure));

            editor.endTool();
        }
    }

    public void mouseMoved(int x, int y) {
        // No need to do anything
    }

    public void mouseReleased(int x, int y) {
        // No need to do anything
    }

}
