
package es.uniovi.ds.lab.figures.circle;

import java.awt.Point;

import es.uniovi.ds.lab.editor.core.*;
import es.uniovi.ds.lab.editor.tools.CreationTool;

public class CircleTool extends CreationTool {

    public CircleTool(EditorWindow editor) {
        super(editor);
    }

    protected Figure doCreateFigure(Point inicio, Point fin) {
        Point centerPoint = new Point((inicio.x + fin.x) / 2, (inicio.y + fin.y) / 2);
        int radius = Math.max(fin.x - inicio.x, fin.y - inicio.y) / 2;
        return new Circle(centerPoint, radius);
    }
}
